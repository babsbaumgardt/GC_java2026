// Pacote (pasta) onde a classe fica
package com.example.apirestwithspring.services;

import com.example.apirestwithspring.entities.Pokemon;                   // a entidade
import com.example.apirestwithspring.repositories.PokemonRepository;     // o repositório que acessa os dados
import org.springframework.http.HttpStatus;                              // códigos HTTP (404, 400...)
import org.springframework.stereotype.Service;                           // marca a classe como serviço
import org.springframework.web.server.ResponseStatusException;           // erro que já vira resposta HTTP

import java.util.List;

// Diz ao Spring: "esta classe contém a lógica do negócio"
@Service
public class PokemonService {

    // Limite máximo de itens ao listar (pedido da atividade: "não fritar o PC")
    private static final int LIMITE_LISTAGEM = 50;

    // O service depende do repositório
    private final PokemonRepository repository;

    // Construtor: o Spring entrega o repositório pronto (injeção de dependência)
    public PokemonService(PokemonRepository repository) {
        this.repository = repository;   // guarda o repositório recebido
    }

    // GET (lista): devolve todos, com limite de 50
    public List<Pokemon> listarTodos() {
        return repository.findAll(LIMITE_LISTAGEM);  // pede ao repositório no máximo 50
    }

    // GET (por id): devolve um pokémon ou dá erro 404
    public Pokemon buscarPorId(Long id) {
        return repository.findById(id)               // tenta achar pelo id
                .orElseThrow(() -> naoEncontrado()); // se não achar, lança erro 404
    }

    // GET (por nome): devolve um pokémon ou dá erro 404
    public Pokemon buscarPorNome(String nome) {
        return repository.findByNome(nome)           // tenta achar pelo nome
                .orElseThrow(() -> naoEncontrado()); // se não achar, lança erro 404
    }

    // POST: cria um pokémon novo
    public Pokemon criar(Pokemon pokemon) {
        validar(pokemon);          // garante que os dados fazem sentido
        pokemon.setId(null);       // ignora qualquer id enviado: quem gera o id é o sistema
        return repository.save(pokemon);  // salva e devolve já com o id gerado
    }

    // PUT: substitui os dados de um pokémon que já existe
    public Pokemon atualizar(Long id, Pokemon dados) {
        buscarPorId(id);           // se o id não existir, já lança 404 aqui
        validar(dados);            // garante que os dados novos fazem sentido
        dados.setId(id);           // mantém o id original (o save substitui o antigo)
        return repository.save(dados);    // salva por cima e devolve
    }

    // DELETE: apaga um pokémon
    public void deletar(Long id) {
        boolean apagou = repository.deleteById(id);  // tenta apagar
        if (!apagou) {                               // se não existia nada com esse id
            throw naoEncontrado();                   // erro 404
        }
    }

    // Regra simples: o nome é obrigatório
    private void validar(Pokemon pokemon) {
        if (pokemon.getNome() == null || pokemon.getNome().isBlank()) { // nome vazio ou em branco?
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do pokémon é obrigatório"); // erro 400
        }
    }

    // Monta o erro 404 em um lugar só, para não repetir
    private ResponseStatusException naoEncontrado() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokémon não encontrado");
    }
}