package com.msbautista.functional.programming._10_optionals;

import java.util.*;

/*
    Un Java Optional es una clase que nos permite manejar datos que pueden ser nulos
    Un Optional en Java es una clase que envuelve otro tipo de objeto y te permite expresar de manera más clara
    que un valor puede ser nulo

    Los Optional se utilizan en Java principalmente para mejorar la legibilidad y la seguridad del código, y
    para evitar errores en tiempo de ejecución debido a valores nulos.

    Optional se debe usar para información que se retorna, en lugar de información que se recibe (a través de parámetros, por ejemplo).
    Esto se considera una buena práctica.
 */

public class Optionals {

    public static void main(String[] args) {
        //Esta es la opción mas común para validar si un dato es nulo.
        List<String> names = getNames();
        if (names != null) {
            //Operar con names
        }
        //Pero también podemos usar la clase optional para validar.
        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){

        }

        /* Las funciones lambdas pueden ser usadas por la clase optional.
        En este ejemplo se pasa una función lambda que se ejecuta en caso de que el valor del optional no sea nulo. */
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> optionalValuablePlayer = optionalValuablePlayer();
        //Obtener el valor dentro del optional, pero si este no existe, ejecutar un supplier.
        String s = optionalValuablePlayer.orElseGet(() -> "No Player");
    }

    //Métodos que pueden retornar null
    static List<String> getNames() {
        List<String> list = new LinkedList<>();

        return Collections.emptyList();
    }

    static String mostValuablePLayer() {
        return null;
    }

    //Métodos que usan Optional
    static Optional<List<String>> getOptionalNames() {
        List<String> namesList = new LinkedList<>();
        return Optional.of(namesList); //Se utiliza para crear un Optional que contiene un valor no nulo.
    }

    static Optional<String> optionalValuablePlayer() {
        // Optional.ofNullable(null); Retornar un dato cuyo valor es posible que sea null
        try {
            return Optional.of("Andres");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Optional.empty(); // Retornar un optional vació.
    }



}
