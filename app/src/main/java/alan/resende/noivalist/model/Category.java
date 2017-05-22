package alan.resende.noivalist.model;

import java.io.Serializable;

/**
 * Created by alanr on 17/05/17.
 */

public class Category implements Serializable {

    public int id;
    String nome;
    String categoria;

    public Category(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    @Override
    public String toString() {
        return this.nome;
    }
}