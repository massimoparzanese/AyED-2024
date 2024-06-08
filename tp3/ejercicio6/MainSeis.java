package tp3.ejercicio6;

import tp3.ejercicio1.GeneralTree;

public class MainSeis {
	public static void main(String[]args) {
		GeneralTree<Character> a = new GeneralTree<Character>('A');
		GeneralTree<Character> n1 = new GeneralTree<Character>('X');
		GeneralTree<Character> n2= new GeneralTree<Character>('Z');
		GeneralTree<Character> n4 = new GeneralTree<Character>('H');
		GeneralTree<Character> n5 = new GeneralTree<Character>('K');
		GeneralTree<Character> n6 = new GeneralTree<Character>('T');
		GeneralTree<Character> n7 = new GeneralTree<Character>('L');
		GeneralTree<Character> n8 = new GeneralTree<Character>('Ñ');
        a.addChild(n1); a.addChild(n2); 
        n1.addChild(n4); n1.addChild(n5); n2.addChild(n6);
        n4.addChild(n7); n4.addChild(n8);
        RedDeAguaPotable re = new RedDeAguaPotable(a);
        System.out.println(re.minimoCaudal(1000));
		
	}

}
