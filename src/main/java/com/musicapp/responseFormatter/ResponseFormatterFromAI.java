package com.musicapp.responseFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ResponseFormatterFromAI {

    public static String formatResponse(String input) {

        input = input + "[/INST]";

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


    public static SongInfo parseSongInfo(String input) {
        String songRegex = "\"([^\"]*)\"";
        String artistRegex = "by\\s+([^\\.]+)\\.";

        Pattern songPattern = Pattern.compile(songRegex);
        Pattern artistPattern = Pattern.compile(artistRegex);

        Matcher songMatcher = songPattern.matcher(input);
        Matcher artistMatcher = artistPattern.matcher(input);

        if (songMatcher.find() && artistMatcher.find()) {
            String song = songMatcher.group(1);
            String artist = artistMatcher.group(1);
            return new SongInfo(song, artist);
        }

        return null;
    }

}
