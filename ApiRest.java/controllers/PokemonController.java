// Pacote (pasta) onde a classe fica
package com.example.apirestwithspring.controllers;

import com.example.apirestwithspring.entities.Pokemon;                 // a entidade
import com.example.apirestwithspring.services.PokemonService;          // o service com a lógica
import org.springframework.http.HttpStatus;                            // códigos HTTP
import org.springframework.web.bind.annotation.DeleteMapping;          // mapeia requisições DELETE
import org.springframework.web.bind.annotation.GetMapping;             // mapeia requisições GET
import org.springframework.web.bind.annotation.PathVariable;           // pega valor que vem na URL
import org.springframework.web.bind.annotation.PostMapping;            // mapeia requisições POST
import org.springframework.web.bind.annotation.PutMapping;             // mapeia requisições PUT
import org.springframework.web.bind.annotation.RequestBody;            // pega o JSON enviado no corpo
import org.springframework.web.bind.annotation.RequestMapping;         // define o caminho base
import org.springframework.web.bind.annotation.ResponseStatus;         // define o código HTTP da resposta
import org.springframework.web.bind.annotation.RestController;         // marca a classe como controller REST

import java.util.List;

// Esta classe recebe requisições web e devolve dados (JSON)
@RestController
// Todas as rotas daqui começam com /pokeApi
@RequestMapping("/pokeApi")
public class PokemonController {

    // O controller depende do service
    private final PokemonService service;

    // Construtor: o Spring entrega o service pronto (injeção de dependência)
    public PokemonController(PokemonService service) {
        this.service = service;  // guarda o service recebido
    }

    // GET /pokeApi/pokemon  -> lista todos (máx. 50)
    @GetMapping("/pokemon")
    public List<Pokemon> listarTodos() {
        return service.listarTodos();  // o service faz o trabalho; o Spring converte a lista em JSON
    }

    // GET /pokeApi/pokemon/1  -> busca por id
    @GetMapping("/pokemon/{id}")
    public Pokemon buscarPorId(@PathVariable Long id) {   // {id} da URL vira a variável id
        return service.buscarPorId(id);
    }

    // GET /pokeApi/pokemon/nome/pikachu  -> busca por nome (substitui o antigo whoIsThatPokemon)
    @GetMapping("/pokemon/nome/{nome}")
    public Pokemon buscarPorNome(@PathVariable String nome) {  // {nome} da URL vira a variável nome
        return service.buscarPorNome(nome);
    }

    // POST /pokeApi/pokemon  -> cria um pokémon novo
    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)                   // responde 201 (Criado) em vez de 200
    public Pokemon criar(@RequestBody Pokemon pokemon) {  // o JSON do corpo vira um objeto Pokemon
        return service.criar(pokemon);
    }

    // PUT /pokeApi/pokemon/1  -> atualiza o pokémon de id 1
    @PutMapping("/pokemon/{id}")
    public Pokemon atualizar(@PathVariable Long id, @RequestBody Pokemon pokemon) { // id da URL + dados do corpo
        return service.atualizar(id, pokemon);
    }

    // DELETE /pokeApi/pokemon/1  -> apaga o pokémon de id 1
    @DeleteMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)                // responde 204 (sem conteúdo): deu certo, nada a devolver
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}