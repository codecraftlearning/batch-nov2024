package nov08;

public class Calculator {

    public static int sum (int n1, int n2) {
        return n1 + n2;
    }

     public static int sum (int n1, int n2, int n3) {
        return n1 + n2 + n3;
     }

     public static int sum (int ...n) {
        int sum = 0;
         for (int j : n) {
             sum += j;
         }

         return sum;
     }

}
