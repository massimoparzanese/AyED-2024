package tp2.ejercicio3;
import tp2.ejercicio1.BinaryTree;
import java.util.*;
public class ContadorArbol {
  private  BinaryTree <Integer> arbol;
  public ContadorArbol(BinaryTree <Integer> ar) {
	  this.arbol = ar;
  }
  
  public LinkedList<Integer> numerosPares_InOrden() {
	  if(this.arbol != null) {
		  LinkedList<Integer> lista = new LinkedList<Integer>();
		  numerosPares_InOrden(this.arbol,lista);
		  return lista;
	  }
	  else {return null;}
  }
  private void numerosPares_InOrden(BinaryTree <Integer> ar,LinkedList<Integer> l) {
	  if(ar.hasLeftChild()) {
		  numerosPares_InOrden(ar.getLeftChild(),l);
	  }
	  if(ar.getData() % 2 == 0) {
		  l.add(ar.getData());
	  }
	  if(ar.hasRightChild()) {
		  numerosPares_InOrden(ar.getRightChild(),l);
	  }
	  
  }
  public LinkedList<Integer> numerosPares_PostOrden() {
	  if(this.arbol != null) {
		  LinkedList<Integer> lista = new LinkedList<Integer>();
		  numerosPares_PostOrden(this.arbol,lista);
		  return lista;
	  }
	  else {return null;}
  }
  private void numerosPares_PostOrden(BinaryTree <Integer> ar,LinkedList<Integer> l) {
	  if(ar.hasLeftChild()) {
		  numerosPares_InOrden(ar.getLeftChild(),l);
	  }
	  if(ar.hasRightChild()) {
		  numerosPares_InOrden(ar.getRightChild(),l);
	  }
	  if(ar.getData() % 2 == 0) {
		  l.add(ar.getData());
	  }
	  
  }
}

