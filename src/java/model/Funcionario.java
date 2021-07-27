
package model;

import java.sql.Timestamp;

public class Funcionario {
    private int id;
    private String nome;
    private String matricula;
    private String senha;
    private String cep;
    private String cidade;
    private String bairro;
    private String endereco;
    private String casa;
    private String complemento;
    private String telefone;
    private String telefoneContato;
    private String status;
    private Perfil perifl;
    private Timestamp dataNascimento;
    private Timestamp dataContrato;
    private Timestamp validadeContrato;
    private Timestamp saida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Perfil getPerifl() {
        return perifl;
    }

    public void setPerifl(Perfil perifl) {
        this.perifl = perifl;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Timestamp getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Timestamp dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Timestamp getValidadeContrato() {
        return validadeContrato;
    }

    public void setValidadeContrato(Timestamp validadeContrato) {
        this.validadeContrato = validadeContrato;
    }

    public Timestamp getSaida() {
        return saida;
    }

    public void setSaida(Timestamp saida) {
        this.saida = saida;
    }
    
}
