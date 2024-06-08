package tp3.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio9.Queue;

public class GeneralTree <T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	public int altura() {
		int alt = 0;
		if(!this.isEmpty()) {
		 alt = altura(0,this);}
		return alt;
	}
	private int altura(int nivel,GeneralTree<T> a) {
		int max = 0;
		if(a.hasChildren()) {
			List<GeneralTree<T>> children = a.getChildren();
			for(GeneralTree<T> child:children) {
				max = Math.max(altura(nivel+1,child),max); // Me quedo con el maximo entre lo que retorne mi modulo y el max
			}
		
		}
		if(this.isLeaf()) {
			return nivel;
		}
		 return Math.max(nivel, max); // Retorno el maximo entre el nivel y el max
		
	}
	public int nivel(T dato) {
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			cola.enqueue(this);
			cola.enqueue(null);
			int niv = 0; 
			boolean ok = false; // Creo un boolean para cortar las iteraciones si encuentro el valor
			while(!cola.isEmpty() && !ok) {
				GeneralTree<T> aux = cola.dequeue();
				if(aux != null) {
					if(aux.getData() == dato) { // Encolo los hijos solo si no lo encontre
						ok = true;
					}
					else {
						List<GeneralTree<T>> children = aux.getChildren();
						for(GeneralTree<T> child:children) {
							cola.enqueue(child);
						}
					}
				}
				else { // Si llego aca seguramente sea porque cambie de nivel
					if(!cola.isEmpty()) {
						niv++;
						cola.enqueue(null);
					}
				}
			}
		
		
		return niv;
		
	}
	public int ancho() {
		// Este metodo devuelve el ancho del arbol 
		//Voy a utilizar un recorrido por niveles, me parece que en profundidad no tiene sentido en este caso
		int max = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int cant = 0;
		while(!cola.isEmpty()) {
			GeneralTree<T> aux = cola.dequeue();
			if(aux != null) {
				List<GeneralTree<T>> children = aux.getChildren();
				for(GeneralTree<T> child:children) {
					cola.enqueue(child);
					cant++;
			}}
			else {
				if(!cola.isEmpty()) {
					max = Math.max(max, cant);
					cant = 0;
					cola.enqueue(null);
					
				}
		}
		}
		return max;
	}
	
	public boolean  esAncestro(T a, T b) {
		GeneralTree<T> origen = new GeneralTree<T>();
		origen = buscarNodo(a,this);
		boolean ok = true;
		GeneralTree<T> destino = new GeneralTree<T>();
		if(origen != null) {
			destino = buscarNodo(b,origen);}
		if(destino == null) {
			ok= false;
		}
		return ok;
		}
	
	
	private GeneralTree<T> buscarNodo(T a,GeneralTree<T> ar){
		GeneralTree<T> aux = null;
		if(ar.getData() == a) {
			return ar;
		}
		else {
			boolean ok = false;
			Iterator<GeneralTree<T>> it = ar.getChildren().iterator();
			while(it.hasNext() && !ok) {
				GeneralTree<T> child = it.next();
				aux = buscarNodo(a,child);
				if(aux != null && aux.getData() == a) {
					ok = true;
			}
	}
		}
	return aux;
}
}
