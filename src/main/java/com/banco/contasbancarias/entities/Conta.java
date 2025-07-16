package com.banco.contasbancarias.entities;

public class Conta {
    private Integer id;
    private Integer numeroDaConta;
    private String tipoDaConta;
    private Cliente cliente;
    private Double saldo;

    public Conta(Integer id, Integer numeroDaConta, String tipoDaConta, Cliente cliente, Double saldo) {
        this.id = id;
        this.numeroDaConta = numeroDaConta;
        this.tipoDaConta = tipoDaConta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getTipoDaConta() {
        return tipoDaConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }
}
