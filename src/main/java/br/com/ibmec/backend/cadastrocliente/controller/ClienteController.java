package br.com.ibmec.backend.cadastrocliente.controller;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;
import br.com.ibmec.backend.cadastrocliente.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping("/listar")
    public String listarCliente(Model model) {

        model.addAttribute("listaCliente" , repositorio.findAll());
        return "listar-cliente";
    }

    @GetMapping("/adicionar")
    public String adicionar(Cliente cliente) {
        return "salvar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "salvar";
        }
        repositorio.save(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        Cliente clienteASerExcluir = repositorio.getById(id);

        repositorio.delete(clienteASerExcluir);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Cliente clienteASerEditado = repositorio.getById(id);

        model.addAttribute("cliente", clienteASerEditado);
        return "editar-cliente";
    }

    @PostMapping("/atualizar/{id}")
    public  String atualizar(@PathVariable("id") int id, Cliente newData) {
        Cliente clienteASerEditado = repositorio.getById(id);

        clienteASerEditado.setCpf(newData.getCpf());
        clienteASerEditado.setNome(newData.getNome());
        clienteASerEditado.setDataNascimento(newData.getDataNascimento());
        clienteASerEditado.setEmail(newData.getEmail());

        repositorio.save(clienteASerEditado);

        return "redirect:/cliente/listar";

    }
}
