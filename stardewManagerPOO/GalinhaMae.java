package stardewManagerPOO;

public class GalinhaMae implements Animal {
    private int id; // id da galinha
    private String nome; // nome
    private String raca; // raca
    private int idade; // idade
    private String status; // status do animal

    // construtor da galinha
    public GalinhaMae(int id, String nome, String raca, int idade, String status) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.status = status;
    }

    // getters pra passar os dados pra fora
    @Override
    public int getId() { return id; }

    @Override
    public String getNome() { return nome; }

    @Override
    public String getEspecie() { return "Galinha"; }

    @Override
    public String getRaca() { return raca; }

    @Override
    public int getIdade() { return idade; }

    @Override
    public String getStatus() { return status; }

    // som da galinha
    @Override
    public void emitirSom() {
        System.out.println("Có-có!");
    }

    // produto da galinha
    @Override
    public String coletarProduto() {
        return "Ovo Caipira";
    }
}