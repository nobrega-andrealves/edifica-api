# edifica-api

### Informações úteis sobre a contrução do sistema

* Criação da estrutura de base:
  * [Projeto criado com Spring Initializr](https://start.spring.io/)
    * Spring Boot 3.2.3;
    * Maven
    * Java 17
    
* Setup Inicial do Sistema:
  * Habilitar DEV Tools no Intellij: 
    * File >> Settings >> Build, Execution, Deployment >> Compiler >> Build project automatically
    * File >> Settings >> Advanced Settings >> Allow auto-make to start even...
* Repositório do código fonte do back-end:
  * [edifica-api - Github](https://github.com/nobrega-andrealves/edifica-api.git)
* Dependência org.flywaydb (migrations) - Informações Importantes:
  * Sempre parar o projeto ao criar os arquivos de migrations, para evitar que o Flyway os execute antes da hora, com o código ainda incompleto, causando com isso problemas;
  * Eventualmente pode acontecer de esquecermos de parar o projeto e algum erro acontecer ao tentar inicializar a aplicação. Nesse caso será exibido o seguinte erro ao tentar inicializar a aplicação:
    * Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Validate failed: Migrations have failed validation
  * Para resolver esse problema será necessário acessar o banco de dados da aplicação e executar o seguinte comando sql:
    * delete from flyway_schema_history where success = 0;
    * O comando anterior serve para apagar na tabela do Flyway todas as migrations cuja execução falhou. Após isso, basta corrigir o código da migration e executar novamente o projeto.
* JPA - Informações Importantes:
  * As linhas abaixo evitam que o JPA mude o nome do campo em caseCamel, usando underscore no lugar. Exemplo: sem as configurações abaixo, tipoIgreja viraria tipo_igreja no JPA, causando erro ao salvar, pois a tabela está diferente 
    * spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
    * spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
* Autenticação
  * Usei JWT para geração de token de autenticação, com a library auth0: https://jwt.io/libraries?language=Java
    * Repositório no git com documentação: https://github.com/auth0/java-jwt