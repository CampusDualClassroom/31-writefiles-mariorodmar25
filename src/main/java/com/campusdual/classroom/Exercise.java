package com.campusdual.classroom;

import com.campusdual.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise {

    public static void main(String[] args) {
        String nuevotexto = Exercise.generateStringToSave(null);
        Exercise.printToFile(nuevotexto);
    }

    public static String generateStringToSave(String string) {
        if(string != null){
            return string;
        }else{
            return Exercise.generateUserInputToSave();
        }

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
        File dir = new File ("src/main/resources");
        if (!dir.exists()){
            dir.mkdir();
        }
        try(BufferedWriter bw = new BufferedWriter(new PrintWriter("src/main/resources/data.txt"))){
            bw.write(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}