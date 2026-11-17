/**
 * Sistema do guarda-roupa da Barbie.
 *
 * <p>ATENÇÃO: este código foi entregue pela equipe e a Barbie
 * relatou comportamentos estranhos. Sua missão é descobrir
 * onde ele está errado - e provar com testes.</p>
 */
public class GuardaRoupa {

    private double orcamento;

    /**
     * Cria o guarda-roupa com um orçamento disponível.
     *
     * @param orcamento valor máximo para gastar em looks
     */
    public GuardaRoupa(double orcamento) {
        this.orcamento = orcamento;
    }

    /**
     * Calcula o preço de um look com desconto.
     *
     * <p>Regra: o desconto deve estar entre 0 e 100.
     * Fora disso, é erro de cadastro e deve avisar.</p>
     *
     * @param preco      preço original do look
     * @param percentual desconto de 0 a 100
     * @return preço final
     */
    public static double precoComDesconto(double preco, double percentual) {
        // Se o desconto for menor que 0 ou maior que 100, lança um erro!
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Desconto inválido! Deve ser entre 0 e 100.");
        }
        return preco - (preco * percentual / 100);
    }
    //aqui o problema é que ele não filtra quanto de desconto vai ter

    /**
     * Diz se um look cabe no orçamento.
     *
     * <p>Regra: o orçamento inclui o valor exato.</p>
     *
     * @param preco preço do look
     * @return true se couber no orçamento
     */
    public boolean cabeNoOrcamento(double preco) {
        return preco <= orcamento;
    }
// aqui o problema é que apenas roupas com preço menos de 500 são aceitas, mas não 500 (falta <=)

    /**
     * Diz se um look é de gala.
     *
     * <p>Regra: acima de 200 reais é gala.</p>
     *
     * @param preco preço do look
     * @return true se for de gala
     */
    public boolean ehDeGala(double preco) {
        return preco > 200.0;
    }
//A regra fala estritamente acima de 200 (ou seja, maior que 200, tipo 201).
// Mas o código usou >= (maior ou igual a 200).
// Se a roupa custar exatamente R$ 200,
// o código vai dizer que ela é de gala, o que desobedece a regrinha escrita.

    /**
     * Registra uma compra e desconta do orçamento.
     *
     * @param preco valor pago pelo look
     */
    public void registrarCompra(double preco) {
        this.orcamento = this.orcamento - preco;
    }
    /**
     * Devolve o orçamento restante.
     *
     * @return valor ainda disponível
     */
    public double getOrcamento() {
        return orcamento;
    }
}