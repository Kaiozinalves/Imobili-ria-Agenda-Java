# Projeto de Estudo - Imobiliaria: Agendamento de Avaliacoes

Este projeto e uma reimplementacao em Java de um projeto feito originalmente em C++ para a disciplina de Linguagem de Programacao I.

O objetivo e desenvolver um gerador de agendas para avaliacoes de imoveis. O sistema recebe dados de corretores, clientes e imoveis, distribui os imoveis entre os corretores avaliadores e calcula o horario de inicio de cada visita com base na distancia entre os locais.

Este repositorio tem finalidade de estudo proprio. A proposta e praticar Java, programacao orientada a objetos, organizacao de codigo e implementacao de algoritmos usando um problema ja conhecido.

## Como o Programa Funciona

O programa deve:

- Ler os dados pela entrada padrao
- Processar corretores, clientes e imoveis
- Identificar quais corretores sao avaliadores
- Distribuir os imoveis entre os avaliadores
- Calcular a melhor ordem de visitas para cada avaliador
- Imprimir a agenda final na saida padrao

A ideia e manter a mesma logica do projeto original: o programa pode ser executado redirecionando um arquivo de entrada para a aplicacao.

## Conhecimentos Utilizados

Este projeto utiliza e reforca conhecimentos como:

- Java
- Programacao orientada a objetos
- Classes, atributos, metodos e construtores
- Encapsulamento
- Enums
- Colecoes, como `List`
- Separacao de responsabilidades entre classes
- Leitura de dados pela entrada padrao
- Formatacao de saida
- Calculos com coordenadas geograficas
- Formula de Haversine
- Algoritmo Round-Robin
- Algoritmo do vizinho mais proximo
- Organizacao de projeto com Maven
- Uso de Spring Boot como base do projeto

## Entidades do Sistema

### Corretor

Representa um corretor da imobiliaria.

Campos principais:

- `id`
- `nome`
- `telefone`
- `avaliador`
- `latitude`
- `longitude`

Somente corretores marcados como avaliadores recebem imoveis para avaliacao.

### Cliente

Representa o proprietario de um imovel.

Campos principais:

- `id`
- `nome`
- `telefone`

### Imovel

Representa um imovel que precisa ser avaliado.

Campos principais:

- `id`
- `tipo`
- `proprietarioId`
- `latitude`
- `longitude`
- `endereco`
- `preco`

O tipo do imovel pode ser representado por um `enum`, por exemplo:

- `CASA`
- `APARTAMENTO`
- `TERRENO`

## Formato da Entrada

O programa deve ler os dados na seguinte ordem:

```text
[numero de corretores]
[telefone] [avaliador] [latitude] [longitude] [nome]
...
[numero de clientes]
[telefone] [nome]
...
[numero de imoveis]
[tipo] [proprietarioId] [latitude] [longitude] [preco] [endereco]
...
```

Observacoes:

- `avaliador` deve ser `1` para sim e `0` para nao
- `nome` pode conter espacos
- `endereco` pode conter espacos
- Textos livres ficam no final da linha

## Formato da Saida

A saida deve mostrar a agenda dos corretores avaliadores.

Exemplo:

```text
Corretor 1
09:04 Imovel 1
10:11 Imovel 3

Corretor 2
09:09 Imovel 2
```

Regras da saida:

- O horario deve estar no formato `HH:MM`
- Deve haver uma linha em branco entre agendas de corretores diferentes
- A saida deve conter apenas o agendamento

## Algoritmo de Agendamento

Cada avaliacao dura 1 hora. O tempo de deslocamento e calculado considerando 2 minutos por quilometro em linha reta.

### 1. Distribuicao dos Imoveis

Os imoveis sao distribuidos entre os corretores avaliadores usando Round-Robin.

Exemplo:

- Imovel 1 vai para o avaliador 1
- Imovel 2 vai para o avaliador 2
- Imovel 3 vai para o avaliador 3
- Imovel 4 volta para o avaliador 1

### 2. Ordenacao da Rota

Depois da distribuicao, cada corretor tem sua rota organizada pelo algoritmo do vizinho mais proximo.

Para cada avaliador:

- A rota comeca na localizacao inicial do corretor
- O horario inicial e `09:00`
- O sistema procura o imovel mais proximo ainda nao visitado
- Calcula o tempo de deslocamento ate esse imovel
- Agenda a visita no horario calculado
- Soma 1 hora referente ao tempo de avaliacao
- Repete o processo ate acabar a lista de imoveis daquele corretor

## Calculo de Distancia

A distancia entre dois pontos e calculada pela formula de Haversine, usando latitude e longitude.

Essa formula permite estimar a distancia em quilometros entre duas coordenadas geograficas.

## Como Executar

O programa deve ler os dados pela entrada padrao. Por isso, a execucao segue a mesma logica do projeto original em C++: um arquivo de entrada e redirecionado para o programa.

Linux/macOS:

```bash
./mvnw spring-boot:run < entrada.txt
```

Windows:

```bash
mvnw.cmd spring-boot:run < entrada.txt
```

Tambem e possivel redirecionar a saida para um arquivo:

```bash
./mvnw spring-boot:run < entrada.txt > saida.txt
```

## Exemplo de Entrada

```text
2
83999990000 1 -7.1150 -34.8631 Joao Silva
83988880000 1 -7.1200 -34.8500 Maria Souza
2
83977770000 Carlos Lima
83966660000 Ana Costa
3
Casa 1 -7.1300 -34.8600 250000 Rua das Flores
Apartamento 2 -7.1400 -34.8700 320000 Avenida Central
Terreno 1 -7.1250 -34.8550 150000 Loteamento Sul
```

## Status

Projeto em desenvolvimento para estudo proprio em Java.
