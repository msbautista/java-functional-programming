package com.msbautista.functional.programming._12_final_operations;

import java.util.Arrays;
import java.util.List;

public class FinalOperations {

    /*
     Las operaciones terminales son aquellas que no generan un Stream como resultado.
     Su resultado puede variar según la operación.
     Este resultado es el que finalmente se espera después de iterar los datos.
     Las operaciones terminales son las siguientes:

     -anyMatch(): Este método devuelve un valor booleano que indica si al menos uno de los elementos del stream coincide con un predicado dado.
     -allMatch(): Este método devuelve un valor booleano que indica si todos los elementos del stream coinciden con un predicado dado.
     -noneMatch(): Este método devuelve un valor booleano que indica si ninguno de los elementos del stream coincide con un predicado dado.
     -findAny(): Este método devuelve un elemento arbitrario del stream. Es útil cuando solo se necesita un elemento del stream y no importa cuál sea.
     -findFirst(): Este método devuelve el primer elemento del stream. Es útil cuando se necesita el primer elemento del stream.
     -min(): Este método devuelve el elemento más pequeño del stream, según el orden natural de los elementos o según un comparador dado.
     -max(): Este método devuelve el elemento más grande del stream, según el orden natural de los elementos o según un comparador dado.
     -reduce(): Este método permite combinar todos los elementos de un stream en un solo resultado, utilizando una función dada. Por ejemplo, se puede sumar todos los elementos de un stream utilizando el método reduce.
     -count(): Este método devuelve el número de elementos en el stream.
     -toArray(): Este método devuelve un arreglo que contiene todos los elementos del stream.
     -collect(): Este método permite coleccionar los elementos del stream en una colección o estructura de datos específica, como una lista o un conjunto.
     -forEach(): Este método aplica una función dada a cada elemento del stream. Es similar a un bucle for-each.
     */

    public static void main(String[] args) {
        //Ejemplo con el método reduce:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                //Subtotal es el valor acumulado y element es el siguiente elemento del stream | Accumulator
                .reduce(0, Integer::sum);
        System.out.println(result);

        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        int computedAges =
                users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
        System.out.println(computedAges);
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


}
