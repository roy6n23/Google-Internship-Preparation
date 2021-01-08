class RangeModule {
    /**
     * 类似Guava的RangeSet，使用一个有序Map存储所有区间，按区间下边界排序，
     * 假设三种操作指定的区间为i，三种操作都需要先找到两个区间l和r，满足如下条件：
     * 此时是L在左边相交于i，r在右边相交于i
     * l.left <  i.left && l.right >= i.left  且 l.left最大
     * r.left >= i.left && r.left  <= i.right 且 r.left最大
     * l、r可能为null、与interval无交集（上边界与下边界相等），与interval有交集
     *
     * add: 创建一个新的区间，删除l和r之间的所有区间
     *      new.left  = min(l.left, i.left)
     *      new.right = max(l.right, r.right, i.right)
     * del: 更新两个区间l和r，删除l和r之间的所有区间
     *      l.left  = min(l.left, i.left)
     *      l.right = i.left  （需排除l.left  == i.left 情况）
     *      r.left  = i.right （需排除r.right == i.right情况）
     *      r.right = max(l.right, r.right, i.right)
     * query: (l.right >= i.right) || (r.left == i.left && r.right >= i.right)
     */
    private TreeMap<Integer, Range> ranges = new TreeMap<>();  // 下边界作为key

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        Range l = getLeftRange(left, right);
        Range r = getRightRange(left, right);
        int lower = getLower(l, r, left, right);
        int upper = getUpper(l, r, left, right);
        //移除中间的区间们
        ranges.subMap(lower, upper).clear();

        ranges.put(lower, new Range(lower, upper));
    }

    public boolean queryRange(int left, int right) {
        Range l = getLeftRange(left, right);
        Range r = getRightRange(left, right);
        if ((l != null && l.right >= right) || (r != null && r.left == left && r.right >= right)) {
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        Range l = getLeftRange(left, right);
        Range r = getRightRange(left, right);
        int lower = getLower(l, r, left, right);
        int upper = getUpper(l, r, left, right);
        ranges.subMap(lower, upper).clear();

        if (lower < left) {  // l为null时两者相等
            ranges.put(lower, new Range(lower, left));
        }

        if (right < upper) {  // r为null时两者相等
            ranges.put(right, new Range(right, upper));
        }
    }

    private Range getLeftRange(int left, int right) {
        Map.Entry<Integer, Range> entry = ranges.lowerEntry(left);
        if (entry != null && entry.getValue().right >= left) {
            return entry.getValue();
        }
        return null;
    }

    private Range getRightRange(int left, int right) {
        Map.Entry<Integer, Range> entry = ranges.floorEntry(right);
        if (entry != null && entry.getValue().left >= left) {
            return entry.getValue();
        }
        return null;
    }

    private int getLower(Range l, Range r, int left, int right) {
        return l != null ? Math.min(l.left, left) : left;
    }

    private int getUpper(Range l, Range r, int left, int right) {
        int upper = r != null ? Math.max(r.right, right) : right;
        upper = l != null ? Math.max(upper, l.right) : upper;
        return upper;
    }

    private static class Range {
        int left;
        int right;
        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */

作者：skywalker-x
链接：https://leetcode-cn.com/problems/range-module/solution/java-treemap-by-skywalker-x/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。