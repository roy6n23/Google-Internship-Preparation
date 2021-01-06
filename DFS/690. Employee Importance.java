/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
     // 方法1：普通递归，思路最简单，一看到题目就能想到
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees) { 
            if (e.id == id) {
                if (e.subordinates.size() == 0) {  // 没有子结点
                    return e.importance;
                }
                for (int subId: e.subordinates) {
                    e.importance += getImportance(employees, subId);
                }
                return e.importance;
            }
        }
        return 0;
    }
    
     // 方法2：递归 + Map优化  每次递归时都遍历employees进行线性查找，可用map存储employee进行查询优化
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        return getImportanceHelper(map, id);
    }
    
    public int getImportanceHelper(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        for (int subId: employee.subordinates) {
            employee.importance += getImportanceHelper(map, subId);
        }
        return employee.importance;
    }
    
    
    /* 方法3：用队列或者栈存放待处理的结点，不用递归 */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int result = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            result += e.importance;
            for (int subId: e.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        return result;
    }
}