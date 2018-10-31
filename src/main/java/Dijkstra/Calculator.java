package Dijkstra;

import Exceptions.WrongInputFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Calculator {
    public static void evaluateAndPrintResult(String inString) {

        String[] str = inString.split("\\s+");
        Queue<String> argsBox = new LinkedList<>();
        argsBox.addAll(Arrays.asList(str));
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!argsBox.isEmpty()) { // Read token, push if operator.
            String token = argsBox.poll();
            switch (token) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sin" :
                    ops.push(token);
                    break;
                case "sqrt":
                    ops.push(token);
                    break;
                case ")":
                    vals.push(evaluateOp(ops, vals));
                    break;
                default:
                    // Token not operator or paren: push double value.
                    try {
                    vals.push(Double.parseDouble(token));
                    break;
                    }
                    catch (WrongInputFormat e){
                        System.out.println("wrong input");
                    }
            }
        }
        System.out.println(inString + " = " + evaluateOp(ops, vals));
    }

    private static Double evaluateOp(Stack<String> ops, Stack<Double> vals) {
        // Replace the top exp with its result.
        double v = vals.pop();
        if (!ops.empty()) {
            String op = ops.pop();
            switch (op) {
                case "+":
                    v = vals.pop() + v;
                    break;
                case "-":
                    v = vals.pop() - v;
                    break;
                case "*":
                    v = vals.pop() * v;
                    break;
                case "/":
                    v = vals.pop() / v;
                    break;
                case "sqrt":
                    v = Math.sqrt(v);
                    break;
                case "sin" :
                    v = Math.sin(v);
                default:
                    break;
            }
        }
        return v;
    }
    private static Queue<String> parseString (String inputString){
        String[] str = inputString.split("\\s+");
        Queue<String> argsBox = new LinkedList<>();
        argsBox.addAll(Arrays.asList(str));
        return argsBox;
    }


}