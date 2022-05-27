package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.*;
import javax.mail.internet.*;



@Service
public class EmailProvider {

    @Autowired
    private JavaMailSenderImpl  mailSender;

    public EmailProvider() {


    }

    public void sendMail(EmailEntity emailEntity, MultipartFile file) throws MessagingException {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("daw09.2022@gmail.com");
            helper.setTo(emailEntity.getEmail());
            helper.setSubject(emailEntity.getAsunto());
            helper.setText(emailEntity.getMensaje());


    byte[] fichBytes = file.getBytes();
    helper.addAttachment("Adjunto.pdf", new ByteArrayResource(fichBytes));


            mailSender.send(mimeMessage);

            System.out.println("Email sending complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

