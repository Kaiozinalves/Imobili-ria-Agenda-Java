# Imobiliaria - Agendamento de Avaliacoes

Projeto de estudo em Java baseado em uma versao anterior feita em C++.

O objetivo e praticar os principais conhecimentos necessarios para desenvolver uma aplicacao orientada a objetos: criacao de classes, encapsulamento, uso de colecoes, enums, organizacao de codigo, leitura de dados, calculos matematicos e implementacao de algoritmos.

## Sobre o Projeto

O sistema simula o agendamento de avaliacoes de imoveis para uma imobiliaria. Ele trabalha com corretores, clientes e imoveis, distribuindo as avaliacoes entre os corretores avaliadores e calculando os horarios das visitas.

## Conhecimentos Praticados

- Java
- Programacao orientada a objetos
- Classes, atributos, metodos e construtores
- Encapsulamento
- Colecoes
- Enums
- Organizacao de projeto com Maven
- Algoritmo Round-Robin
- Algoritmo do vizinho mais proximo
- Formula de Haversine para calculo de distancia
- Formatacao de horarios e saidas

## Tecnologias

- Java
- Maven
- Spring Boot

## Como Executar

O programa deve ler os dados pela entrada padrao. Assim, ele pode ser executado redirecionando um arquivo de entrada, seguindo a mesma logica do projeto original em C++.

Linux/macOS:

```bash
./mvnw spring-boot:run < entrada.txt
```

Windows:

```bash
mvnw.cmd spring-boot:run < entrada.txt
```

Isso significa que o conteudo do arquivo `entrada.txt` sera enviado para o programa como se fosse digitado no teclado.

Tambem e possivel salvar a saida em outro arquivo:

```bash
./mvnw spring-boot:run < entrada.txt > saida.txt
```

## Status

Projeto em desenvolvimento para estudo proprio e pratica de Java.
