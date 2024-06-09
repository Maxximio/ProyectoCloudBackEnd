package com.cloud.backend.project.auth.Service;

public interface IEncriptionService {


 String encriptPass(String pass);

 public Boolean verificarEncriptedText(String passEncripted, String passReceived);

}
