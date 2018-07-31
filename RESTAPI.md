#  REST API Endpoints
Esta seção provê uma lista detalhada dos endpoints disponíveis no back-end.

## Obter disciplinas cadastradas
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
  
## Cadastrar aluno
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
  
## Realizar pré-matrícula
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

## Cadastrar disciplina
  Coordenador cadastra uma disciplina no sistema.

* **URL**: `/coordenador/cadastro-disciplina`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "usuario" : "coordenador",
	     "senha" : "coordenador",
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
  
## Exportar CSV
  Coordenador exporta um CSV com as pré-matrículas realizadas no sistema.

* **URL**: `/coordenador/exporta-csv`
* **Method:** `PUT`

* **JSON Request:**
	* ```javascript
	  {
	     "usuario" : "coordenador",
	     "senha" : "coordenador"
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
