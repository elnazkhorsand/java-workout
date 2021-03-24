package com.serenitydojo.calculator;

import java.util.ArrayList;

public class Calculator {

    private String[] elements;
    private String[] validOperators = new String[]{"+", "-", "*"};
    private ArrayList<Integer> operands = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
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
            else if (isNumber(element)) operands.add(Integer.parseInt(element));
            else operators.add(element);
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
        int secondOperand;
        int result;

        if (operators.size()==0) return operands.get(0);
        else {

            result = operands.get(0);

            for (int i = 1 ; i<operands.size() ; i++){
                secondOperand = operands.get(i);


                switch (operators.get(i-1)){
                    case "+":
                        result = result + secondOperand;
                        break;
                }

            }
        }
    return result;
    }

}
