package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class MainParcial {
	public static void main(String[]args) {
		BinaryTree<Integer> arbolsito = new  BinaryTree<Integer>(4);
		BinaryTree<Integer> hi = new  BinaryTree<Integer>(8);
		BinaryTree<Integer> hd = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> nodo6 = new  BinaryTree<Integer>(5);
		arbolsito.addLeftChild(hi);
		arbolsito.addRightChild(hd);
		hi.addRightChild(nodo6);
		BinaryTree<Integer> arbolsete = new  BinaryTree<Integer>(7);
		BinaryTree<Integer> HI = new  BinaryTree<Integer>(8);
		BinaryTree<Integer> HD = new  BinaryTree<Integer>(19);
		BinaryTree<Integer> node1 = new  BinaryTree<Integer>(5);
		BinaryTree<Integer> node2 = new  BinaryTree<Integer>(5);
		arbolsete.addRightChild(HD);
		HI.addRightChild(node1);
		HI.addLeftChild(node2);
		ParcialArboles par = new ParcialArboles();
	    System.out.println(par.esPrefijo(arbolsito, arbolsete));
		
	}
}
