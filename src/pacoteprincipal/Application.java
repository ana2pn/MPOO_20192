package pacoteprincipal;

public class Application {

    public static void main(String[] args) {
        HelloWorld usuario1 = new HelloWorld();
        HelloWorld usuario2 = new HelloWorld();
        HelloWorld usuario3 = new HelloWorld();
        HelloWorld usuario4 = new HelloWorld();


        usuario1.setNome("Ana Paula");
        usuario2.setNome("Carolina");
        usuario3.setNome("Carlos");

        usuario1.imprime();
        usuario2.imprime();
        usuario3.imprime();
        usuario4.imprime();
    }
}
