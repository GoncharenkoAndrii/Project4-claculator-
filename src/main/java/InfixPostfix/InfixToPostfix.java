package InfixPostfix;

import Models.Stack;

import java.util.HashMap;

public class InfixToPostfix {
    private static HashMap<Character, Integer> priority = new HashMap<Character, Integer>() {

        {
            put('+', 1);
            put('-', 1);
            put('/', 2);
            put('*', 2);
            put('(', 0);
            put(')', 0);
        }
    };

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String inToPost(String inOrder) {

        Stack<Character> stack = new Stack<Character>();

        String result = "";

        char tmp;
        char[] exp = inOrder.trim().toCharArray();

        for (char iterateOn : exp) {

            if (!isOperator(iterateOn) && (iterateOn != '(') && (iterateOn != ')')) {
                result = result + iterateOn;
            } else if (iterateOn == '(') {
                stack.push(iterateOn);
            } else if (iterateOn == ')') {
                tmp = stack.pop();
                while (tmp != '(') {
                    result = result + tmp;
                    tmp = stack.pop();
                }
                /*tmp = '\0';*/
            } else if (isOperator(iterateOn)) {
                if (!stack.isEmpty()) {
                    tmp = stack.pop();
                    int prio1 = priority.get(tmp);
                    int prio2 = priority.get(iterateOn);
                    while (prio1 >= prio2) {
                        result = result + tmp;

                        prio1 = -1;
                        if (!stack.isEmpty()) {
                            tmp = stack.pop();
                            prio1 = priority.get(tmp);
                        }
                    }
                    if ((prio1 < prio2) && (prio1 != -1)) {
                        stack.push(tmp);
                    }
                }
                stack.push(iterateOn);
            }
        }

        while (!stack.isEmpty()) {
            tmp = stack.pop();
            result = result + tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(inToPost("1+2*3-4/5"));
    }

}
