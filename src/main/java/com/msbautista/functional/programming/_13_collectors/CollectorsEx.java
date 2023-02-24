package com.msbautista.functional.programming._13_collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsEx {

    /*
    En Java Stream, Collectors es una clase que proporciona una serie de métodos que se pueden usar para coleccionar
    los elementos de un Stream en una estructura de datos específica, como una lista, conjunto o mapa.

    En lugar de simplemente obtener los elementos de un Stream, los Collectors permiten procesar y transformar
    los elementos en una colección o estructura de datos que se adapte mejor a los requisitos de su aplicación.
     */

    public static void main(String[] args) {
        Stream<String> courses = Stream.of("Java", "Javascript");
        List<String> javaCourses = getJavaCourses(courses);

        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        List<Integer> numbersList = infiniteStream.limit(1000)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        /*
        Se utiliza para convertir un stream de tipos primitivos en un stream de tipos envoltorios
        (clases que encapsulan tipos primitivos como Integer, Double, Long, etc).

        En este ejemplo, IntStream es un stream de enteros primitivos y usamos el método boxed() para convertirlo en un
        stream de objetos Integer.
        */
    }

    static List<String> getJavaCourses(Stream<String> coursesStream) {
        List<String> javaCourses =
                coursesStream.filter(course -> course.contains("Java"))
                        .collect(Collectors.toList());

        return javaCourses;
    }

}
