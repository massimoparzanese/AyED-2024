package tp1.ejercicio3;

public class Test {
  public static void main(String[] args) {
	  Estudiante est = new Estudiante("Massimo","Parzanese","1A","Massi@gmail.com","Calle 12");
	  Estudiante [] vector = new Estudiante [2];
	  vector[0] = est;
	  Estudiante est2 = new Estudiante("Santiago","Montoya Diodati","1A","Santi@gmail.com","CityBell");
	  vector[1] = est2;
	  Profesor [] vector_profe = new Profesor [3];
	  Profesor profe = new Profesor("Pedro","Magliano","1A","Matematica 1","Informatica");
	  Profesor profe2 = new Profesor("Robertino","Elgod","4","Organizacion de computadoras","Informatica");
	  Profesor profe3 = new Profesor("Joaquin","Tommassi","4","CADP","Informatica");
	  vector_profe[0] = profe;
	  vector_profe[1] = profe2;
	  vector_profe[2] = profe3;
	  for(int i=0;i<vector.length;i++) {
		  System.out.print(vector[i].tusDatos());
		  System.out.print("\n");
	  }
	  for(int i=0;i<vector_profe.length;i++){
		  System.out.print(vector_profe[i].tusDatos());
		  System.out.print("\n");
	  }
	  
	  
  }
}
