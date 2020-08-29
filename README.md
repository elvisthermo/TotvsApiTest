# Totvs Test Api
[![status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Api de cadastro de clientes esse projeto é uma crud de cadastro de clientes.
 

## Dependencias e  framworks ultilizados
A aplicação foi desenvolvida ultilizando Spring Boot e foram ultilizadas as seguintes dependencias:
  -Spring Web
  - Sprng Boot Dev Tools
  - Postgres Drive
  - Spring Boot JPA
  
## Desenvolvimento
A aplicação foi desenvolivda model.
Os models criados são relacionados nas tableas do banco de dados são e estão listados abaixo:
- Models
    - Client
    - Dependent
    - Telephone
    - Address

Abaixo o diagrama de entidades relacionais:

![modelo MER](https://user-images.githubusercontent.com/18222474/91640401-bdde2b00-e9f3-11ea-8c4e-fea75be84d47.JPG)

### Rotas fornecidas pela aplicação 
As rotas fornecias na aplicação são as seguintes:
#### Clientes
Retorna uma lista de clientes
    
    Get:     localhost:8080/api/clients
    
Retorna um unico cliente de id
    
    Get:     localhost:8080/api/client/id

Salva um cliente no banco de dados

    Post:    localhost:8080/api/client

exemplo objeto json o objeto pode ou não conter os campos telefone,edereço,e dependentes:

```json
{
  "name": "Fulano",
  "nickname": "full",
  "cpfOrCnpj": "02151185418",
  "profession": "professor",
  "salary": 1500,
  "dateOfBirth": "09-08-1997",
  "telephone":[
      {
          "type":"Contato",
          "code":"+55",
          "ddd":"(91)",
          "number":"91982-1260"
    },
    {
        "type":"Residencial",
        "code":"+55",
        "ddd":"(91)",
        "number":"3263-8258"
    }
    ],
    "address":[{
        "addressType":"Residencial",
        "type": "Rua",
        "name":"rua do anjos",
        "number":"52",
        "complement":"ao lado da praça batista campos",
        "cep":"7845515",
        "neighborhood":"coqueiro",
        "city":"vituruino",
        "state":"MA",
        "country":"brasil"
  }],
 "dependents":[{
     "type":"Esposa",
     "name":"ana julia martins ulric"
     },
     {
         "type":"Filho",
         "name":"João pedro ulric"
         }]
    }
````

Atualiza um cliente

    Put:     localhost:8080/api/client/id
    
Deleta um cliente pela id

    Delete:  localhost:8080/api/clients/id

#### Endereços
Retorna uma lista de Endereços
    
    Get:     localhost:8080/api/address
    
Retorna um unico endereços de id
    
    Get:     localhost:8080/api/address/id

Salva um ou varios endereços no banco de dados relacionado com a id do cliente

    Post:    localhost:8080/api/adrress/client_id

exemplo objeto json podendo ser apenas um endereço ou uma lista:

```json
[{
    "addressType":"Residencial",
    "type": "Rua",
    "name":"rua do anjos",
    "number":52,
    "complement":"ao lado da praça batista campos",
    "cep":"7845515",
    "neighborhood":"coqueiro",
    "city":"Belém",
    "state":"PA",
    "country":"brasil"
  },
  {
   ...
  }
 ]}
````

Atualiza um endereço pela id

    Put:     localhost:8080/api/address/id
    
Deleta um cliente pela id

    Delete:  localhost:8080/api/address/id

#### Dependentes
Retorna uma lista de dependentes
    
    Get:     localhost:8080/api/dependent
    
Retorna um unico dependente de id
    
    Get:     localhost:8080/api/dependent/id

Salva um ou varios dependentes no banco de dados relacionados com a id do cliente

    Post:    localhost:8080/api/dependent/client_id

```json
[
    {
        "type":"Esposa",
        "name":"ana julia ulric"
    }
]
````

Atualiza um dependentes pela id

    Put:     localhost:8080/api/dependent/id
    
Deleta um cliente pela id

    Delete:  localhost:8080/api/dependent/id

#### Telefones
Retorna uma lista de Telefones
    
    Get:     localhost:8080/api/dependent
    
Retorna um unico telefones
    
    Get:     localhost:8080/api/dependent/id

Salva um ou varios teleefones no banco de dados relacionados com a id do cliente

    Post:    localhost:8080/api/telephones/client_id

```json
[
{
    "type":"Contato",
    "code":"+55",
    "ddd":"(91)",
    "number":"91982-1260"
},
]
````

Atualiza um telefone pela id

    Put:     localhost:8080/api/telephones/id
    
Deleta um telefone pela id

    Delete:  localhost:8080/api/telephones/id


### Arquivo de importação das requisições do Postman
* [workspace postman](https://github.com/elvisthermo/TotvsApiTest/tree/master/postman)

### Pré Requisitos.
- Java 8
- Postgresql
### Instalação/Execução
- Clone este repositório
- Crie o banco de dados local 
- Configure as variavies de ambiente no arquivo application.properties 
- Execulte a classe ApiTestApplication


### Versão:

1.0.0

### Author:

Elvis Thermo Carvalho Miranda

License
[MIT](LICENSE)
