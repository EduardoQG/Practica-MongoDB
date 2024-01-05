package es.studium.practicaT4;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class Modelo {

	/* Se comentarán aquí todos los métodos, ya que todos tienen la misma estructura; simplemente
	 * varía la consulta ejecutada.
	 * 
	 * Esta estructura consiste en:
	 * 1. Recibir por parámetros la colección Mongo donde se va a buscar, esta colección se pasa
	 * desde la clase Test, donde se invocan los métodos.
	 * 
	 * 2. Crear un FindIterable, que es una especie de lista, donde se listan todos los documentos
	 * que contienen las características detalladas en el filtro ('Filters.'), y que se encuentran
	 * dentro de la colección donde estamos buscando.
	 * 
	 * 3. Imprimir el número la consulta, para poder ordenar un poco la consola y saber en qué
	 * consulta nos hallamos.
	 * 
	 * 4. Recorrer este objeto FindIterable, imprimiendo todos los documentos que contiene en formato Json.
	 */
	
	public void realizarConsulta1(MongoCollection<Document> personajes) {
		FindIterable<Document> consulta1 = personajes.find(Filters.eq("species", "human"));  
		System.out.println("CONSULTA 1:");
		for (Object personaje : consulta1) {    
			System.out.println(((Document) personaje).toJson());   
		}
	}
	
	public void realizarConsulta2(MongoCollection<Document> personajes) {
		System.out.println("CONSULTA 2:");
		FindIterable<Document> consulta2 = personajes.find(Filters.lt("yearOfBirth", 1979));   
		for (Object personaje : consulta2) {    
			System.out.println(((Document) personaje).toJson());   
		}
	}
	
	public void realizarConsulta3(MongoCollection<Document> personajes) {
		System.out.println("CONSULTA 3:");
		FindIterable<Document> consulta3 = personajes.find(Filters.eq("wand.wood", "holly"));   
		for (Object personaje : consulta3) {    
			System.out.println(((Document) personaje).toJson());   
		}
	}
	
	public void realizarConsulta4(MongoCollection<Document> personajes) {
		System.out.println("CONSULTA 4:");
		FindIterable<Document> consulta4 = personajes.find(Filters.and(Filters.eq("alive", true), Filters.eq("hogwartsStudent", true)));
		for (Object personaje : consulta4) {    
			System.out.println(((Document) personaje).toJson());   
		}
	}
}
