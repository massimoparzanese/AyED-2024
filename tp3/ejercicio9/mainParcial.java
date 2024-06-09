package tp3.ejercicio9;

import tp3.ejercicio1.GeneralTree;

public class mainParcial {
	public static void main(String[]args) {
		GeneralTree<Integer> a = new GeneralTree<Integer>(4);
		GeneralTree<Integer> n1 = new GeneralTree<Integer>(7);
		GeneralTree<Integer> n2= new GeneralTree<Integer>(8);
		GeneralTree<Integer> n4 = new GeneralTree<Integer>(77);
		GeneralTree<Integer> n5 = new GeneralTree<Integer>(9);
		GeneralTree<Integer> n6 = new GeneralTree<Integer>(8);
		GeneralTree<Integer> n7 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> n9 = new GeneralTree<Integer>(14);
		GeneralTree<Integer> n8 = new GeneralTree<Integer>(13);
		GeneralTree<Integer> n10 = new GeneralTree<Integer>(99);
		GeneralTree<Integer> n11 = new GeneralTree<Integer>(98);
        a.addChild(n1); a.addChild(n2); a.addChild(n9);
        n1.addChild(n4); n1.addChild(n5);n1.addChild(n6);
        a.addChild(n8); n2.addChild(n7);
        n4.addChild(n10);
        n10.addChild(n11);
		System.out.println(ParcialArboles.esDeSeleccion(a));
	}
}
