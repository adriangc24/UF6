package pruebaJordi.UF6.src.db4o.example;

public class Libro extends Publicacion{
	String editorial;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, String autor, int paginas,String editorial) {
		super(titulo, autor, paginas);
		// TODO Auto-generated constructor stub
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String toString() {
		return "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas ;	}



}
