#  REST API Endpoints
Esta seção provê uma lista detalhada dos endpoints disponíveis no back-end.

# 1. Disciplinas
## 1.1. Obter disciplinas cadastradas
  Retorna informaçes sobre disciplinas cadastradas no sistema.

* **URL**: `/disciplinas`
* **Method:** `GET`
* **Success Response:**
  * **Code:** `200` <br /> **Content:** 
	  * ```javascript
	    {
	       "disciplinas" : [
		     {disciplina1},
		     {disciplina2}
	       ]
	    }
		```	
* **Error Response:**
  * **Code:** `400 BAD REQUEST`<br />

# 2. Alunos
## 2.1. Cadastrar aluno
  Aluno realiza cadastro passando informações sobre seu vínculo com o curso.

* **URL**: `/aluno`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "nome" : "Aluno da Silva",
	     "email" : "aluno.da.silva@ccc.ufcg.edu.br",
	     "matricula" : "123456",
	     "periodo" : "20171"
	  }
	  ```
* **Success Response:**
  * **Code:** `200` <br />
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />
  
## 2.2. Realizar pré-matrícula
  Aluno realiza pré-matrícula passando informações sobre disciplinas desejadas.

* **URL**: `/aluno/pre-matricula`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "email" : "aluno@ccc.ufcg.edu.br",
	     "disciplinas" : [codigo1, codigo2, codigo3]
	  }
	  ```
* **Success Response:**
  * **Code:** `200` <br />
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />
  * **Bad Request Errors:**
    * `{ "message" : "JSON Mal formado" }`
    * `{ "message" : "Disciplinas não atendem o número de créditos" }`

# 3. Coordenador
## 3.1. Cadastrar disciplina
  Coordenador cadastra uma disciplina no sistema.

* **URL**: `/coordenador/cadastro-disciplina`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "login" : "coordenador",
	     "password" : "coordenador",
	     "disciplina" : {
	         "codigo" : 1,  
	         "nome" : "loac",
	         "numero_vagas" : 3,
	         "carga_horaria" : 60,
	         "creditos" : 4,
	         "grade" : "ambas"
	     }
	  }
	  ```
* **Success Response:**
  * **Code:** `200` <br />
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />  
  
## 3.2. Exportar CSV
  Coordenador exporta um CSV com as pré-matrículas realizadas no sistema.

* **URL**: `/coordenador/exporta-csv`
* **Method:** `PUT`

* **JSON Request:**
	* ```javascript
	  {
	     "login" : "coordenador",
	     "password" : "coordenador"
	  }
	  ```
* **Success Response:**
  * **Code:** `200` <br /> **Content:** 
	  * ```javascript
	    {
	       "csv" : "nome,email,matricula,periodo,disciplinas\nfulano,fulano@ccc.ufcg.edu.br,1111,20171,[codigo1,codigo2]"
	    }
		```		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />
  
  ## 3.3. Mudar Senha
  Coordenador muda a sua senha no sistema.

* **URL**: `/coordenador/mudar-senha`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "login" : "coordenador",
	     "password" : "coordenador"
	     "newPassword" : "new_password"
    }
	  ```
* **Success Response:**
  * **Code:** `200` <br /> **Content:** 
	  * ```javascript
	    {
	       "message" : "Success!"
	    }
		```		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />
