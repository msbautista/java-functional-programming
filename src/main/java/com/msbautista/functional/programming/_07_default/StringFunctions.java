package com.msbautista.functional.programming._07_default;

/*
    Default nos permite tener un método con un comportamiento base dentro de una interfaz.

    La anotación @FunctionalInterface no entra en conflicto con default debido a que con esta anotación
    solo se obliga a tener un método abstracto y los métodos default tienen una implementación definida.
*/
public class StringFunctions {

    @FunctionalInterface
    interface StringOperation {
        int getAmount();

        default void operate(String text) {
            int x = getAmount();
            while (x-- > 0) {
                System.out.println(text);
            }
        }
    }

    interface DoOperation {
        void take(String text);

        default void execute(int x, String text) {
            while (x-- > 0) {
                take(text);
            }
        }
    }

    public static void main(String[] args) {
        StringOperation six = () -> 6;
        six.operate("Mi texto");

        DoOperation operateFive = text -> System.out.println(text);
        operateFive.execute(5, "Plan");
    }

}
