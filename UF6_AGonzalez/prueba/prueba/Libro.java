package prueba;

public class Libro extends Publicacion{
	String editorial;

	public Libro() {
		super();
	}

	public Libro(String titulo, String autor, int paginas, String editorial) {
		super(titulo, autor, paginas);
		this.editorial = editorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [editorial=" + editorial + ", titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas
				+ "]";
	}

	

	
	
	
}
