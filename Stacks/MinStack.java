// Min Stack : always keeps track of minimum element in stack

static class MinStack{
    Stack<Integer> data;
    Stack<Integer> minStack;
    MinStack(){
        this.data = new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(int value){
        data.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }else{
            if(value < minStack.peek()){
                minStack.push(value);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }
    public void pop(){
        data.pop();
        minStack.pop();
    }
    public int getMin(){
        return minStack.peek();
    }
    public int top(){
        return data.peek();
    }
}
void main(){
    MinStack ms = new MinStack();
    ms.push(0);
    ms.push(3);
    ms.push(9);
    ms.push(8);
    System.out.println(ms.getMin());
    ms.pop();
    System.out.println(ms.top());
}