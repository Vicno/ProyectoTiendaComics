package comic.entity;

public class Comic {

	private String titulo;
	private String fechaPublicacion;
	private String descripcion;
	private int codComic;
	private int numComic;
	private double precio;
	private String editorial;
	private int codGuionista;
	private int codDibujante;
	public Comic(String titulo, String fechaPublicacion, String descripcion, int codComic, int numComic, double precio,
			String editorial, int codGuionista, int codDibujante) {
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
		this.descripcion = descripcion;
		this.codComic = codComic;
		this.numComic = numComic;
		this.precio = precio;
		this.editorial = editorial;
		this.codGuionista = codGuionista;
		this.codDibujante = codDibujante;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodComic() {
		return codComic;
	}
	public void setCodComic(int codComic) {
		this.codComic = codComic;
	}
	public int getNumComic() {
		return numComic;
	}
	public void setNumComic(int numComic) {
		this.numComic = numComic;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getCodGuionista() {
		return codGuionista;
	}
	public void setCodGuionista(int codGuionista) {
		this.codGuionista = codGuionista;
	}
	public int getCodDibujante() {
		return codDibujante;
	}
	public void setCodDibujante(int codDibujante) {
		this.codDibujante = codDibujante;
	}
	
	
	@Override
	public String toString() {
		return "Comic [titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", descripcion=" + descripcion
				+ ", codComic=" + codComic + ", numComic=" + numComic + ", precio=" + precio + ", editorial="
				+ editorial + ", codGuionista=" + codGuionista + ", codDibujante=" + codDibujante + "]";
	}
	
	
	
	
	
	
	
	

	
}
