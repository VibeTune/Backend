package com.musicapp.web.rest;

import com.musicapp.chatgpt.ChatGPT;
import com.musicapp.mistral.MistralEndPoint;
import com.musicapp.responseFormatter.ResponseFormatterFromAI;
import com.musicapp.responseFormatter.SongInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiCallResource {

    @PostMapping("/chatgpt")
    public ResponseEntity<String> chatgpt(@RequestBody String s) {
        try {
            System.out.println("String geldi: " + s);

             String chatGptOutput = ChatGPT.chatgpt(s);

             MistralEndPoint.mistralEndpoint(chatGptOutput);

            return ResponseEntity.ok("BASARILI");
        } catch (Exception e) {
            // Hata durumunda 500 Internal Server Error yanıtı döndürür
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: " + e.getMessage());
        }
    }

    String mistralResponseFormatted = "";
    @GetMapping("/mistral")
    public  String mistral(){
        try {
            Thread.sleep(13000); // 10 saniye beklet
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mistralResponseFormatted = MistralEndPoint.mistralResponse;
        System.out.println("BURDAYIZZ:");
        System.out.println(mistralResponseFormatted);

        //SongInfo songInfo = ResponseFormatterFromAI.parseSongInfo(mistralCiktisi);

        return  mistralResponseFormatted;
    }

    @GetMapping("/songInfo")
    public String getSongInfo(){
        SongInfo songInfo = ResponseFormatterFromAI.parseSongInfo(mistralResponseFormatted);
        if(songInfo != null &&
            songInfo.getSong() != null && songInfo.getArtist() !=null ) {
            System.out.println("SSSSSSSSSSSSSSSSSSSSSS:" + songInfo.getSong());
            return songInfo.getSong() + " by " + songInfo.getArtist();
        }
        return "";
    }


    /* @PostMapping("/mistral")
    public ResponseEntity<String> mistral(@RequestBody String s) {
        try {
            System.out.println("String geldi: " + s);

            MistralEndPoint.mistralEndpoint(s);
            // Başarılı durumda 200 OK yanıtı döndürür
            return ResponseEntity.ok("BASARILI");
        } catch (Exception e) {
            // Hata durumunda 500 Internal Server Error yanıtı döndürür
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: " + e.getMessage());
        }
    } */

}
