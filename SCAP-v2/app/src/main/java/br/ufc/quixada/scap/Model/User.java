package br.ufc.quixada.scap.Model;

import java.util.ArrayList;

public class User {
    static int countID, id;
    String nome, email, matricula;
    ArrayList<Atividades> minhasAtividades;

    public User(String nome, String email, String matricula, ArrayList minhasAtividades){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.minhasAtividades = minhasAtividades;
        countID++;
        this.id = countID;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Atividades> getMinhasAtividades() {
        return minhasAtividades;
    }

    public void setMinhasAtividades(ArrayList<Atividades> minhasAtividades) {
        this.minhasAtividades = minhasAtividades;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + "\n" +
                ", email='" + email + "\n" +
                ", matricula='" + matricula + "\n" +
                '}';
    }
}
