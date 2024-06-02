package tp1.ejercicio3;

public class Estudiante {
  private String Nombre;
  private String Apellido;
  private String comision;
  private String email;
  private String direccion;
  
  public Estudiante(String nom,String ape,String comi,String mail,String direccion){
	  this.Nombre= nom;
	  this.Apellido= ape;
	  this.comision = comi;
	  this.email = mail;
	  this.direccion = direccion;
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

  public String getEmail() {
	return email;
}

  public void setEmail(String email) {
	this.email = email;
}

  public String getDireccion() {
	return direccion;
}

  public void setDireccion(String direccion) {
	this.direccion = direccion;
}
   public String tusDatos() {
	   String aux = "";
		aux = aux + " Su nombre es "+ getNombre() + " "+ getApellido() + " su comision es " + getComision() + " , su email"
				+ " es " + getEmail() + " en la direccion " + getDireccion();
		return aux;
   }
  
  
}
