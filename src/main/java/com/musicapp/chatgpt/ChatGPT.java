package com.musicapp.chatgpt;

import com.musicapp.responseFormatter.ResponseFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ChatGPT {

    static String chatGptResponse = "";

    public static String chatgpt(String s) {
        String formattedContent = "";
        try {
            chatGptResponse = "";
            String mood = s;
            ProcessBuilder pb = new ProcessBuilder("python", "\"C:\\Users\\seyma\\Desktop\\chatgpt\\ChatGPT.py\"", mood);
            Process process = pb.start();

            List<String> command = pb.command();
            System.out.println("Command: " + command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                chatGptResponse += line;
                //System.out.println("girdi");
                //System.out.println(line);
            }
            System.out.println("ChatGPT Response: " + chatGptResponse);
            String filePath = "C:\\Users\\seyma\\Desktop\\BitirmeProjesi\\response.txt";
            formattedContent = ResponseFormatter.formatResponse(filePath);
            System.out.println("Formatted Response: " + formattedContent);

            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return formattedContent;
    }
}
