package pruebaJordi.UF6.src.db4o.example;

public class Publicacion {
	String titulo;
	String autor;
	int paginas;
	public Publicacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publicacion(String titulo, String autor, int paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}
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
	@Override
	public String toString() {
		return "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas ;
	}
	
	

}
