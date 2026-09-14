package OldStevePOO;

public class Picareta {

    // aqui o "private" significa que pessoas de fora não podem alterar os atributos diretamente
    private String material; // define o atributo material que é em String por ser escrito
    private int durabilidade; // durabilidade da picareta que vai caindo conforme usa
    private int forca; // força da picareta em número inteiro

    // construtor pra criar a picareta já com os dados certos
    public Picareta(String material, int durabilidade, int forca) {
        this.material = material;
        this.durabilidade = durabilidade;
        this.forca = forca;
    }

    // getters pra conseguir ler os valores de fora da classe
    public String getMaterial() {
        return material;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public int getForca() {
        return forca;
    }

    // tira durabilidade conforme vai minerando os blocos
    public void minerar(int blocos) {
        System.out.println("\nMinerando com a picareta de " + material + "...");

        // diminui a durabilidade pela quantidade de blocos minerados
        this.durabilidade = this.durabilidade - blocos;

        if (this.durabilidade <= 0) {
            this.durabilidade = 0;
            System.out.println("A picareta de " + material + " quebrou!");
        } else {
            System.out.println("Durabilidade restante: " + this.durabilidade);
        }
    }

    // recupera a durabilidade da picareta
    public void reparar(int pontos) {
        System.out.println("\nReparando a picareta de " + material + "...");
        this.durabilidade = this.durabilidade + pontos;
        System.out.println("Nova durabilidade: " + this.durabilidade);
    }

    // método pra mostrar as informações da picareta
    @Override
    public String toString() {
        return "OldStevePOO.Picareta de " + material + " [Durabilidade: " + durabilidade + ", Força: " + forca + "]";
    }
}