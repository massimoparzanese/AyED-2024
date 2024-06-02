package tp1.ejercicio2;

public class Manejo {
  public static int [] nuevoArreglo(int n) {
	  int [] vector = new int [n];
	  for(int i=1;i <= n;i++) {
		  vector[i-1] = n*i; 
	  }

	  return vector;
  }
}
