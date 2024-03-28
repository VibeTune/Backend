package com.musicapp.responseFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ResponseFormatterFromAI {

    public static String formatResponse(String input) {
        String patternString = "\\[INST\\](.*?)\\[/INST\\]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
            if (count == 2) {
                return matcher.group(1);
            }
        }
        return "AI formatter worked wrong";
    }
}
