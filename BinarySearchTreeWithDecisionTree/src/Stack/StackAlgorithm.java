package Stack;

/**
 * @Author Sathiyaraj created on 16-02-2022
 * <p>
 * TODO
 */


public class StackAlgorithm {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("One plus");
        System.out.println(s.peek());

        s.push("Samsung");
        s.push("Apple");
        s.push("Mi");
        System.out.println(s);

        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
