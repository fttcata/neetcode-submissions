class MinStack {

    PriorityQueue<Integer> que;
    List<Integer> arr;
    public MinStack() {
        que = new PriorityQueue<>();
        arr = new ArrayList<>();
    }
    
    public void push(int val) {
        que.add(val);
        arr.add(val);
    }
    
    public void pop() {
        que.remove(arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
    }
    
    public int top() {
        return arr.get(arr.size()-1);
    }
    
    public int getMin() {
       return que.peek();
    }
}
