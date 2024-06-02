package tp2.ejercicio3;

import tp2.ejercicio1.BinaryTree;

public class mainTres {
	public static void main(String[]args) {
		   BinaryTree<Integer> arbolsito = new  BinaryTree<Integer>(4);
		   BinaryTree<Integer> hi = new  BinaryTree<Integer>(8);
		   BinaryTree<Integer> hd = new  BinaryTree<Integer>(19);
		   BinaryTree<Integer> nodo4 = new  BinaryTree<Integer>(19);
		   BinaryTree<Integer> nodo5 = new  BinaryTree<Integer>(20);
		   arbolsito.addLeftChild(hi);
		   arbolsito.addRightChild(hd);
		   hd.addLeftChild(nodo4);
		   hd.addRightChild(nodo5);
		   System.out.println(arbolsito);
		   ContadorArbol cont;
		   cont = new ContadorArbol(arbolsito);
		   System.out.println(cont.numerosPares_InOrden());
		   System.out.println(cont.numerosPares_PostOrden());
		   

}}

