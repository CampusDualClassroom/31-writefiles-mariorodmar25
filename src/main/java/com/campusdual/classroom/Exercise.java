package com.campusdual.classroom;

import com.campusdual.Utils;

public class Exercise {

    public static void main(String[] args) {

    }

    public static String generateStringToSave(String string) {

    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {

    }


}
