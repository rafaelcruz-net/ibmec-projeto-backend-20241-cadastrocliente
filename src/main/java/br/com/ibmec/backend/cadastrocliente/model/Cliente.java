package br.com.ibmec.backend.cadastrocliente.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data

public class Cliente {
    private int id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotBlank(message =  "Campo email é obrigatório")
    @Email(message = "Email não está em um formato correto")
    private String email;

    @NotBlank(message = "Campo CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Campo data de nascimento é obrigatório")
    private String dataNascimento;
}
