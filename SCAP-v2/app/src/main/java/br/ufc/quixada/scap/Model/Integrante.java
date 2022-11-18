package br.ufc.quixada.scap.Model;

import java.util.ArrayList;

public class Integrante {
    String cargo, nome, email, senha;
    int titleImage;
    ArrayList<Atividades> minhasAtividades;

    public Integrante(String cargo, String nome, String email, int titleImage) {
        this.cargo = cargo;
        this.nome = nome;
        this.email = email;
        this.titleImage = titleImage;
    }
    public Integrante (String nome, String email,String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public int getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(int titleImage) {
        this.titleImage = titleImage;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return

                " nome='"  + nome  + "\n"+
        ", email='"  + email   +"\n"+
        ", senha='"  + senha  + "\n" ;
    }
}
