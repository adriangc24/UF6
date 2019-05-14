package prueba;

import java.util.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.*;

public class Main {

	public static void main(String[] args) {
		
		//					TITULO		AUTOR		PAGINAS		EDITORIAL
		
		/*
		
		Libro l1 = new Libro("Harry Potter","JKJOSU",510,"dios sabe");
		Libro l2 = new Libro("Teo va al zoo","Teo",20,"Amaya");
		Libro l3 = new Libro("Y todos callaron","Toti Martinez Lea",335,"locolibro");
		Libro l4 = new Libro("Cicatriz","Juan Gomez Jurado",270,"Alternative books");

		*/
		
		//publicacion p1 = new publicacion("el arte de estudiar","mozart");
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Db4ofilename");
		
		
		//ObjectSet resultado = db.queryByExample(Libro.class);

		/*db.store(l1);
		db.store(l2);
		db.store(l3);
		db.store(l4);*/
		
		//System.out.println("guardados los objetos l1 a l5");
		
		Libro prototipo = new Libro(null,null,0,null);
		
		ObjectSet resultado = db.queryByExample(prototipo);
		
		System.out.println(resultado.size());
		
		while(resultado.hasNext()) {
			System.out.println(resultado.next());
		}
		
		List<Libro> libros = db.query(Libro.class);
		

	}

}
