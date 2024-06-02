package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class MainSeis {
	public static void main(String[] args) {
		BinaryTree<Integer> arbolsito = new  BinaryTree<Integer>(4);
		BinaryTree<Integer> hi = new  BinaryTree<Integer>(8);
		BinaryTree<Integer> hd = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> nodo4 = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> nodo5 = new  BinaryTree<Integer>(20);
		BinaryTree<Integer> nodo6 = new  BinaryTree<Integer>(5);
		arbolsito.addLeftChild(hi);
		arbolsito.addRightChild(hd);
		hd.addLeftChild(nodo4);
		hd.addRightChild(nodo5);
		hi.addLeftChild(nodo6);
		Transformacion t = new Transformacion();
	    t.setAr(arbolsito);
	    t.suma();
	    System.out.println(t.toString());
	}
}
