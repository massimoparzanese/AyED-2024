package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public void setAr(BinaryTree<Integer> ar) {
		this.arbol = ar;
	}
	public boolean isLeftTree (int num) {
		BinaryTree<Integer> aux = new BinaryTree<Integer>();
		boolean ok = false;
		if(!arbol.isEmpty()) {
			aux = buscarRaiz(num,arbol);
		    if(aux != null) {
		    	int hd = -1;
		    	int hi = -1;
		    	if(aux.hasLeftChild()) {
		    		hi = obtenerValor(aux.getLeftChild());
		    	}
		    	if(aux.hasRightChild()) {
		    		hd = obtenerValor(aux.getRightChild());
		    	}
			   if(hi > hd) {
				   ok = true;
			   }
				   
		    }
			}
		return ok;
		}
	   
	
	private int obtenerValor(BinaryTree<Integer> ar) {
		int num = 0;
		if(ar.hasLeftChild() && !ar.hasRightChild()) {
			num+= 1;
			num += obtenerValor(ar.getLeftChild());
		}
		if(!ar.hasLeftChild() && ar.hasRightChild()) {
			num+= 1;
			num += obtenerValor(ar.getRightChild());
		}
		if(ar.hasLeftChild() && ar.hasRightChild()) {
			num+= obtenerValor(ar.getLeftChild()) + obtenerValor(ar.getRightChild());
		}
		return num;
	}
	
	private BinaryTree<Integer> buscarRaiz(int num,BinaryTree<Integer> ar){
		if(ar.getData() == num) {
			return ar;
		}
		else {
			BinaryTree<Integer> aux = new BinaryTree<Integer>();
			if(ar.hasLeftChild()) {
				aux = buscarRaiz(num,ar.getLeftChild());
			}
			if(ar.hasRightChild() && aux == null) {
				aux = buscarRaiz(num,ar.getRightChild());
				
			}
			return aux;
		}
		
	}

}
