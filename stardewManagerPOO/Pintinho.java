package stardewManagerPOO;

// herda da galinha mae
public class Pintinho extends GalinhaMae {

    // usa o super pra passar a base da galinha
    public Pintinho(int id, String nome, String raca, int idade) {
        super(id, nome, raca, idade, "Filhote (crescendo)");
    }

    // som especifico de pintinho
    @Override
    public void emitirSom() {
        System.out.println("Piu-piu!");
    }

    // pintinho nao bota ovo
    @Override
    public String coletarProduto() {
        return "Nenhum (pintinho nao bota ovo)";
    }
}