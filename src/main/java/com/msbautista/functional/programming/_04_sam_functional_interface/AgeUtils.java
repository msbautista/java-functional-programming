package com.msbautista.functional.programming._04_sam_functional_interface;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

/*
    SAM - Single Abstract Method: Una interfaz de un solo método sin definir.

    Con una interfaz funcional podremos crear nuestras propias functions con los argumentos que necesitamos.
    Es básicamente como tener nuestros propios métodos similares BiFunction, UnaryFunction, etc.
 */
public class AgeUtils {

    /*
     @FunctionalInterface
     Define que esta interfaz será usada como una función.
     Se utiliza para garantizar que la interfaz no pueda tener más de un método abstracto.
     */
    @FunctionalInterface
    interface BiConsumer {
        void accept();
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        //Las letras representan datos genéricos, quiere decir que desconocemos el tipo de dato con el que se va a trabajar.
        R myMethodApply(T t, U u, V v);
    }

    public static void main(String[] args) {
        Function<Integer, String> addZeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" + addZeros.apply(month) + "-" + addZeros.apply(day));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(parseDate.myMethodApply(day, month, year), LocalDate.now()).getYears();

        System.out.println(calculateAge.myMethodApply(27, 3, 2001));
    }

}
