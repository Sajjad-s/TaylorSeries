import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int power(int x, int n) {
        return (int) Math.pow(x, n);
    }

    public int fact(int n) {
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }

    public double fract(int f, int p) {
        return (float) f / p;
    }

    public float resultFraction(ArrayList<Float> arrayList) {
        float result = 0;
        for (Float i : arrayList) {
            result += i;
        }
        return result;
    }

    public void printSequenceResult(int x, int n ,float c) {
        int flag = 1;
        for(int i = 2 ; i <= n ;  i += 2 ) {
            System.out.print("1 - " + "(" + x + "^" + i + ")" +"/" + i + "!" );

            if (i == n || i == n-1 ) {
                System.out.print(" = ");
            }
            else if(flag % 2 == 0 && i < n)
                System.out.print("  +  ");
            else
                System.out.print("  -  ");
            flag++;
        }
        System.out.println(" " + c);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the X: ");
        int base = Integer.parseInt(keyboard.nextLine());

        System.out.println("Enter the  n: ");
        int n = Integer.parseInt(keyboard.nextLine());

        ArrayList<Float> fractArray = new ArrayList<>();
        int i = 0;
        do {
            i += 2;
            if (fractArray.size() % 2 == 0)
                fractArray.add((float) obj.fract(obj.power(base, i), obj.fact(i)));
            else
                fractArray.add(-1 * ((float) obj.fract(obj.power(base, i), obj.fact(i))));
        } while (i <= n - 2);

//        fractArray.forEach((iterator) -> System.out.println("ArrayList: " + iterator));
//        System.out.println("Result of Squence is: " + obj.resultFraction(fractArray));
        obj.printSequenceResult(base, n, obj.resultFraction(fractArray));
    }
}


