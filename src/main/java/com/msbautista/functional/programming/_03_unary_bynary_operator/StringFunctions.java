package com.msbautista.functional.programming._03_unary_bynary_operator;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {

    /*
      UnaryOperator -> Es una función que recibe un tipo y genera un resultado del mismo tipo.
      BiFunction -> Recibe dos tipos de datos y genera un tercer tipo de dato.
         Puede tener diferentes tipos de entrada, como también diferentes tipos de salida.
      BinaryFunction -> Recibe un tipo de dato. Los dos argumentos y el resultado van a ser del tipo declarado.
         Tiene dos parameters de entrada y uno de retorno.
    */

    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        System.out.println(quote.apply("Hola"));

        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        System.out.println(multiply.apply(4, 5));

        BinaryOperator<Integer> multiplyWithBinaryOperator = (x, y) -> x * y;
        System.out.println(multiply.apply(4, 5));

        List<BiFunction<String, Integer,String>> formatters;
    }

}
