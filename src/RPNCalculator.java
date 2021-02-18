import java.util.Scanner;

public class RPNCalculator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        String expression = null;
        do
        {
            System.out.println("Enter an RPN expression or <CR> to exit");
            expression = kbd.nextLine();
            if (expression.length() > 0)
            {
                String result = RPNEvaluator.evaluate(expression);
                System.out.println(result + "\n");
            }
        } while (expression.length() > 0);
        System.out.print("Exiting...");
    }
}
