# Gerenciamento de Projetos e Tarefas

Este é um projeto de gerenciamento de projetos e tarefas desenvolvido utilizando Spring Framework, Hibernate e JavaServer Faces (JSF). O objetivo do projeto é fornecer uma aplicação web para adicionar e listar projetos e tarefas.

## Tecnologias Utilizadas

- **Spring Framework**: Para gerenciamento de dependências e configuração.
- **Hibernate**: Para gerenciamento de persistência de dados e mapeamento objeto-relacional (ORM).
- **JavaServer Faces (JSF)**: Para criação de interfaces web.
- **RichFaces**: Biblioteca para componentes avançados de UI (observa-se que enfrentamos problemas com essa biblioteca).
- **Docker Compose**: Para configurar e gerenciar o banco de dados.

## Instalação e Configuração

### Pré-requisitos

- Java 8 ou superior
- Maven
- Docker e Docker Compose

### Configuração do Banco de Dados

O banco de dados está configurado para ser executado em um container Docker. Para configurar o banco de dados, siga os seguintes passos:

1. **Clone o Repositório**

   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DO_REPOSITORIO>
Configuração do Docker Compose

O arquivo docker-compose.yml contém a configuração para o banco de dados. Certifique-se de que o Docker e o Docker Compose estejam instalados e executando.

Inicie os Contêineres

docker-compose up -d

Isso iniciará o banco de dados PostgreSQL e o deixará disponível na porta 5432.

Configure a Conexão com o Banco de Dados

Certifique-se de que o application.properties em seu projeto está configurado para conectar ao banco de dados Docker:

**Problemas Conhecidos**

Problemas com RichFaces

Durante o desenvolvimento do projeto, enfrentamos problemas significativos com a biblioteca RichFaces, que resultaram em desafios técnicos consideráveis:

**Desatualização:** A biblioteca RichFaces não está mais sendo mantida ativamente. Isso tornou a busca por documentação e suporte difícil, com muitos recursos disponíveis sendo obsoletos.

**Incompatibilidade:** A integração de RichFaces com outras bibliotecas e frameworks modernos foi problemática. Os componentes do RichFaces não funcionaram conforme esperado, o que levou a uma tentativa de substituí-los por alternativas mais atuais.

**Configuração de Dependências:** A inclusão manual dos JARs do RichFaces e a configuração no Maven foram complicadas. Problemas na resolução das dependências e incompatibilidades foram desafios técnicos que impactaram o desenvolvimento.

Devido a esses problemas, a aplicação não possui a implementação completa dos componentes RichFaces. Recomenda-se considerar alternativas mais atuais e ativamente mantidas para futuras implementações.

Executar o Projeto
Para executar a aplicação, use os seguintes comandos:

Compilar o Projeto

mvn clean install

Executar o Servidor de Aplicação

Dependendo de sua configuração, você pode iniciar a aplicação usando o Maven:

mvn spring-boot:run

Ou empacotar a aplicação como um WAR e implantá-la em um servidor de aplicação compatível.

**Contribuições**

Se você deseja contribuir para o projeto, por favor, faça um fork do repositório, crie uma branch com sua alteração e envie um pull request.

