package com.senac.grupo8.folhetosbrasil.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${swagger.server.name}")
    private String serverName;

    @Value("${swagger.server.url}")
    private String serverUrl;

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("FOLHETOS BRASIL").version("1.0v")
                        .description(
                                        "<h2>" +
                                        "  PROJETO INTEGRADOR" +
                                        "</h2>" +
                                        "<h3>Curso: Análise e Desenvolvimento de Sistemas</h3>" +
                                        "<h3>Grupo: 8</h3>" +
                                        "<h3>Integrantes:</h3>" +
                                        "<ul>" +
                                        "  <li>SEBASTIAO ANTONIO DE SA COSTA</li>" +
                                        "  <li>EVERSON DANIEL DA SILVA</li>" +
                                        "  <li>GISELA DE ARAUJO</li>" +
                                        "  <li>RAPHAEL DE MELLO</li>" +
                                        "  <li>TIAGO MARTINS LEAL DE LIMA</li>" +
                                        "  <li>LARISSA OLIVEIRA HORAS</li>" +
                                        "</ul>"
                        ))
                .servers(createServers());
    }

    private List<Server> createServers() {
        List<Server> servers = new ArrayList<>();
        Server server = new Server();
        server.setDescription(serverName);
        server.setUrl(serverUrl);
        servers.add(server);
        return servers;
    }
}
