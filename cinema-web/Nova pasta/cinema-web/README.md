# Cinema Web

Projeto desenvolvido para gerenciar filmes e análises em uma casa cultural. Este sistema permite que os usuários cadastrem filmes, visualizem uma lista de filmes cadastrados e adicionem análises com notas para cada filme.

## Funcionalidades

1. **Cadastro de Filmes**  
   - Permite adicionar informações sobre filmes, incluindo:
     - Título
     - Sinopse
     - Gênero
     - Ano de lançamento

2. **Listagem de Filmes**  
   - Exibe uma lista de todos os filmes cadastrados no sistema.

3. **Detalhes do Filme**  
   - Exibe informações detalhadas sobre um filme específico.
   - Permite adicionar análises e notas para o filme selecionado.

4. **Armazenamento em Memória**  
   - O sistema utiliza armazenamento em memória para fins de prototipagem, sem a necessidade de um banco de dados.

## Tecnologias Utilizadas

- **Java 11**: Linguagem de programação principal.
- **Spring Boot 2.5.4**: Framework para desenvolvimento web.
- **Thymeleaf**: Motor de templates para renderização de páginas HTML.
- **Maven**: Gerenciador de dependências e build.

## Estrutura do Projeto

- **Controller**: Gerencia as requisições HTTP e conecta as views com as regras de negócio.
- **Model**: Representa as entidades do sistema (`Filme` e `Análise`).
- **View**: Páginas HTML renderizadas com Thymeleaf para interação com o usuário.

## Como Executar o Projeto

1. Certifique-se de que o Java 11 e o Maven estão instalados no sistema.
2. No terminal, navegue até o diretório do projeto.
3. Execute o comando:
   ```bash
   mvn spring-boot:run