package com.msbautista.functional.programming._08_chaining;

public class Chaining {

    //El Chaining consiste en hacer llamadas consecutivas a diferentes métodos de un mismo objeto.
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Hola")
                .append("Amigo")
                .append("Yo")
                .append("soy")
                .append("Mr Robot");

        Chainer chainer = new Chainer("Maicol");
        chainer.sayHi().sayBye();
    }

    static class Chainer {

        String name;

        Chainer(String name) {
            this.name = name;
        }

        public Chainer sayHi() {
            System.out.println("Hi " + name);
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Bye " + name);
            return this;
        }
    }

}
