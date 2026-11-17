import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuardaRoupaTest {

    private GuardaRoupa guardaRoupa;

    @BeforeEach
    void setUp() {
        // Orçamento inicial de 500.00 conforme exigido na atividade
        guardaRoupa = new GuardaRoupa(500.0);
    }
    @Test
    void testPrecoComDescontoInvalidoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            guardaRoupa.precoComDesconto(200.0, -10.0);
        });
    }

    @Test
    void testPrecoComDescontoInvalidoAcimaDeCem() {
        assertThrows(IllegalArgumentException.class, () -> {
            guardaRoupa.precoComDesconto(200.0, 150.0);
        });
    }

    @Test
    void testCabeNoOrcamentoAbaixo() {
        // Preço menor que 500 deve retornar true
        assertTrue(guardaRoupa.cabeNoOrcamento(300.0));
    }

    @Test
    void testCabeNoOrcamentoExato() {
        // Preço exatamente igual a 500 deve retornar true (aqui vai dar bug no código atual!)
        assertTrue(guardaRoupa.cabeNoOrcamento(500.0));
    }

    @Test
    void testEhDeGalaAbaixoDe200() {
        // Abaixo de 200 (ex: 150) não é de gala
        assertFalse(guardaRoupa.ehDeGala(150.0));
    }

    @Test
    void testEhDeGalaExatamente200() {
        // Exatamente 200 não deve ser considerado de gala (regra: "acima de 200")
        assertFalse(guardaRoupa.ehDeGala(200.0)); // Aqui vai falhar no código atual!
    }

    @Test
    void testEhDeGalaAcimaDe200() {
        // Acima de 200 (ex: 250) é de gala
        assertTrue(guardaRoupa.ehDeGala(250.0));
    }
}