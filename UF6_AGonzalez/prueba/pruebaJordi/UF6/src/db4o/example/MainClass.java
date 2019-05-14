package pruebaJordi.UF6.src.db4o.example;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class MainClass {

	public static void main(String[] args) {
		// (String titulo, String autor, int paginas,String editorial)
		/*Libro l1 = new Libro ("Harry Potter" , "JKJOSU", 510, "Dios SAbe");
		Libro l2 = new Libro ("Harry Potter2" , "JKJOSU", 580, "Dios SAbe");
		Libro l3 = new Libro ("Teo va al Zoo" , "Teo", 100, "Anaya");
		Libro l4 = new Libro ("Y todos callaron" , "Toti Martinez Lezea", 335, "Unlimited Books");
		Libro l5 = new Libro ("Cicatriz" , "Juan Gomez Jurado", 270, "Alternative Books");
		*/
		//Publicacion p1 = new Publicacion ("El arte de estudiar " , "Mozart", 20 );
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DB4OFILENAME");
		//db.store(p1);
/*		db.store(l1);
		db.store(l2);
		db.store(l3);
		db.store(l4);
		db.store(l5);*/
		// System.out.println("guardados los objetos l1 a l5");
		
/*		Publicacion p1 = new Libro("Morir no es lo que más duele", "Ines Plana", 420 , "ESPASSA");
		db.store(p1);*/
		
		// ObjectSet resultadoQuery = db.queryByExample(prototipo);
		
		ObjectSet resultadoQuery;
		
/*		resultadoQuery = db.queryByExample(Publicacion.class);
		System.out.println("mostramos las publicaciones");
		mostrarResultados(resultadoQuery);
		System.out.println("mostramos solo los libros");
		resultadoQuery = db.queryByExample(Libro.class);
		mostrarResultados(resultadoQuery);*/
		
/*		System.out.println("Utilizamos el for each");
		List<Libro> libros = db.query(Libro.class);
		for (Libro libro : libros) {
			System.out.println(libro);
		}*/
		
		resultadoQuery = db.queryByExample(new Libro ("Harry Potter",null,0,null));
		//System.out.println("Clase resulktante "+resultadoQuery.next().getClass());
		Libro encontrado;
		encontrado = (Libro) resultadoQuery.next();
		encontrado.setPaginas(620);
		db.store(encontrado);
		
		resultadoQuery = db.queryByExample(Publicacion.class);
		System.out.println("mostramos las publicaciones");
		mostrarResultados(resultadoQuery);
		
		
		resultadoQuery = db.queryByExample(new Libro ("Morir no es lo que más duele",null,0,null));
		encontrado = (Libro) resultadoQuery.next();
		db.delete(encontrado);
		
		resultadoQuery = db.queryByExample(Publicacion.class);
		System.out.println("mostramos las publicaciones");
		mostrarResultados(resultadoQuery);
		
		
		
		
	}
	
	public static void  mostrarResultados (ObjectSet OS) {
		System.out.println("Tamano = "+OS.size());
		while ( OS.hasNext()) {
			System.out.println(OS.next());
		}
		
	}
	
	
	

}
