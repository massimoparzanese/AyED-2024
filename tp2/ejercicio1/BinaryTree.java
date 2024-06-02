package tp2.ejercicio1;

import tp1.ejercicio9.Queue;

public class BinaryTree <T> {

	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}
	public int contarHojas() {
		BinaryTree<T> aux = new BinaryTree<T>();
		aux = this;
		int i = 0;
		if(aux.isLeaf()) {
			 i++;
		}
		else {
			if(aux.hasLeftChild()) {
				  i += aux.getLeftChild().contarHojas();
			}
			if(aux.hasRightChild()) {
				 i+= aux.getRightChild().contarHojas();
			}

		}
		return i;
	}
	public BinaryTree<T> espejo(){
		BinaryTree<T> aux = new BinaryTree<T>(this.getData());
		if(this.hasRightChild()) {
		aux.addLeftChild(this.getRightChild().espejo());}
		if(this.hasLeftChild()) {
			aux.addRightChild(this.getLeftChild().espejo());
		}
		return aux;

	}
	public void entreniveles(int n,int m) {
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int i = 0;
		while(!cola.isEmpty() && i <= m ) {
			BinaryTree<T> aux = cola.dequeue();
			if(aux != null) {
				if(i <= n){
					System.out.println(aux.getData());
		         }
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.getLeftChild());
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.getRightChild());
				}
			}
			else if(!cola.isEmpty()) {
				i++;
				cola.enqueue(null);
			}

		}
	}

}
