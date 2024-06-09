package com.cloud.backend.project.service;

public interface IEncriptionService {


 String encriptPass(String pass);

 public Boolean verificarEncriptedText(String passEncripted, String passReceived);

}
