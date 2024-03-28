package com.musicapp.web.rest;

import com.musicapp.chatgpt.ChatGPT;
import com.musicapp.mistral.MistralEndPoint;
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
    @GetMapping("/mistral")
    public  String mistral(){
        try {
            Thread.sleep(15000); // 4 saniye beklet
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BURDAYIZZ:");
        System.out.println(MistralEndPoint.mistralResponse);
        return  MistralEndPoint.mistralResponse;
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
