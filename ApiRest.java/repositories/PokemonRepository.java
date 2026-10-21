// Pacote (pasta) onde a classe fica
package com.example.apirestwithspring.repositories;

import com.example.apirestwithspring.entities.Pokemon;   // a entidade que vamos guardar
import org.springframework.stereotype.Repository;       // anotação que marca a classe como repositório

import java.util.LinkedHashMap;      // mapa que mantém a ordem em que os itens entraram
import java.util.List;               // lista de itens
import java.util.Map;                // estrutura chave -> valor
import java.util.Optional;           // "caixa" que pode ou não conter um valor (evita null)
import java.util.stream.Collectors;  // transforma o resultado de um stream em lista

// Diz ao Spring: "esta classe cuida do acesso aos dados; crie e gerencie ela para mim"
@Repository
public class PokemonRepository {

    // "Banco de dados" na memória: chave = id, valor = Pokémon (some quando o app reinicia)
    private final Map<Long, Pokemon> banco = new LinkedHashMap<>();

    // Contador usado para gerar o próximo id automaticamente
    private long proximoId = 1;

    // Construtor: já deixa alguns pokémons cadastrados para facilitar os testes
    public PokemonRepository() {
        save(new Pokemon(null, "Pikachu", "Elétrico", 25));    // id null: o save gera o id
        save(new Pokemon(null, "Charmander", "Fogo", 12));
        save(new Pokemon(null, "Bulbasaur", "Planta", 10));
    }

    // Devolve os pokémons, no máximo "limite" itens
    public List<Pokemon> findAll(int limite) {
        return banco.values()                  // pega todos os pokémons guardados
                .stream()                      // percorre um por um
                .limit(limite)                 // corta no limite (evita listar demais)
                .collect(Collectors.toList()); // junta o resultado numa lista
    }

    // Procura um pokémon pelo id; Optional vazio se não existir
    public Optional<Pokemon> findById(Long id) {
        return Optional.ofNullable(banco.get(id)); // busca no mapa e embrulha o resultado
    }

    // Procura um pokémon pelo nome, ignorando maiúsculas/minúsculas
    public Optional<Pokemon> findByNome(String nome) {
        return banco.values()
                .stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome)) // mantém só quem tem o nome igual
                .findFirst();                                    // pega o primeiro encontrado (se houver)
    }

    // Salva (cria ou substitui) um pokémon
    public Pokemon save(Pokemon pokemon) {
        if (pokemon.getId() == null) {          // se ainda não tem id, é um pokémon novo
            pokemon.setId(proximoId++);         // dá o id atual e já aumenta o contador
        }
        banco.put(pokemon.getId(), pokemon);    // guarda no mapa (se o id já existir, substitui)
        return pokemon;                         // devolve o pokémon salvo, já com id
    }

    // Apaga pelo id; devolve true se existia e foi apagado, false se não existia
    public boolean deleteById(Long id) {
        return banco.remove(id) != null;        // remove devolve o item removido, ou null se não havia
    }
}