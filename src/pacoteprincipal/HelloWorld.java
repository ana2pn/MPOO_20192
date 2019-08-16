package pacoteprincipal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
    private String nome;
    Date hora_atual = new Date();
    String hora = new SimpleDateFormat("HH:mm:ss").format(hora_atual);

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void imprime(){
        System.out.print(hora);
        System.out.println(" Parabéns "+this.getNome()+", Você acabou de fazer seu primeiro HelloWorld em Java!");
    }
}
