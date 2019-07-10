package stack.leetcode;

import java.util.Stack;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-05
 * Time : 18:17
 * Description :
 */
public class MinStack2 {

    private Stack<Integer> stack;
    private int min; //记录最小值，每次有更小的值push进来就把min push到stack

    public MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
