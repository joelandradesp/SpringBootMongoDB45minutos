# Curso Rápido - 45 minutos

Duração do Vídeo: 46:10 minutos.

Kazale.com

Instrutor: Marcio Souza.

## API RestFull com Spring Boot, Java 8, MongoDB

Nesta aula você aprenderá a criar um CRUD completo de cadastro de clientes: Get, Post, Put, Delete.

* get - Consulta
* Post - Inserindo registros
* Put - Alterado registros.
* Delete - Deletando registros.

### Pré Requisito para essa aula.

1. Ter o Java versão mínima 8, instalado na máquina (Jdk e Runtime)
2. Configurações no Path do Windows do Java.
3. Ter um editor para manipulação do Java. (Sts - Spring Tool Suite, Eclipse, IntelliJ)
4. Ter o mongodb instalado na máquina com configuração no Path do Windows.

## MongoDB

* Executar o comando mongod no prompt de comando do Windows. (server)

## STS - Spring Tool Suite

* Usar o site https://start.spring.io/ ou no Spring Tool Suite - File - New - Spring Starter Project.
* Caso não tenha o Spring Tool Suite instalado, basta baixar no site: https://spring.io/tools.
* Versão em 26/01/2023 - 4.17.1 - Windows X86_64.

## Depêndencias

* Spring Boot DevTools
* Spring Data MongoDB
* Spring Security
* Spring Web

Java utilizado versão 17.

## Packages do Projeto Crud

* document - são os meus documentos do mongodb. 
* repository - tem acesso aos documentos. As operações padrões são herdadas do MongoRepository.
* service - A camada de serviços é a responsável por criar as ações que vão fazer a persistência e acesso ao banco de dados.

## Anotattions

* @AutoWired - é a anotação mais utiliza com relação a injeção de dependências. Como o próprio nome diz, o Autowired, indica um ponto aonde a injeção automática deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores.

Aqui neste código estou injetando o serviço ClienteService:

````

@AutoWired
private ClienteService clienteService;

````

Para estar disponível preciso usar a Anotation ** @AutoWired **.
E ClienteService é a Interface por boas práticas.

* @Service - é a notação que informa para o SpringBoot que é uma camada de serviço.

* @Document - neste caso é uma anotação que é específica do MongoRepository que informa que o Objeto é um Documento do MongoDB.

* @RestController - isso vai fazer que o Spring disponibilize como um Controller do tipo Rest.

* @RequestMapping - path, a Url da API.

* @GetMapping - Faz um retorno de uma consulta. Pode ser um id, Lista. Posso passar um Path também para ele.

* @GetMapping(path = "/{id}") - esse {id} é um valor dinâmico que estará na URL a ser substituído por um parâmetro.

* @PathVariable - para converter o id passado na URL para o Java eu uso a Anotação chamada @PathVariable. O Spring Boot pega o valor da URL com @PathVariable(name = "id") e converte para o parametro String id.

* @PostMapping - Utilizado para Inserir dados.

* @RequestBody - As informações são passadas não na URL e sim como Post no corpo da requisição.
 
* @PutMapping - Utilizado para Atualizar dados. É igual o Post mas passamos um id como parametro para filtrar qual registro será alterado.

* @DeleteMapping - Semelhante ao @PutMapping, é utilizado para deletar um registro. E se passa também o id como parametro.

## Endpoints

** Observação:** a porta 8080 pode ser modificada caso tenha conflito com outra aplicação que esteja usando. O arquivo application.properties temos uma propriedade server.port = 8080.
Na sua ausência o padrão é 8080.

* http://localhost:8080/api/clientes

### ResponseEntity

ResponseEntity é um objeto próprio do Spring Boot que ajuda a retornar os dados da comunicação.

ResponseEntity.ok retorna um codigo 200 que quer dizer sucesso.