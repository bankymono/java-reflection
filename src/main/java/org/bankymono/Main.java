package org.bankymono;

import java.util.*;

public class Main {

    private static void printClassInfo(Class<?> ... classes) {
        for(Class<?> clazz : classes) {
            System.out.println(String.format("class name : %s, class package name : %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));

            Class<?> [] implementedIntefaces = clazz.getInterfaces();

            for(Class<?> implementedInterface: implementedIntefaces){
                System.out.println(String.format("class %s implements : %s",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + clazz.isArray());
            System.out.println("Is primitive : " + clazz.isPrimitive());
            System.out.println("Is enum : " + clazz.isEnum());
            System.out.println("Is interface : " + clazz.isInterface());
            System.out.println("Is anonymous : " + clazz.isAnonymousClass());


            System.out.println();
            System.out.println();
        }
    }

    private static class Square implements Drawable{
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable{
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE,RED,GREEN
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Map<String,Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();
        Class<?> squareClass = Class.forName("org.bankymono.Main$Square");


        var circleObject = new Drawable(){

            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

//        printClassInfo(stringClass,hashMapClass,squareClass);

        printClassInfo(Collection.class,boolean.class, int[][].class,Color.class, circleObject.getClass());
    }
}