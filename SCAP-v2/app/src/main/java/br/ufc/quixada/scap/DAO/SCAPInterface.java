package br.ufc.quixada.scap.DAO;

import android.content.Context;

import br.ufc.quixada.scap.Model.Atividades;

public interface SCAPInterface {

    static SCAPInterface getInstance(Context context){
        return null;
    }

    boolean delete(int atvID);
    boolean deleteAll();

    boolean add(Atividades a);

    boolean edit(Atividades a);
}
