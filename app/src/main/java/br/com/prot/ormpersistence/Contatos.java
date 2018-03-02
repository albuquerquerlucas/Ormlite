package br.com.prot.ormpersistence;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by fredericom on 02/03/2018.
 */

public class Contatos {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private String email;

    public Contatos() {
    }

    public Contatos(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
