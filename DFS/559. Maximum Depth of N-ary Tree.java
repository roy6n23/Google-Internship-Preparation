/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
//===================DFS recursive================
class Solution {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;

        int depth = 0;
        for(int i =0; i < root.children.size(); i++){
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }

        return depth+1;
    }

    //================BFS iterative

    public int maxDepth(Node root){
        if(root == null)
            return 0;

        if(root.children.size()==0)
            return 1;

        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            depth++;
            //这一段 可以等同于用for循环
            while(count > 0){
                Node node = queue.poll();
                if(node.children.size() != 0)
                    queue.addAll(node.children);
                count--;
            }
            //上下意思一样
            for(int i = 0; i < count; i++){
                Node node = queue.poll();
                if(node.children.size() != 0)
                    queue.addAll(node.children);
            }
        }
        return depth;
    }

    //==============BFS iterative迭代
    public int maxDepth(Node root){
        if(root == null)
            return 0;

        if(root.children.size() == 0)
            return 1;

        int depth = 0;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){

        }
    }
}