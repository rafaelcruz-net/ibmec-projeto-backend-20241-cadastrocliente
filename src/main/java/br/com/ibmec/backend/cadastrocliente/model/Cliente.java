package br.com.ibmec.backend.cadastrocliente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @Column
    @NotBlank(message =  "Campo email é obrigatório")
    @Email(message = "Email não está em um formato correto")
    private String email;

    @Column
    @NotBlank(message = "Campo CPF é obrigatório")
    private String cpf;

    @Column
    @NotBlank(message = "Campo data de nascimento é obrigatório")
    private String dataNascimento;
}
