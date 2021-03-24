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

        for(String element: elements){
            if (!checkValidity(element))
                throw new IllegalMathsOperatorException("There is an invalid element in the expression");
        }

    return -1;
    }

    private boolean checkValidity(String element){
        for (String operator: validOperators){
            if(element.equals(operator))
                return true;
        }
        return element.chars().allMatch(Character::isDigit);
    }

}
