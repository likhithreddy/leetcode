class StackNode {
    int value;
    int min;

    public StackNode(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class MinStack {
    Stack<StackNode> stack;

    public MinStack() {
        stack = new Stack<>();

    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : (stack.peek().min < val) ? stack.peek().min : val;
        stack.push(new StackNode(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}