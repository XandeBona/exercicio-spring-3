package com.banco.contasbancarias.controller;

import com.banco.contasbancarias.entities.Cliente;
import com.banco.contasbancarias.entities.Conta;
import com.banco.contasbancarias.entities.Movimentacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/contas-bancarias")
public class ContasController {
    private List<Conta> listaContas;
    private List<Movimentacao> listaMovimentacoes;

    public ContasController() {
        Cliente cliente1 = new Cliente(1, "Alexandre", "12576024643");
        Conta conta1 = new Conta(1, 41235, "Poupança", cliente1, 1000.00);
        Movimentacao movimentacao1 = new Movimentacao(1, 1, "credito", 1000.0, LocalDateTime.now().minusDays(1)));
        Movimentacao movimentacao2 = new Movimentacao(2, 2, "debito", 100.0, LocalDateTime.now().minusHours(2)));

        ArrayList<Conta> listaContas = new ArrayList<>();
        listaContas.add(conta1);
        this.listaContas = listaContas;
    }

    @GetMapping
    public List<Conta> listarContas() {
        return listaContas;
    }

    @GetMapping("/{idConta}")
    public Conta buscarConta(@PathVariable Integer idConta) {
        for (Conta conta : listaContas) {
            if (Objects.equals(conta.getId(), idConta)) {
                return conta;
            }
        }
        return null;
    }

    @GetMapping("/{id}/saldo")
    public Double saldo(@PathVariable Integer id) {
        for (Conta conta : listaContas) {
            if (Objects.equals(conta.getId(), id)) {
                return conta.getSaldo();
            }
        }
        return null;
    }

    @GetMapping("/{id}/movimentacoes")
    public List<Movimentacao> historico(@PathVariable Integer id) {
        List<Movimentacao> resultado = new ArrayList<>();
        for (Movimentacao mov : listaMovimentacoes) {
            if (Objects.equals(mov.getIdConta(), id)) {
                resultado.add(mov);
            }
        }
        return resultado;
    }

    @GetMapping("/{idConta}/movimentacoes/{idMov}/detalhes")
    public Movimentacao detalhe(@PathVariable Integer idConta, @PathVariable Integer idMov) {
        for (Movimentacao mov : listaMovimentacoes) {
            if (Objects.equals(mov.getIdConta(), idConta) && Objects.equals(mov.getId(), idMov)) {
                return mov;
            }
        }
        return null;
    }
}

}
