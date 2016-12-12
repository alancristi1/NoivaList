package alan.resende.noivalist;

<<<<<<< HEAD
import java.io.Serializable;

=======
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
/**
 * Created by alan on 06/11/16.
 */

<<<<<<< HEAD
public class Task implements Serializable{

    int id;
    String nome;


    public Task(){

    }
    public Task(String nome){
        this(0, nome);
    }

    public Task(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return this.nome;
=======
public class Task {

    private int id = 0;
    private String nome = "";

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
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
    }
}
