package com.example.TiendaPc.Controller;
import com.example.TiendaPc.Provider.EmailProvider;
import com.example.TiendaPc.Entity.EmailEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    EmailProvider emailProvider;

    @PostMapping("/send")
    public void sendMail(@RequestParam(value = "email") String email,
                         @RequestParam(value = "file", required = false) MultipartFile file) throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {
        EmailEntity correo = null;

        try {
            correo = objectMapper.readValue(email, EmailEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        emailProvider.sendMail(correo, file);
    }

}
