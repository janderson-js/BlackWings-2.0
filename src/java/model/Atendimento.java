package model;

import java.sql.Timestamp;

public class Atendimento {
    private int id;
    private double preco;
    private String formaPagamento;
    private String status;
    private Funcionario funcionario;
    private Cliente cliente;
    private Timestamp data;
    private Timestamp hora;
    private Timestamp dataPagamento;
    private Timestamp dataAtendimento;
    private Timestamp registroAtendimento;
    private Timestamp cancelamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Timestamp getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Timestamp dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Timestamp getRegistroAtendimento() {
        return registroAtendimento;
    }

    public void setRegistroAtendimento(Timestamp registroAtendimento) {
        this.registroAtendimento = registroAtendimento;
    }

    public Timestamp getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(Timestamp cancelamento) {
        this.cancelamento = cancelamento;
    }
}
