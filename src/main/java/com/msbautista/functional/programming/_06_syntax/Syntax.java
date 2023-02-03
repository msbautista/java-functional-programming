package com.msbautista.functional.programming._06_syntax;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class Syntax {

    public static void main() {

        //Una función puede ser definida de la siguiente manera:
        Function<String, String> funFunction = s -> "";

        //Si queremos ser muy específicos con el tipo:
        Function<String, String> boringFunction = (String s) -> "";

        //También si nuestra función es muy extensa podemos usar {}
        Function<String, String> notFun = s -> {
            System.out.println("Ejecutando… 1");
            System.out.println("Ejecutando… 2");
            System.out.println("Ejecutando… 3");
            return "";
        };

        /* La variante empieza cuando tenemos más de un parámetro, pues nos vemos obligado a agrupar los parámetros entre
        paréntesis.
        */
        BiFunction<String, String, Integer> biFunFunction = (xs, s) -> 0;

        //Incluso si ponemos el tipo explicito
        BiFunction<String, String, Integer> notFunBiFunction = (String xs, String s) -> 0;

        /* Si nuestra función (un Consumer también es una función) no hace nada,
        Java nos exige que usemos { } como cuerpo de nuestra función. */
        Consumer<String> consumer = s -> {
        };

        // Y si nuestra función no toma parámetros… Java nos exige que usemos () para indicar la ausencia de los mismos:
        Supplier<String> textSupplier = () -> "Hello Platzi";

        //Una funciona lambda, es una función que no tiene nombre y se usa una sola vez
        List<String> names = Arrays.asList("Fabian", "Camilo");
        //Lo que está al interior del método foreach es una función que se está declarando exactamente donde se va a usar y no se está almacenando en una variable.
        names.forEach(x -> System.out.println(x));
    }
}


