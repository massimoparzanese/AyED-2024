package tp5.ejercicio5;

public class Persona {
	
	private String tipo;
	private String domicilio;
	private String nombre;
	
	public Persona(String tip, String domi, String nom) {
		this.tipo = tip;
		this.domicilio = domi;
		this.nombre = nom;
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return (this.nombre.equals(other.getNombre()) && this.tipo.equals(other.getTipo()) 
				&& this.domicilio.equals(other.getDomicilio()));
	} 
	
	
}
