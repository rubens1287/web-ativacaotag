# PROJETO MODELO PARA TESTE WEB 

Projeto desenvolvido com proposito de ser um modelo base para teste de interface web

## PRÉ-REQUISITOS

Requisitos de software e hardware necessários para executar este projeto de automação

*   Java 1.8 SDK
*   Maven 3.5.*
*   Navegador Web (Chrome, Opera, FireFox, Edge ou Safari)
*   Intellij IDEA Community
*   Plugins do Intellij
    * Cumcuber for java
    * Lombok
    * Ideolog 

## ESTRUTURA DO PROJETO

| Diretório                    	| finalidade       	                                                                                        | 
|------------------------------	|---------------------------------------------------------------------------------------------------------- |
| src\main\java\core\azure 		| Responsável por enviar os resultados para o test management do Azure Devops                               |
| src\main\java\core\config 	| Interface com as propriedades dos arquivos de ambiente 'Properties'                                       |
| src\main\java\core\data    	| Reponsável por ler arquivos yaml file e retonar objeto HashMap com os valores dos campos                  |
| src\main\java\core\dates 		| Metodos de suporte para trabalhar com datas                                                              	|
| src\main\java\core\documents	| Responsável gerar CPFs sintéticos e validos                                                              	|
| src\main\java\core\driver 	| Responsável por fabricar os drivers para rodar local e remoto para varios navegadores                    	|
| src\main\java\core\strings 	| Responsável por fazer tratamentos em string                                                             	|
| src\main\java\core\zalenium 	| Responsável por interagir com o zalenium                                                               	|
| src\main\java\pages			| Local onde deve ser criado as pages objects para facilitar a manutenção do projeto                       	|
| src\main\java\model			| Responsável por organizar os objetos modelos utilizado no suporte dos scripts de teste               		|
| src\main\java\support			| Metodos de suporte a interação com os elementos web fazendo ações de click e esperas explicitas          	|
| src\main\resources\conf	    | Arquivos de configuração segregados por ambiente                                                        	|
| src\test\java\hooks          	| Metodos que executam antes e depois de cada teste (@Before, @After)                                   	|
| src\test\java\runner         	| Metodo prinicipal que inicia os testes via cucumber                                                      	|
| src\test\java\steps         	| Local onde deve ser criado as classes que representam os steps definition do cucumber                    	|
| src\test\resources\data       | Massa de dados segregada por ambiente, escritos em arquivos yaml                                      	|
| src\test\resources\features 	| Funcionalidade e cenários de teste escritos em linguagem DSL (Gherkin language)                        	|   
    
## DOWNLOAD DO PROJETO TEMPLATE PARA SUA MÁQUINA LOCAL

Faça o donwload do template no repositório de código para utilizar no seu projeto em especifico, 
feito isso, fique a vontande para usufruir dos recursos disponíveis e 
também customizar de acordo com sua necessidade. 


## FRAMEWORKS UTILIZADOS

Abaixo está a lista de frameworks utilizados nesse projeto

| Framework                    	| finalidade       	                                                                                        | 
|------------------------------	|---------------------------------------------------------------------------------------------------------- |
| Jackson                  		| Responsável pela leitura de dados de arquivo yaml file                                                    |
| Selenium                     	| Responsável pela interação com páginas web                                                                |
| RestAssured               	| Reponsável realizar a integração com a API do test management do Azure Devops                             |
| Java Faker             		| Geracão de dados sintéticos                                                                             	|
| Cucumber                  	| Responsável pela especificação executável de cenários                                                   	|
| Cucumber Junit             	| Responsável pela especificação executável de cenários                                                     |
| Lombok                     	| Otimização de classes modelos                                                                         	|
| Log4j2                     	| Responsável pelo Log do projeto                                                                          	|
| AeonBits          			| Responsável por gerenciar as properties                                                                  	|


## INTEGRAÇÃO COM AZURE DEVOPS

A integração com test managment do azure, e feito atravês do arquivo de properties <b>"src\main\resources\azure.properties"</b> 
onde você deve informa os parametros abaixo;

```
# host do azure
host.azure = <Host do Servido>

# Nome do Projeto
project = <Nome do Projeto>

# Token de acesso ao modulo test management com permisão de escrita e leitura
personal.access.token = <Token do usuário do azure devops>
```

Para concluir a configuração, você deve aplicar as tags reservadas no arquivo de features do cucumber;


```
@PlanId=<Id do plano de teste no azure>
@SuiteId=<Id do suite de teste no azure>
@TestId=<Id do caso de teste no azure>
```

Exemplo:

```
# language: pt
# charset: UTF-8

@PlanId=5
@SuiteId=9
Funcionalidade: Login
   Eu como cliente gostaria de acessar o sistema via login somente com credenciais validas

  @TestId=7
   Cenario: CT001 - Login - Executar login com valido
    Dado eu estou na pagina de login
    Quando eu efetuar o login com credencias validas
    Entao sera apresentado a tela do menu principal
```

## COMANDO PARA EXECUTAR OS TESTES

Com o prompt de comando acesse a pasta do projeto, onde esta localizado o arquivo pom.xml, execute o comando abaixo para rodar os testes automatizados.

```
mvn clean test
```


## MULTIPLOS COMANDOS PARA EXECUTAR OS TESTES 

Você também pode mesclar a linha de comando maven com options do cucumber, 
sendo assim você pode escolher uma determinada tag que se deseja executar do cucumber, 
podendo escolher também a massa de dados que irá utilizar e juntamente aplicar o linha de comando para gerar o report HTML.

```
mvn clean test -Dcucumber.options="--tags @dev" -Denv=des -Dbrowser=chrome
```

## TESTES CONTINUOS

### AZURE DEVOPS

Executar testes de forma continua vem se tornado fundamental para agregar valor junto a seu time,
para isto foi configurado o pipeline para ser aplicado ao jenkins chamando "azurepipeline.yml"
localizado na raiz do projeto

### PRE-REQUISITOS

Configurações necessárias para rodar o pipeline no Azure Devops

*   Agente com acesso as aplicações da companhia
   
### ETAPAS

* Checkout do código
* Agent azure devops
* Download do Zalenium como infraestrutura 
* Execução dos containers do Zalenium
* Execução dos testes
* Upload do arquivo de resultados junit.xml para Azure
* Encerramento da infraestrutura do Zalenium


## EVIDÊNCIAS

As evidências são enviadas diretamente para o Azure Devops, garantido a centralização dos resultados de teste

Os arquivos com as evidências ténicas ficam localizados na pasta target do projeto, esta pasta só é criada depois da primeira execução.

```
 Json Cucumber: target/json-cucumber-reports/cucumber.json
 Xml Junit: tagert/xml-junit/junit.xml
```

## LOG DE EXECUÇÃO

Os logs de execução gerados pelo Log4j2 ficam alocados na pasta target/log

## CARACTERISTICAS ESPECIAIS

* Download automatico dos binários dos drivers para diferentes tipos de versões de navegadores e sistema operacional.
* Segregação de massa por ambiente via arquivos yaml file.
* Segregação das configurações de ambiente via arquivo properties file.
