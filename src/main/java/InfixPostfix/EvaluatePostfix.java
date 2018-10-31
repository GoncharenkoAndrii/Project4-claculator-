package InfixPostfix;

import Models.Stack;

public class EvaluatePostfix {

    public static double evaluatePostfix(char[] src) {
        Stack<Double> nums = new Stack<Double>();
        double num1, num2;

        for (char c : src) {
            if (!InfixToPostfix.isOperator(c)) {
                nums.push(Double.valueOf(c + ""));
            } else {
                num2 = nums.pop();
                num1 = nums.pop();
                switch (c) {
                    case '+':
                        nums.push(num1 + num2);
                        break;
                    case '-':
                        nums.push(num1 - num2);
                        break;
                    case '*':
                        nums.push(num1 * num2);
                        break;
                    case '/':
                        nums.push(num1 / num2);
                        break;
                }
            }
        }

        return nums.peek();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("123*+45/-".toCharArray()));
    }

}
