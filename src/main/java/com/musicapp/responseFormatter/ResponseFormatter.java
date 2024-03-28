package com.musicapp.responseFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResponseFormatter {

    public static String formatResponse(String filePath) {
        String content = readFileAsString(filePath);

        if (content != null) {
            return (
                "\"<s>[INST]I will give you some information, suggest me the song that best suits that information. " +
                content.replace("\n", " ").replace("\r", "") + // Yeni satır karakterlerini kaldır
                "[/INST]\"[INST] Can you advise proper music?[/INST]\""
            );
        } else {
            return "Dosya okunamadı.";
        }
    }

    private static String readFileAsString(String filePath) {
        try {
            // Dosya içeriğini oku ve bir String'e dönüştür
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String filePath = "response.txt"; // Dosyanın yolu
        String formattedContent = formatResponse(filePath);
        System.out.println(formattedContent);
    }
}
