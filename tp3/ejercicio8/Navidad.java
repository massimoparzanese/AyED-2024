package tp3.ejercicio8;

import java.util.Iterator;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Navidad {
	private GeneralTree<Integer> abeto;
	
	public Navidad( GeneralTree<Integer> a) {
		this.abeto = a;
	}
	 public String esAbetoNavidenio() {
		 String texto = "Yes";
		 if(!this.abeto.isEmpty()) {
			 if(!esAbetoNavidenio(this.abeto)) {
				 texto = "No";
			 }
		 }
		 else {
			 texto = "No";
		 }
		 
		 return texto;
	 }
	 private boolean esAbetoNavidenio(GeneralTree<Integer> arb) {
		 boolean ok = true;
		 int hojas = 0;
		 if(!arb.isLeaf()) {
		 List<GeneralTree<Integer>> children = arb.getChildren();
		 Iterator<GeneralTree<Integer>> it = children.iterator();
		 while(it.hasNext() && ok) {
			 GeneralTree<Integer> child = it.next();
			 if(child.isLeaf()) {
				 hojas++;
			 }
			 else {
				ok = esAbetoNavidenio(child);
				
			 }}
		if(hojas < 3) {
			ok=false;}
		else {ok = true;}
		 

		 }
		
		 return ok;
		 }
}
