package tp3.ejercicio4;

import java.util.List;

import tp1.ejercicio9.Queue;
import tp3.ejercicio1.GeneralTree;

public class AnalizadorArbol {
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		/**
		 Selecciono el recorrido por niveles ya que es mas adecuado para
		 * este problema, lo que hago aca es: Creo 3 variables para calcular
		 * los promedios, una para cada lvl y otra que sera la que retorne
		 * Y con una cola, voy encolando los nodos de cada nivel  y contavilizo,
		 * asi hasta terminar de recorrer el arbol y quedarme con el maximo promedio
		 */
		double prom = 0;
		double promMax = 0;
		double cant = 0;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> ar = cola.dequeue();
			if(ar != null) {
				prom+= ar.getData().getTardanza(); 
				List<GeneralTree<AreaEmpresa>> children = ar.getChildren();
				cant++;
				for(GeneralTree<AreaEmpresa> child:children) {
					cola.enqueue(child);
					
			}
		     }
			else {
				prom = prom / cant;
				promMax = Math.max(promMax,prom);//Me quedo con el mayor promedio
				prom = 0;// Reseteo mis variables para calcular el prom del sig nivel
				cant = 0;
				if(!cola.isEmpty()) {
					
					cola.enqueue(null);
				}
			}
			
		}
		return promMax;

	}
}
