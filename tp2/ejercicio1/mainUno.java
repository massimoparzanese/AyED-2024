package tp2.ejercicio1;

public class mainUno {
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
	   System.out.println(arbolsito.contarHojas());
	   System.out.println(arbolsito.getLeftChild());
	   System.out.println(arbolsito.getRightChild());
	   System.out.println(arbolsito.espejo().getLeftChild());
	   System.out.println(arbolsito.espejo().getRightChild());
	   System.out.println(arbolsito.getRightChild().getRightChild());
	   System.out.println(arbolsito.espejo().getLeftChild().getLeftChild());
	   System.out.println(arbolsito.espejo().getLeftChild().getRightChild());
   }
}
