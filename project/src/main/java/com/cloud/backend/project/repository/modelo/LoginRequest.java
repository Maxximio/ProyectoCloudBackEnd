package com.cloud.backend.project.repository.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {

    private static final long serialVersionUID =1L;

    private String email;
    private String password;

}
