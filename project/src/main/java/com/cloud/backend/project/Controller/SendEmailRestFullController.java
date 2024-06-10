package com.cloud.backend.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.backend.project.repository.modelo.EmailRequest;
import com.cloud.backend.project.service.ISendEmailService;
import org.springframework.http.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/emails")
public class SendEmailRestFullController {

    @Autowired
    private ISendEmailService sendEmailService;


    @PostMapping(path = "/sendNotif",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enviarNotificacionEmail(@RequestBody EmailRequest emailRequest){
        try{
                return new ResponseEntity<>(this.sendEmailService.enviarNotificacionEmail(emailRequest.getDestinatario(),emailRequest.getAsunto(),emailRequest.getMensajeHtml()),null,HttpStatus.OK);
        }catch(Exception ex){

            return new ResponseEntity<>("Error al enviar el correo: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
