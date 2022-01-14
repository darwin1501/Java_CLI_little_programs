package com.darwin.small_programs.stack_expression;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class StackExpression {

    public void evaluate(){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> operands = new Stack<>();  //Operand stack
        Stack<Character> operations = new Stack<>();  //Operator stack

        while (true) {
            System.out.print("Enter Expression: ");
            String exp = sc.next();

            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);
                if (Character.isDigit(c))   //check if it is number
                {
                    //Entry is Digit, and it could be greater than a one-digit number
                    int num = 0;
                    while (Character.isDigit(c)) {
                        num = num * 10 + (c - '0');
                        i++;
                        if (i < exp.length()) {
                            c = exp.charAt(i);
                        } else {
                            break;
                        }
                    }
                    i--;
                    operands.push(num);
                } else if (c == '(') {
                    operations.push(c);   //push character to operators stack
                }
                //Closed brace, evaluate the entire brace
                else if (c == ')') {
                    while (operations.peek() != '(') {
                        int output = performOperation(operands, operations);
                        operands.push(output);   //push result back to stack
                    }
                    operations.pop();
                }

                // current character is operator
                else if (isOperator(c)) {
                    while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                        int output = performOperation(operands, operations);
                        operands.push(output);   //push result back to stack
                    }
                    operations.push(c);   //push the current operator to stack
                }
            }

            while (!operations.isEmpty()) {
                int output = performOperation(operands, operations);
                operands.push(output);   //push final result back to stack
            }
//        return operands.pop();
            System.out.println("Your expression: " + exp);
            System.out.println("Result: " + operands.pop());
            System.out.println();
            System.out.println("Do you want to enter expression again:?Yes[y] or No[n]");
            String decision = sc.next();
            if (Objects.equals(decision, "n") || Objects.equals(decision, "N")) {
                break;
            }
        }
    }

    static int precedence(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public int performOperation(Stack<Integer> operands, Stack<Character> operations)
    {
        int a = operands.pop();
        int b = operands.pop();
        char operation = operations.pop();
        switch (operation)
        {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                {
                    System.out.println("Cannot divide by zero");
                    return 0;
                }
                return b / a;
        }
        return 0;

    }

    public boolean isOperator(char c)
    {
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
}
