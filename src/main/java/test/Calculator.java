package test;

public class Calculator {

    public static double addTwoDoubles(double a, double b) {
        return a + b;
    }

    public static int addTwoIntegers(int a, int b) {
        if (a > 100 || b > 100) {
            throw new IllegalArgumentException("Your numbers is too big");
        }
        return a + b;
    }

    public static int subtractTwoIntegers(int a, int b){
        if (b > a){
            throw new IllegalArgumentException("Number B is bigger than A");
        }
        return a - b;
    }

}
