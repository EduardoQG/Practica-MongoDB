package es.studium.practicaT4;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Test {

	public static void main(String[] args) {
		
		/* En esta clase se crea un objeto de la clase 'Modelo' para poder acceder a sus métodos,
		 * se hacen las gestiones necesarias para poder conectarse a la base de datos Mongo, es decir,
		 * crear el objeto MongoClient, el objeto MongoDatabase, para obtener la base de datos, y el objeto
		 * MongoCollection para obtener la colección.
		 * 
		 * Todos estos objetos provienen de las librerías importadas a través de la dependencia de MongoDB
		 * añadida en el archivo pom.xml.
		 */
		
		Modelo m = new Modelo();
		// TODO Auto-generated method stub
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");   
		MongoDatabase database = conexion.getDatabase("harry"); 
		MongoCollection<Document> personajes = database.getCollection("harry-potter"); 
		
		
		/* Una vez realizada la conexión a la base de datos, se ejecutan laas consultas, contenidas en métodos que
		comentaremos en la clase Modelo. */
		
		m.realizarConsulta1(personajes); 
		
		m.realizarConsulta2(personajes); 
		
		m.realizarConsulta3(personajes); 
		
		m.realizarConsulta4(personajes);
		
	}

	

	

	

	

}
