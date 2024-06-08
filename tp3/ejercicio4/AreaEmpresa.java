package tp3.ejercicio4;

public class AreaEmpresa {
	private String ident;
	private int tardanza;
	
	public AreaEmpresa(String iden,int tard) {
		this.ident = iden;
		this.tardanza = tard;
		
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public int getTardanza() {
		return tardanza;
	}
	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
	
	

}
