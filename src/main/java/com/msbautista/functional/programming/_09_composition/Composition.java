package com.msbautista.functional.programming._09_composition;

import java.util.function.Function;

/*
    Conocimiento previo: Funciones de orden mayor, es la que toma como parámetro una función o regresa de resultado una función

    Composición de funciones
    La composición de funciones consta en crear dos o más funciones y asignarlas de forma tal que el resultado de una sea tomado como parámetro de otra.

    -compose: Permite agregar pasos antes de la ejecución de una función (La lambda se ejecuta antes de la función que llama a compose)
    -andThen: Permite agregar pasos después de la ejecución de una función(La lambda se ejecuta después de la función que llama a andThen)
 */
public class Composition {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy3 = x -> x * 3;

        //Que pasa si yo quiero añadir uno antes de multiplicar por 3
        Function<Integer, Integer> add1BeforeMultiplyBy3 =
                multiplyBy3.compose(x -> {
                    System.out.println("Add 1 to " + x);
                    return x + 1;
                });

        // Y si yo quiero que después de multiplicar por 3 me divida en 2
        Function<Integer, Integer> divideBy2AfterAdd1AndMultiplyBy3 =
                add1BeforeMultiplyBy3.andThen(x -> {
                    System.out.println("Divide by 2");
                    return x / 2;
                });

        System.out.println(divideBy2AfterAdd1AndMultiplyBy3.apply(3));
        ;
    }

}
