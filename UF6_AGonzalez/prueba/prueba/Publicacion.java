package prueba;

public class Publicacion {
	String titulo;
	String autor;
	int paginas;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public Publicacion(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}
	public Publicacion() {
		super();
	}
	@Override
	public String toString() {
		return "Publicacion [titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
	}
	
	
}
