package br.com.ibmec.backend.cadastrocliente.controller;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;
import jakarta.validation.Valid;
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

    private static ArrayList<Cliente> repositorio = new ArrayList<>();

    @GetMapping("/listar")
    public String listarCliente(Model model) {

        model.addAttribute("listaCliente" , repositorio);
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

        int id = 1;
        if (repositorio.size() > 0) {
            Cliente ultimo = repositorio.get(repositorio.size() - 1);
            id = ultimo.getId() + 1;
        }

        cliente.setId(id);
        repositorio.add(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        Cliente clienteASerExcluir = null;
        for (Cliente item : repositorio) {
            if (item.getId() == id) {
                clienteASerExcluir = item;
            }
        }

        repositorio.remove(clienteASerExcluir);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Cliente clienteASerEditado = null;
        for (Cliente item : repositorio) {
            if (item.getId() == id) {
                clienteASerEditado = item;
                break;
            }
        }

        model.addAttribute("cliente", clienteASerEditado);
        return "editar-cliente";
    }

    @PostMapping("/atualizar/{id}")
    public  String atualizar(@PathVariable("id") int id, Cliente newData) {
        Cliente clienteASerEditado = null;
        for (Cliente item : repositorio) {
            if (item.getId() == id) {
                clienteASerEditado = item;
                break;
            }
        }

        clienteASerEditado.setCpf(newData.getCpf());
        clienteASerEditado.setNome(newData.getNome());
        clienteASerEditado.setDataNascimento(newData.getDataNascimento());
        clienteASerEditado.setEmail(newData.getEmail());

        return "redirect:/cliente/listar";

    }


}
