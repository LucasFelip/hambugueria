# Hambugueria
Projeto focando em desenvolvimento de uma api para controle de uma  hamburgueria com o foco em aprimoramento de tecnicas de desenvolvimento, além de adicional de projeto como portifolio.

## Objetivo
O objeito desse projeto é permitir o gerenciamento de pedidos, entregas de uma hambugueria, integrado a duas interfaces (de cliente e de administrador) podendo exercer funções diferentes dentro do mesmo sistema. A motivação surgiu como uma necessidade de vista de maneira pessoal para gestão da cadeia de produção, e entrega, do produto, com isso o sistema tem uma caracteristica de desenvolvimento voltadas a atenter necessidades, sendo essas especificas.

# Como rodar o projeto 

```bash
# clonar repositório
git clone https://github.com/LucasFelip/hamburgueria

# entrar na pasta do projeto back end
cd hamburgueria

# executar o projeto
./mvnw spring-boot:run
``` 

# Documentação
Documentação foi moldada com base no Swagger, para registrar funções da api, podendo ser acessado na execução do projeto de maneira local:

    http://localhost:8081/swagger-ui/index.html

## Usuario
Essa entidade é caracterizada por representar a generalização de cliente e administrador, que são diferenciados pelas funções que execem dentro do sistema, tendo isso em vista, temos as funções abaixo para a entidade:


## Hamburguer
Essa entidade é caracterizada por representar a definição de hamburguer, , tendo isso em vista, temos as funções abaixo para a entidade:
