package com.msbautista.functional.programming._01_function_predicate;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        //Declarar una función
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(squareFunction.apply(5));
        //Otra forma de trabajar con funciones
        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;
        System.out.println(isOdd.apply(8));

        //Predicate es una función que recibe un dato y retorna un boolean.
        Predicate<Integer> isEven = x -> x % 2 == 0;
        //Para función isEvent usamos el método test.
        System.out.println(isEven.test(4));
    }
}
