package br.ufc.quixada.scap.Model;

import java.io.Serializable;

public class Atividades implements Serializable {

    public Atividades(String nome_da_atividade, String descricao_da_atividade, String objetivo_da_atividade, String metodologia_da_atividade, String resultados_da_atividade, String avaliacao_da_atividade) {
        this.nome_da_atividade = nome_da_atividade;
        this.descricao_da_atividade = descricao_da_atividade;
        this.objetivo_da_atividade = objetivo_da_atividade;
        this.metodologia_da_atividade = metodologia_da_atividade;
        this.resultados_da_atividade = resultados_da_atividade;
        this.avaliacao_da_atividade = avaliacao_da_atividade;
        countID++;
        this.id = countID;
    }

    private static int id, countID = -1;
    private String tipo_de_atividade;
    private String nome_da_atividade;
    private String descricao_da_atividade;
    private String objetivo_da_atividade;
    private String metodologia_da_atividade;
    private String resultados_da_atividade;
    private String avaliacao_da_atividade;


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Atividades.id = id;
    }

    public String getTipo_de_atividade() {
        return tipo_de_atividade;
    }

    public void setTipo_de_atividade(String tipo_de_atividade) {
        this.tipo_de_atividade = tipo_de_atividade;
    }

    public String getNome_da_atividade() {
        return nome_da_atividade;
    }

    public void setNome_da_atividade(String nome_da_atividade) {
        this.nome_da_atividade = nome_da_atividade;
    }

    public String getDescricao_da_atividade() {
        return descricao_da_atividade;
    }

    public void setDescricao_da_atividade(String descricao_da_atividade) {
        this.descricao_da_atividade = descricao_da_atividade;
    }

    public String getObjetivo_da_atividade() {
        return objetivo_da_atividade;
    }

    public void setObjetivo_da_atividade(String objetivo_da_atividade) {
        this.objetivo_da_atividade = objetivo_da_atividade;
    }

    public String getMetodologia_da_atividade() {
        return metodologia_da_atividade;
    }

    public void setMetodologia_da_atividade(String metodologia_da_atividade) {
        this.metodologia_da_atividade = metodologia_da_atividade;
    }

    public String getResultados_da_atividade() {
        return resultados_da_atividade;
    }

    public void setResultados_da_atividade(String resultados_da_atividade) {
        this.resultados_da_atividade = resultados_da_atividade;
    }

    public String getAvaliacao_da_atividade() {
        return avaliacao_da_atividade;
    }

    public void setAvaliacao_da_atividade(String avaliacao_da_atividade) {
        this.avaliacao_da_atividade = avaliacao_da_atividade;
    }


    @Override
    public String toString() {
        return "Atividade{" +
                "nomeAtv='" + nome_da_atividade + "\n" +
                ", descricaoAtv='" + descricao_da_atividade + "\n" +
                ", objetivoAtv='" + objetivo_da_atividade + "\n" +
                ", metodologiaAtv='" + metodologia_da_atividade + "\n" +
                ", resultadosAtv='" + resultados_da_atividade + "\n" +
                ", avaliacaoAtv='" + avaliacao_da_atividade + "\n"
                +
                '}';
    }

}
