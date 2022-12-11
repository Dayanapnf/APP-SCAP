package br.ufc.quixada.scap.Model;

import java.util.List;

public class User {

    private String  id;
    private String nome;
    private String email;
    private String senha;
    private List<Atividades> minhasAtividades;

    public User(List<Atividades> minhasAtividades){
        this.minhasAtividades = minhasAtividades;
    }


    public User(String id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

    }

    public User(){

    }

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public  String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Atividades> getMinhasAtividades() {
        return minhasAtividades;
    }

    public void setMinhasAtividades(List<Atividades> minhasAtividades) {
        this.minhasAtividades = minhasAtividades;
    }
}
