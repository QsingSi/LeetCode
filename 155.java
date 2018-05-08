class MinStack {

    public Stack<Integer> st;
    public List<Integer> nums;

    /** initialize your data structure here. */
    public MinStack() {
        this.st = new Stack<>();
        this.nums = new ArrayList<>();
    }

    public void push(int x) {
        this.nums.add(x);
        this.st.push(x);
    }

    public void pop() {
        nums.remove(this.st.pop());

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        Collections.sort(nums);
        return nums.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */