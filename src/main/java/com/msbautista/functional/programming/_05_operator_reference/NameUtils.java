package com.msbautista.functional.programming._05_operator_reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NameUtils {

    public static void main(String[] args) {
        List<String> teachers = getList("Nicolas", "Juan", "Fabian");

        //Opciones para imprimir los elementos en pantalla
        Consumer<String> printer = x -> System.out.println(x); //Usando una expresión lambda que llama el println.
        teachers.forEach(printer);
        System.out.println("////////");
        teachers.forEach(System.out::println); //Usando el operador de referencia.

        /*
         OPERADOR DE REFERENCIA "::"

         Es una nueva funcionalidad de Java 8 que permite acceder a métodos y constructores de una clase o un objeto.
         Puede ser utilizado para referenciar métodos estáticos o no estáticos.

         En este ejemplo, "System.out::println" es una referencia de método que apunta al método println de la
         clase "System.out".

         Cuando se tenga una operación Lambda donde solo se llame a una función (sea void o tenga un tipo de retorno), como el caso de:
         teachers.forEach(x - System.out.prinln(x));
         Esta podrá ser reemplazada por una referencia al método empleado.
         teachers.forEach(System.out::prinln);

         Para referenciar métodos de una clase, se debe escribir NombreClase::nombreMetodo.

         INFERENCIA DE TIPOS:

         teachers.forEach((String name) -> System.out.println(name));
         teachers.forEach(System.out::println);

         Java "adivina" el tipo de dato basado en las funciones que se le pasen.
         El entender que para poder usar la referencia de otro método necesitamos que ese método
         también reciba el mismo parámetro y genere el mismo resultado.

         El rendimiento no se ve afectado por la inferencia. De hecho en las nuevas versiones de Java (13 y 14)
         ya existe la inferencia de tipos utilizando "var" bajo ciertas condiciones.

         La razón para que la inferencia no interfiera con el rendimiento es porque Java determina en tiempo de compilación
         que tipo de dato corresponde y si la operación es válida. Es decir, tu código se valida incluso antes de correr.
        */
    }

    static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }
}
