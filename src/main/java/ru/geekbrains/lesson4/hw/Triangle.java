package ru.geekbrains.lesson4.hw;

public class Triangle {

    public static double triangleSquare(double a, double b, double c){
        if ((a > 0) && (b > 0) && (c > 0) &&
            ((a + b) > c) && ((a + c) > b) && ((b + c) > a)){
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
            }
        else {
            return 0.0;
        }
    }

}
