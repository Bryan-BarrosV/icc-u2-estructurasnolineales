import controllers.ArbolBinario;

public class App {
    public static void main(String[] args) {

        System.out.println("Bryan Barros");
        ArbolBinario arbol = new ArbolBinario();
        arbol.insert(50);
        arbol.insert(17);
        arbol.insert(76);
        arbol.insert(9);
        arbol.insert(23);
        arbol.insert(54);
        arbol.insert(14);
        arbol.insert(19);

        System.out.println("Peso del arbol = " + arbol.contarNodos());
        System.out.println("Altura es = " + arbol.getHeightRec());

        System.out.println("\nArbol InOrder");
        arbol.imprimir();

        System.out.println("\n\nArbol InOrder con alturas");
        arbol.inOrderTraversal();

        System.out.println("\nArbol InOrder con factor de equilibrio");
        arbol.inOrderConBalance();

        boolean estaEquilibrado = arbol.arbolEquilibrado(0);

        System.out.println();

        System.out.println("preOrder:");
        arbol.preOrderTraversal();

        System.out.println("inOrder con salto de línea):");
        arbol.imprimir();

        int valorBuscado = 23;
        System.out.println("¿Está el valor " + valorBuscado + "? " + (arbol.buscar(valorBuscado) ? "Sí" : "No"));

        valorBuscado = 100;
        System.out.println("¿Está el valor " + valorBuscado + "? " + (arbol.buscar(valorBuscado) ? "Sí" : "No"));

        arbol.imprimirBalanceFinal();
    }
}
