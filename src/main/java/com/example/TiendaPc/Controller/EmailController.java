package com.example.TiendaPc.Controller;
import com.example.TiendaPc.Provider.EmailServices;
import com.example.TiendaPc.Entity.Email;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    EmailServices emailServices;

    @PostMapping("/send")
    public void sendMail(@RequestParam(value = "email") String email,
                         @RequestParam(value = "file", required = false) MultipartFile file) throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {
        Email correo = null;

        try {
            correo = objectMapper.readValue(email, Email.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        emailServices.sendMail(correo, file);
    }

}
