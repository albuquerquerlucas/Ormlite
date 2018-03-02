package br.com.prot.ormpersistence;

import android.content.Context;

/**
 * Created by fredericom on 02/03/2018.
 */

public class ContatosDAO extends GenericDAO<Contatos> {

    public ContatosDAO(Context context) {
        super(context, Contatos.class);
    }
}
