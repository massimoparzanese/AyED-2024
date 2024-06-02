package tp1.ejercicio2;

import java.util.Scanner;

public class Mainejer2 {
  public static void main (String[] args) {
	  System.out.print("Ingrese un valor mayor a 1 \n");
	  Scanner s = new Scanner(System.in);
	  int n = s.nextInt();
	  s.close();
	  int [] vector = Manejo.nuevoArreglo(n);
	  for(int i=0;i<n;i++) {
		  System.out.print("\n");
		  System.out.print(vector[i]);
	  }
	 
  }
}
