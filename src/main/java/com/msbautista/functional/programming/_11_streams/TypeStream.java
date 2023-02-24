package com.msbautista.functional.programming._11_streams;

import java.util.stream.IntStream;

public class TypeStream {
    public static void main(String[] args) {
        //Stream compuesto por números enteros que itera desde 0 hasta el infinito.
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        /*
        Soporte para concurrencia: parallel()
        Ayuda a que el stream se ejecute de manera concurrente.
        Si nuestro procesador tiene cuatro núcleos se ejecutaran cuatro operaciones a la vez.
         */
        infiniteStream
                .limit(1000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
        /*
         No se necesita crear hilos ni nada, Stream se encargará de administrar la concurrencia
         Es recomendable usar parallel cuanto tengas muchos datos que iterar
         Si son pocos o si te importa el orden de los datos, es mejor no usar parallel()
        */
    }
}