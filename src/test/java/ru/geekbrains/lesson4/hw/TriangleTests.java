package ru.geekbrains.lesson4.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTests {

    Triangle triangle = new Triangle();

    @Test
    void isTriangleExist(){
        double result = triangle.triangleSquare(1, 2, 3);
        Assertions.assertEquals(0, result);
    }

    @Test
    void egyptianTriangleSquareTest() {
        double result = triangle.triangleSquare(3, 4, 5);
        Assertions.assertEquals(6, result);
    }

    @Test
    void TriangleSquareTest() {
        double result = triangle.triangleSquare(8, 15, 17);
        Assertions.assertEquals(60, result);
    }

}