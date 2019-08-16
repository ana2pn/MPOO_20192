package pacoteprincipal;

public class Application {

    public static void main(String[] args) {
        HelloWorld objeto1 = new HelloWorld();
        HelloWorld objeto2 = new HelloWorld();

        objeto1.setNome("Ana Paula");
        objeto2.setNome("Carolina");

        System.out.println(objeto1.getNome());
        System.out.println(objeto2.getNome());
    }
}
