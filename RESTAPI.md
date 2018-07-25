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
  
## Realizar pré-matrícula
  Aluno realiza pré-matrícula passando informações sobre disciplinas desejadas.

* **URL**: `/aluno/pre-matricula`
* **Method:** `POST`

* **JSON Request:**
	* ```javascript
	  {
	     "email" : "aluno@ccc.ufcg.edu.br",
	     "disciplinas" : [id1, id2, id3, id4]
	  }
	  ```
* **Success Response:**
  * **Code:** `200` <br />
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />

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
	         "nome" : "loac",
	         "numero_vagas" : 3,
	         "carga_horaria" : 60
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
	       "csv" : "a,b,c,d\n1,2,3,4"
	    }
		```		
* **Error Response:**
  * **Code:** `400 BAD REQUEST` and `401 UNAUTHORIZED`<br />
