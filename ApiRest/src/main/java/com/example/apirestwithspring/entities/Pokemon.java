// Define o pacote (a pasta) onde este arquivo de controle está guardado no projeto
package com.example.apirestwithspring.controllers;

// Importa a entidade ou DTO que representa o material/pedido que transita na API
import com.example.apirestwithspring.entities.Material;
// Importa o serviço que contém a regra de negócio (a "cozinha" da aplicação)
import com.example.apirestwithspring.services.MaterialService;

// Importações do Spring Framework para criar as rotas web (API REST)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController avisa o Spring que esta classe vai receber requisições web e responder em JSON
@RestController
// @RequestMapping define o endereço base (URL) para acessar os endpoints desta classe (ex: /api/materiais)
@RequestMapping("/api/materiais")
public class MaterialController {

    // Declara o serviço que será injetado. O "final" garante que ele não muda depois de iniciado.
    private final MaterialService materialService;

    // Construtor para a Injeção de Dependência do Spring (o Spring injeta o serviço automaticamente aqui)
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    // 1. ENDPOINT GET: Buscar materiais por nome ou termo de similaridade (Fuzzy Search)
    // URL de acesso: GET /api/materiais/buscar?termo=parafuso
    @GetMapping("/buscar")
    public List<Material> buscarMateriais(@RequestParam String termo) {
        // O Controller apenas recebe o pedido da web e repassa para o Service processar a busca
        return materialService.buscarPorSimilaridade(termo);
    }

    // 2. ENDPOINT POST: Cadastrar um novo material/pedido validando duplicações
    // URL de acesso: POST /api/materiais
    @PostMapping
    public Material cadastrarMaterial(@RequestBody Material novoMaterial) {
        // @RequestBody pega o JSON enviado no corpo da requisição e transforma no objeto Material do Java
        return materialService.salvarMaterial(novoMaterial);
    }
}