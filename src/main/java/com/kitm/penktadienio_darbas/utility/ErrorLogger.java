package com.kitm.penktadienio_darbas.utility;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {

    public static void error(String text)
    {
        String file = "src/main/resources/log.txt";

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("error: " + text + "\n");
        } catch (Exception e) {

        }
    }
}
