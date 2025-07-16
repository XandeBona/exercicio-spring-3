package com.banco.contasbancarias.controller;

import com.banco.contasbancarias.entities.Cliente;
import com.banco.contasbancarias.entities.Conta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/contas")
public class ContasController {
    private List<Conta> lista;

    public ContasController() {
        Cliente cliente1 = new Cliente(1, "Alexandre", "12576024643");
        Conta conta1 = new Conta(1, 41235, "Poupança", cliente1, 1000.00);

        ArrayList<Conta> lista = new ArrayList<>();
        lista.add(conta1);
        this.lista = lista;
    }

    @GetMapping
    public List<Conta> listar() {
        return lista;
    }

    @GetMapping("/{idConta}")
    public Conta buscarConta(@PathVariable Integer idConta) {
        for (Conta conta : lista) {
            if (Objects.equals(conta.getId(), idConta)) {
                return conta;
            }
        }
        return null;
    }


}
