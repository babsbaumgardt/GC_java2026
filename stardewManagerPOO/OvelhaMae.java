package stardewManagerPOO;

public class OvelhaMae implements Animal {
    private int id; // id da ovelha
    private String nome; // nome da ovelha
    private String raca; // raca
    private int idade; // idade
    private String status; // status da tosquia

    // construtor da ovelha
    public OvelhaMae(int id, String nome, String raca, int idade, String status) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.status = status;
    }

    // getters obrigatorios
    @Override
    public int getId() { return id; }

    @Override
    public String getNome() { return nome; }

    @Override
    public String getEspecie() { return "Ovelha"; }

    @Override
    public String getRaca() { return raca; }

    @Override
    public int getIdade() { return idade; }

    @Override
    public String getStatus() { return status; }

    // som da ovelha
    @Override
    public void emitirSom() {
        System.out.println("Mééé!");
    }

    // produto da ovelha
    @Override
    public String coletarProduto() {
        return "Lã de Ovelha";
    }
}