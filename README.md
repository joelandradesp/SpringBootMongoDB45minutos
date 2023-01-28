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

* @Valid - Para ativar as validações da Entidade (Campo vazio, Email inválido)

## Endpoints

** Observação:** a porta 8080 pode ser modificada caso tenha conflito com outra aplicação que esteja usando. O arquivo application.properties temos uma propriedade server.port = 8080.
Na sua ausência o padrão é 8080.

* http://localhost:8080/api/clientes

### ResponseEntity

ResponseEntity é um objeto próprio do Spring Boot que ajuda a retornar os dados da comunicação.

ResponseEntity.ok retorna um codigo 200 que quer dizer sucesso.

## Validações

Utilizando Hibernate Validator.

`NotEmpty` - Deprecated (Depreciado).

```

	@NotNull(message = "Nome não pode ser vazio")
	public String getNome() {
		return nome;
	}

```

## Deprecated

Houve algumas mudanças das bibliotecas de validações.

Antes no pom.xml declaravamos hibernate-validator:

```

<dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.0.2.Final</version>
</dependency>

```

**Deprecated:**

```

import org.hibernate.validator.constraints.NotBlank;

```


**Deprecated:**

```

javax.validation.constraints.NotBlank
javax.validation.constraints.NotEmpty

```

No pom.xml é necessário colocar uma dependência se não a validação não funciona com ** @Valid **, além disso é necessário colocar o ** @Valid ** após o @RequestBody:

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		
```
### Agora deve ser usado a validação do jakarta:

A Oracle passou a tutela para a Eclipse Foundation (Jakarta).

```

import jakarta.validation.constraints.NotNull

```

## Genericos

Quando na controller, tentamos implementar uma validação de erros. O Retorno esperado era Cliente:

```

	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(erros);
		} 
		return ResponseEntity.ok(this.clienteService.cadastrar(cliente));
	}

```

A linha return ResponseEntity.badRequest().body(erros); causa uma erro de compilação, pois o método cadastrar espera um Cliente como retorno e não erros de validações, cadastro.

Response<T> - com essa atribuição posso receber qualquer coisa:

```
public class Response<T> {

}
```

Usei o Response para retornar um Inteiro, um cliente, e uma Lista de Cliente. Você pode utilizar qualquer tipo de retorno.

**Classe utilitária Response:**

```

import java.util.List;

public class Response<T> {
	
	private T data;
	private List<String> erros;
	
	public Response(T data) {
		this.data = data;
	}
	
	public Response(List<String> erros) {
		this.erros = erros;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}

```

* Parametro BindingResult - é o resultado da minha validação. Se possue erros ou não.

## Execução

Ao executar como Spring Boot App clicando em cima do projeto Run As ou Debug As. Vai subir um Tomcat local na porta 8080.


