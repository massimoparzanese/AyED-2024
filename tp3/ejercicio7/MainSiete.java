package tp3.ejercicio7;

import tp3.ejercicio1.GeneralTree;

public class MainSiete {
	public static void main(String[]args) {
		GeneralTree<Integer> a = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(7);
		GeneralTree<Integer> n2= new GeneralTree<Integer>(8);
		GeneralTree<Integer> n4 = new GeneralTree<Integer>(77);
		GeneralTree<Integer> n5 = new GeneralTree<Integer>(9);
		GeneralTree<Integer> n6 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n7 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> n9 = new GeneralTree<Integer>(14);
		GeneralTree<Integer> n8 = new GeneralTree<Integer>(13);
        a.addChild(n1); a.addChild(n2); 
        n1.addChild(n4); n1.addChild(n5); n2.addChild(n6);n6.addChild(n8);n8.addChild(n9);
        n4.addChild(n7);
        Caminos caminito = new Caminos(a);
        System.out.println(caminito.caminoAHojaMasLejana());
	}
}
