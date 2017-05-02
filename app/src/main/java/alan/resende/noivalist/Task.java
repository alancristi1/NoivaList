package alan.resende.noivalist;


import java.io.Serializable;

/**
 * Created by alan on 06/11/16.
 */


public class Task implements Serializable {

    int id;
    String nome;
    String categoria;


    public Task() {

    }

    public Task(String nome) {
        this(0, nome);
    }

    public Task(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;

    }
}
