public class Main {

    public static void main(String[] args) {

        ChaveApi chave = new ChaveApi("ABC123", "Basic", 3);

        chave.registrarChamada();
        System.out.println("1ª chamada realizada!");

        chave.registrarChamada();
        System.out.println("2ª chamada realizada!");

        chave.registrarChamada();
        System.out.println("3ª chamada realizada!");

        try {
            chave.registrarChamada();
            System.out.println("4ª chamada realizada!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
