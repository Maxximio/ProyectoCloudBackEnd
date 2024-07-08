package com.cloud.backend.project.service;


public interface ISendEmailService {


    Integer enviarNotificacionEmail(String destinatario, String asunto, String mensajeHtml );
}
