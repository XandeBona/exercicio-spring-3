package com.banco.contasbancarias.controller;

import com.banco.contasbancarias.entities.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private List<Cliente> lista;

    public ClientesController() {
        Cliente cliente1 = new Cliente(1, "Alexandre", "12576024643");

        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(cliente1);
        this.lista = lista;
    }

    @GetMapping
    public List<Cliente> listar(){
        return lista;
    }

    @GetMapping("/{idCliente}")
    public Cliente buscarCliente(@PathVariable Integer idCliente) {
        for(Cliente cliente : lista) {
            if(Objects.equals(cliente.getId(), idCliente)) {
                return cliente;
            }
        }
        return null;
    }
}
