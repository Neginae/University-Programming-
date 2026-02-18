public class Calculator {

     public static void main(String[] args) {
          
          if (args.length < 3) {
               System.out.println("too few arguments, expected: operand operator operand");
               return;
          }

          if (args.length > 3) {
               System.out.println("too many arguments, expected: operand operator operand");
               return;
          }

          double firstOperand;
          double secondOperand;

          try {
               firstOperand = Double.parseDouble(args[0]);
          } catch (NumberFormatException e) {
               System.out.println("first operand is no number: " + args[0]);
               return;
          }

          try {
               secondOperand = Double.parseDouble(args[2]);
          } catch (NumberFormatException e) {
               System.out.println("second operand is no number: " + args[2]);
               return;
          }

          String operator = args[1];
          double result;

          switch (operator) {
               case "+":
                    result = firstOperand + secondOperand;
                    break;
               case "-":
                    result = firstOperand - secondOperand;
                    break;
               case "*":
                    result = firstOperand * secondOperand;
                    break;
               case "/":
                    if (secondOperand == 0) {
                         System.out.println("division by zero");
                         return;
                    }
                    result = firstOperand / secondOperand;
                    break;
               default:
                    System.out.println("unknown operator \" + operator + \", supported operators: + - * /");
                    return;
          }
          System.out.println(result);
     }
}
