package stardewManagerPOO;

// herda tudo da vaca mae usando o extends
public class Bezerro extends VacaMae {

    // o super reutiliza o construtor da vaca mae
    public Bezerro(int id, String nome, String raca, int idade) {
        super(id, nome, raca, idade, "Filhote (nao produz)");
    }

    // reescreve o som pra mugir baixinho por ser bezerro
    @Override
    public void emitirSom() {
        System.out.println("Muuu! (mugi bem baixinho)");
    }

    // reescreve o produto porque filhote ainda nao produz leite
    @Override
    public String coletarProduto() {
        return "Nenhum (bezerro muito novo)";
    }
}