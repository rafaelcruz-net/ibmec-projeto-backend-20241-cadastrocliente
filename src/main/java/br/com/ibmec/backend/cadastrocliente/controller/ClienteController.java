package br.com.ibmec.backend.cadastrocliente.controller;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/listar")
    public String listarCliente(Model model) {

        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
        cliente.setNome("Rafael Cruz");
        cliente.setEmail("teste@teste.com.br");
        cliente.setCpf("123.456.789-00");
        cliente.setDataNascimento("10/02/2020");

        lista.add(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");
        cliente2.setEmail("m@teste.com.br");
        cliente2.setCpf("111111111");
        cliente2.setDataNascimento("10/02/2021");
        lista.add(cliente2);


        model.addAttribute("listaCliente" , lista);
        return "listar-cliente";
    }

}
