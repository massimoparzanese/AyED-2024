package tp1.ejercicio3;

public class Profesor {
	private String Nombre;
	private String Apellido;
	private String comision;
	private String catedra;
	private String facultad;
	
	public Profesor(String nom,String ape, String comi, String cate,String facu) {
		this.Nombre = nom;
		this.Apellido = ape;
		this.comision = comi;
		this.catedra = cate;
		this.facultad = facu;
		
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String tusDatos() {
		String aux = "";
		aux = aux + " Su nombre es "+ getNombre() + " "+ getApellido() + " su comision es " + getComision() + " , su catedra"
				+ " es " + getCatedra() + " en la facultad de " + getFacultad();
		return aux;
	}
	
}
