// Pacote raiz do projeto (as outras pastas ficam "dentro" dele)
package com.example.apirestwithspring;

import org.springframework.boot.SpringApplication;                     // classe que inicia o Spring
import org.springframework.boot.autoconfigure.SpringBootApplication;   // anotação principal do Spring Boot

// Liga a configuração automática e faz o Spring procurar controllers, services e repositories neste pacote e nos de dentro
@SpringBootApplication
public class ApirestwithspringApplication {

    // main: o ponto onde todo programa Java começa a executar
    public static void main(String[] args) {
        // Sobe o servidor web (porta 8080) e registra todas as nossas classes
        SpringApplication.run(ApirestwithspringApplication.class, args);
    }
}