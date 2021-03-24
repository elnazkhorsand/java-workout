package com.serenitydojo.calculator;

public class Calculator {

    private String[] elements;
    private String[] validOperators = new String[]{"+", "-", "*"};
    private String[] numbers;
    private boolean isValidElement = false;

    public int evaluate(String expression) {

        //Checking if the expression is empty return 0.
        if(expression.isBlank())
            return 0;

        //Getting all the elements in the expression and split them by space and keep them in 'elements' array.
        elements = expression.split(" ");

        //Check if the elements are valid or not
        for(String element: elements){
            if (!isNumber(element) && !isValidOperator(element))
                throw new IllegalMathsOperatorException("There is an invalid element in the expression!");
        }



    return calculation();
    }

    private boolean isNumber(String element){
        return element.chars().allMatch(Character::isDigit);
    }

    private boolean isValidOperator(String element){
        for (String operator: validOperators){
            if(element.equals(operator))
                return true;
        }
        return false;
    }

    private int calculation(){
        int firstOperand = 0;
        int secondOperand = 0;
        String operator;
        for(String element: elements){
            if (isNumber(element)) secondOperand = Integer.parseInt(element);
            else if (isValidOperator(element)){
                switch (element) {
                    case "+":
                        firstOperand = firstOperand + secondOperand;
                        break;
                    case "-":
                        firstOperand = firstOperand - secondOperand;
                        break;
                    case "*":
                        firstOperand = firstOperand * secondOperand;
                        break;
                    default:
                        throw new IllegalMathsOperatorException("There is an invalid element in the expression!");
                }

            }
        }
        if(firstOperand == 0) return secondOperand;
        else return firstOperand;
    }

}
