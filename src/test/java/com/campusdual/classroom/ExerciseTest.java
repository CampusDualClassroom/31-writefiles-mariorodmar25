package com.campusdual.classroom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExerciseTest {

    @Test
    @DisplayName("Check if the string passed by parameter is the same that the return string")
    void testReturnSameStringPassedByParameter() {
        String string = Exercise.generateStringToSave("This is a\nmulti-line string.");
        assertEquals("This is a\nmulti-line string.", string, "Return string does not match.");
    }

    @Test
    @DisplayName("Check if the string passed by parameter is the same string saved in file")
    void testSavedFileContainsString() {
        String string = Exercise.generateStringToSave("This is a\nmulti-line string\nto check\nmulti-line string\nsaved file.");
        Exercise.printToFile(string);
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                assertTrue(string.contains(line), "Original string not contains saved line");
                string = string.substring(string.indexOf(line) + line.length(), string.length());
            }
            assertTrue(string.isBlank(), "Saved file not contains all data from original string.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}