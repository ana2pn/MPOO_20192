package pacoteprincipal;

import java.sql.SQLOutput;

public class Application {

    public static void main(String[] args) {
        HelloWorld usuario1 = new HelloWorld();
        HelloWorld usuario2 = new HelloWorld();
        HelloWorld usuario3 = new HelloWorld();
        HelloWorld usuario4 = new HelloWorld();

        usuario1.setNome("Ana Paula");
        usuario2.setNome("Carolina");
        usuario3.setNome("Carlos");

        System.out.println(usuario1.getNome());
        System.out.println(usuario2.getNome());
        System.out.println(usuario3.getNome());
        System.out.println(usuario4.getNome());
    }
}
