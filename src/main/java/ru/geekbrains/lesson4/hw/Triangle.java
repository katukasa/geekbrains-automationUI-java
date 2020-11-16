package ru.geekbrains.lesson4.hw;

public class Triangle {

    public static void main(String[] args) {

    }

    public void triangleSquare(double a, double b, double c){
        double p = (a + b + c) / 2;
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(square);
    }

}
