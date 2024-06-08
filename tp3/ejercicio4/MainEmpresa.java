package tp3.ejercicio4;

import tp3.ejercicio1.GeneralTree;

public class MainEmpresa {
	public static void main(String[]args) {
		AreaEmpresa ar = new AreaEmpresa("M",20);
		GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(ar);
		AreaEmpresa ar1 = new AreaEmpresa("A", 15);
        AreaEmpresa ar2 = new AreaEmpresa("B", 30);
        AreaEmpresa ar3 = new AreaEmpresa("C", 25);
        AreaEmpresa ar4 = new AreaEmpresa("D", 100);
        AreaEmpresa ar5 = new AreaEmpresa("E", 10);
        AreaEmpresa ar6 = new AreaEmpresa("F", 40);
        AreaEmpresa ar7 = new AreaEmpresa("G", 50);
        GeneralTree<AreaEmpresa> node1 = new GeneralTree<>(ar1);
        GeneralTree<AreaEmpresa> node2 = new GeneralTree<>(ar2);
        GeneralTree<AreaEmpresa> node3 = new GeneralTree<>(ar3);
        GeneralTree<AreaEmpresa> node4 = new GeneralTree<>(ar4);
        GeneralTree<AreaEmpresa> node5 = new GeneralTree<>(ar5);
        GeneralTree<AreaEmpresa> node6 = new GeneralTree<>(ar6);
        GeneralTree<AreaEmpresa> node7 = new GeneralTree<>(ar7);

        // Añadir nodos como hijos en el árbol
        a.addChild(node1);
        a.addChild(node2);
        a.addChild(node3);
        node1.addChild(node4);
        node1.addChild(node5);
        node2.addChild(node6);
        node3.addChild(node7);
        AnalizadorArbol anali = new AnalizadorArbol();
        System.out.println(anali.devolverMaximoPromedio(a));
		
	}


}
