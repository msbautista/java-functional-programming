package com.msbautista.functional.programming._02_consumer_supplier;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    /*
    Consumer: Es una expresión lambda que acepta un solo valor y no devuelven valor alguno.
    Ejemplo: Una función que reciba una lista de archivos y borre cada uno de ellos, sin devolver nada.
        The consumer can be used in all contexts where an object needs to be consumed

    Supplier: Es una expresión que no tiene parámetros, pero devuelve un resultado.
    Ejemplo: Se crea un supplier de tipo CLIArguments llamado generator que no recibe ni un parámetro, pero que
    crea un nuevo objeto CLIArguments y lo retorna.
    Se pueden generar archivos bajo demanda.
        The supplier can be used in all contexts where there is no input but an output is expected

    Entonces a partir del Consumer vamos a poder realizar acciones a una serie de datos de forma rápida, en cambio,
    el Supplier nos ayudará a generar datos con base a las características que le brindemos.
     */

    static void showHelp(CLIArguments cliArguments) {
        Consumer<CLIArguments> consumerHelper = arguments -> {
            if (arguments.isHelp()) {
                System.out.println("Manual solicitado");
            }
        };
        consumerHelper.accept(cliArguments);
    }

    static CLIArguments generateCLI() {
        Supplier<CLIArguments> generator = () -> new CLIArguments();

        return generator.get();
    }
}
