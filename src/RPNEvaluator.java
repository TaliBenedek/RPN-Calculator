import java.util.EmptyStackException;
import java.util.Stack;

public class RPNEvaluator {
    private enum Validity
    {
        TOOFEWOPERANDS,
        ILLEGALSYMBOL,
        LOGICALEXPRESSION;
    }

    /**
     * Returns the evaluated RPN expression that was passed as an argument
     * @param expression the RPN expression the user wants evaluated
     * @return the evaluated RPN expression
     */
    public static String evaluate(String expression)
    {
        Stack<Double> numStack = new Stack<>();
        String[] expressionAsArray = expression.split(" ");
        Validity isValid = Validity.LOGICALEXPRESSION;
        double dResult = 0;
        for (String element : expressionAsArray)
        {
            if(!isNumeric(element) && !isOperator(element))
            {
                isValid = Validity.ILLEGALSYMBOL;
                break;
            }

            else if (isOperator(element))
            {
                try
                {
                    String operator = element;
                    double operand1 = numStack.pop();
                    double operand2 = numStack.pop();
                    if (operator.equals("+"))
                        dResult = operand2 + operand1;
                    if (operator.equals("-"))
                        dResult = operand2 - operand1;
                    if (operator.equals("*"))
                        dResult = operand2 * operand1;
                    if (operator.equals("/"))
                        dResult = operand2 / operand1;
                    numStack.push(dResult);
                }
                catch (EmptyStackException e)
                {
                    isValid = Validity.TOOFEWOPERANDS;
                }
            }

            else
            {
                double number = Double.parseDouble(element);
                numStack.push(number);
            }
        }
        return determineResult(isValid, numStack);
    }

    private static Boolean isNumeric(String item)
    {
        try
        {
            Double.parseDouble(item);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    private static Boolean isOperator(String item)
    {
        return (item.equals("*") || item.equals("+") || item.equals("-") || item.equals("/"));
    }

    private static String determineResult(Validity logical, Stack<Double> dblStack)
    {
        String result = null;
        switch (logical)
        {
            case TOOFEWOPERANDS:
                result = "Not enough operands";
                break;
            case ILLEGALSYMBOL:
                result = "Illegal symbol(s)";
                break;
            default:
                result = String.valueOf(dblStack.pop());
                if(!dblStack.empty())
                {
                    result = "Too many operands or not enough operators";
                }
                break;
        }
        return result;
    }
}
