package OldStevePOO;

public class OldStevePOO {
    public static void main(String[] args) {
        System.out.println("=== FABRICANDO PICARETAS DO STEVE ===");

        // criando os objetos das picaretas usando new
        Picareta p1 = new Picareta("madeira", 50, 5);
        Picareta p2 = new Picareta("pedra", 70, 8);
        Picareta p3 = new Picareta("ferro", 100, 12);

        // mostrando no terminal as picaretas criadas
        System.out.println("Picaretas criadas:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // testando minerar com a picareta de ferro
        p3.minerar(30);
        p3.minerar(20);

        // criando a picareta de ouro
        Picareta p4 = new Picareta("ouro", 30, 15);

        // testando reparar a picareta de ferro
        p3.reparar(50);

        // estado final
        System.out.println("\n=== ESTADO FINAL ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}