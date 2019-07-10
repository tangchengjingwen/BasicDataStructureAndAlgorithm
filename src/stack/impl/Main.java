package stack.impl;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 16:45
 * Description :
 */
public class Main {
    public static void main(String[] args) {

        ArrayStackImpl<Integer> stack = new ArrayStackImpl<>();

        stack.push(1);
        stack.print();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println();
        System.out.println(stack.peek());
        stack.print();
        System.out.println();
        System.out.println("stack.pop(): " + stack.pop());
        stack.print();

        System.out.println("=========================================");

        LinkedListStackImpl<Integer> stack2 = new LinkedListStackImpl<>();
        stack2.push(1);
        stack2.print();

        for (int i = 0; i < 10; i++) {
            stack2.push(i);
        }
        System.out.println();
        stack2.print();
        System.out.println();
        System.out.println("stack2.pop(): " + stack2.pop());
        stack2.print();
    }
}
