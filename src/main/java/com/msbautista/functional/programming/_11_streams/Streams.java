package com.msbautista.functional.programming._11_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    Un Stream es una clase que nos permite aplicar operaciones paso a paso a colecciones de datos (Lists, Sets).
 */

public class Streams {

    public static void main(String[] args) {
        List<String> courseList = Arrays.asList("Java", "Spring Boot", "Backend", "Frontend", "FullStack");
        //Esta es una forma común de iterar una lista y mostrar los elementos en pantalla.
        for (String course : courseList) {
            System.out.println(course);
        }
        //Esta es una forma de iterar una lista y mostrar los elementos en pantalla a través de la clase Stream.
        courseList.stream().forEach(System.out::println);

        //Podemos crear un Stream de Strings con Stream.of (Similar a Arrays.asList)
        Stream<String> namesStream = Stream.of("Andres", "Valentina", "Santiago", "Camila");
        //Podemos crear un nuevo Stream a partir de otro, con el método map.
        Stream<Integer> nameLengthStream = namesStream.map(name -> name.length());

        //Y podemos concatenar o realizar operaciones en cadena (chaining) sobre un stream.
        Stream<String> foodStream = Stream.of("Burger", "Pizza", "Chicken");
        foodStream
                .map(x -> x + "!") //Generamos un nuevo stream en que el que cada comida tiene un signo de exclamación.
                .filter(x -> x.contains("zz")) //Buscamos todos los elementos del stream que contengan "zz" dentro de la palabra.
                .forEach(System.out::println); //Y finalmente mostramos cada uno de los elementos resultantes.

        //Podemos generar nuestras propias funciones que reciban Streams y devuelvan Streams.
        addOperator(
                courseList.stream()
                        .filter(x -> x.contains("Java"))
                        .map(x -> x.toUpperCase())
        ).forEach(System.out::println);

        /*
         Los Streams son de un solo uso, es decir, que si se quiere operar con un mismo stream varias veces, se debe
         crear uno nuevo cada vez.
         Aquí saltará una excepción porque el stream ya fue consumido en la línea 29:
         */
        foodStream.forEach(System.out::println);
    }

    static <T> Stream<T> addOperator(Stream<T> stream) {
        /*
            Peek es método de la clase stream que sirve para iterar los datos, sin modificarlos.
            Recibe uns stream de un tipo de dato y devuelve ese mismo Stream
         */
        return stream.peek(x -> System.out.println("Data: " + x));
    }

}
