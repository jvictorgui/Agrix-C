# Como executar o projeto

## Pré-requisitos:

* Ter o Git instalado
* Ter o Java instalado e configurado
* Ter o Maven instalado

## Passos:

**1. Clone ou baixe o repositório:**

git clone git@github.com:jvictorgui/Agrix-C.git


**2. Entre no diretório:**

cd project-agrix-java-fase-c


**3. Instale as dependências:**

mvn install -DskipTests


**4. Execute a aplicação:**

 Executar a Classe Principal (AgrixApplication.java)


## Rotas Criadas no Projeto

**Observações:**

* O acesso a algumas rotas é restrito a usuários com roles específicos.
*  Para conseguir acessar as rotas é necessário cria um usuário através da rota persons e logar através da rota auth/login para receber o Token.

**Rotas disponíveis:**

**---**

## Rotas Liberadas:

**---**

**POST /persons:**

Cria um novo usuário.

**POST /auth/login:**

Realiza o login do usuário e retorna um token JWT para autenticação.

**POST /farms:**

Cria uma nova fazenda.

**GET /farms:**

Retorna uma lista de fazendas.

**---**

## Rotas que exigem acesso de User, Manager ou Admin:

**---**

**GET /farms/{id}:**

Retorna detalhes de uma fazenda específica.

**POST /farms/{farmId}/crops:**

Adiciona uma nova plantação a uma fazenda existente.

**GET /farms/{farmId}/crops:**

Retorna uma lista de plantações em uma fazenda específica.

**GET /crops:**

Retorna uma lista de todas as plantações.

**---**

## Rotas que exigem acesso de Admin ou Manager:

**---**

**GET /crops/{id}:**

Retorna detalhes de uma plantação específica.

**GET /crops/search:**

Permite buscar plantações por critérios específicos.

**POST /fertilizers:**

Adiciona um novo fertilizante.

**GET /fertilizers:**

Retorna uma lista de todos os fertilizantes.

**---**

## Rotas que exigem acesso de Admin:

**---**

**GET /fertilizers/{id}:**

Retorna detalhes de um fertilizante específico.

**POST /crops/{cropId}/fertilizers/{fertilizerId}:**

Associa um fertilizante a uma plantação específica.

**GET /crops/{cropId}/fertilizers:**

Retorna a lista de fertilizantes associados a uma plantação.

**---***

## Principais Tecnologias

**+ Java**

**+ JUnit**

**+ Docker**

**+ Mysql**

**+ JWT**

**+ Spring**

