package stardewManagerPOO;

public interface Animal {
        // contrato com os metodos que todo animal do jogo tem que ter
        int getId();
        String getNome();
        String getEspecie();
        String getRaca();
        int getIdade();
        String getStatus();
        void emitirSom();
        String coletarProduto();
}