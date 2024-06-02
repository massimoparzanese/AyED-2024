package tp1.ejercicio7;
import java.util.*;
import tp1.ejercicio3.Estudiante;
public class TestArrayList {
	public static LinkedList<Estudiante> generarLista(){
		LinkedList<Estudiante> lista = new LinkedList<Estudiante>();
		Estudiante est = new Estudiante("Santiago","Montoya Diodati","1A","Santi@gmail.com","CityBell");
		Estudiante est3 = new Estudiante("Pedro","Magliano","1A","Pedrinho@gmail.com","CityBell");
		Estudiante est2 = new Estudiante("Massimo","Parzanese","1A","Massi@gmail.com","Calle 12");
		lista.add(est);
		lista.add(est2);
		lista.add(est3);
	 return lista;
	}
  public static void main(String[]args) {
	  ArrayList<Integer> lista = new ArrayList<Integer>();
	  Scanner s = new Scanner(System.in);
	  System.out.print("Ingrese un numero\n");
	  int n = s.nextInt();
	  while( n != -1) {
		  lista.add(n);
		  System.out.print("Ingrese un numero \n");
		  n = s.nextInt();
	  }
	  s.close();
	  System.out.print(lista);
	  LinkedList<Estudiante> lista2 = new LinkedList<Estudiante>();
	  lista2 = generarLista();
	  LinkedList<Estudiante> lista3 = new LinkedList<Estudiante>();
	  lista3.addAll(lista2);
	  for(Estudiante est: lista2) {
		  System.out.print(est.tusDatos()+ "\n");
	  }
	  for(Estudiante est: lista3) {
		  System.out.print(est.tusDatos()+ "\n");
	  }
	 Estudiante est = lista2.get(1);
	 est.setApellido("Trolo");
	 //lista2.set(1, est);
	 for(Estudiante est2: lista2) {
		  System.out.print(est2.tusDatos()+ "\n");
	  }
   	  
  }
}
