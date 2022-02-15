package Stack;

/**
 * @Author Sathiyaraj created on 15-02-2022
 * <p>
 * TODO
 */


public class StackDataStructure {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push("Sathiyaraj");
        s.push("Ramamurthy");
        s.push("Padmavathi");
        s.push("Kavi");
        s.push(45);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

class Stack {
    private Object[] stackList;
    private int size;
    private int top;
    public Stack(int size) {
        this.size = size;
        this.stackList = new Object[size];
        this.top = 0;
    }

    public void push(Object insertValue) {
        if(isFull()){
            System.out.println("Stack is full");
            System.exit(0);
        } else {
            stackList[top] = insertValue;
            top++;
        }
    }

    public Object pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(0);
        } else {
            return stackList[--top];
        }
        return null;
    }

    public boolean isEmpty(){
        return top == 0 ? true: false;
    }

    public boolean isFull() {
        return top == size ? true: false;
    }
}