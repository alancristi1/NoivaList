package alan.resende.noivalist;

/**
 * Created by alanr on 17/05/17.
 */

public class Category {

    int id;
    String nome;
    String categoria;

    public Category(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Category(String nome) {
        this.nome = nome;

    }

    @Override
    public String toString() {
        return this.nome;
    }
}
