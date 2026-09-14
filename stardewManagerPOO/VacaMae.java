package stardewManagerPOO;

public class VacaMae implements Animal {
    private int id; // id unico de identificacao do animal
    private String nome; // nome do animal
    private String raca; // raca da vaca
    private int idade; // idade em anos
    private String status; // status de producao ou filhote

    // construtor pra criar a vaca mae ja com todas as infos
    public VacaMae(int id, String nome, String raca, int idade, String status) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.status = status;
    }

    // getters obrigatorios pra ler as informacoes da interface
    @Override
    public int getId() { return id; }

    @Override
    public String getNome() { return nome; }

    @Override
    public String getEspecie() { return "Vaca"; }

    @Override
    public String getRaca() { return raca; }

    @Override
    public int getIdade() { return idade; }

    @Override
    public String getStatus() { return status; }

    // faz o som da vaca
    @Override
    public void emitirSom() {
        System.out.println("Muuu!");
    }

    // retorna o produto que a vaca produz
    @Override
    public String coletarProduto() {
        return "Balde de Leite";
    }
}