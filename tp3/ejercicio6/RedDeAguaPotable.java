package tp3.ejercicio6;

import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	GeneralTree<Character> red;
	
	public RedDeAguaPotable(GeneralTree<Character> redNueva) {
		this.red = redNueva;
	}

	public double minimoCaudal(double caudal) {
		double min = 99999;
		if(this.red != null) {
		 min= minimoCaudal(caudal,this.red);}
		return min;
	}
	private double minimoCaudal(double caudal,GeneralTree<Character> r) {
		double min;
		if(r.isLeaf()) {
			return caudal;
		}
		else {
			min = 99999;
			List<GeneralTree<Character>> children = r.getChildren();
			for(GeneralTree<Character> child:children) {
				min = Math.min(minimoCaudal(caudal/children.size(),child),min);
			}
		}
		return min;

}
	}
