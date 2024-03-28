package com.musicapp.mistral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MistralEndPoint {

    public static String mistralResponse = "deneme";
    public static void mistralEndpoint(String s) {
        try {
            mistralResponse = "";
            ProcessBuilder pb = new ProcessBuilder("python", "\"C:\\Users\\seyma\\Desktop\\Mistral\\mistral_endpoint.py\"", s);
            Process process = pb.start();

            List<String> command = pb.command();
            System.out.println("Command: " + command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("girdi");
                System.out.println(line);
                mistralResponse += line;
            }
            System.out.println("MİSTRAL ÇIKTISI: " + mistralResponse);

            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
