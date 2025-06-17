import controllers.ArbolBinario;

public class App {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insert(50);
        arbol.insert(17);
        arbol.insert(76);
        arbol.insert(9);
        arbol.insert(23);
        arbol.insert(54);
        arbol.insert(14);
        arbol.insert(19);

        System.out.println("inOrder:");
        arbol.inOrderTraversal();

        System.out.println("preOrder:");
        arbol.preOrderTraversal();

        System.out.println("imprimir (inOrder con salto de línea):");
        arbol.imprimir();

        int valorBuscado = 23;
        System.out.println("¿Está el valor " + valorBuscado + "? " + (arbol.buscar(valorBuscado) ? "Sí" : "No"));

        valorBuscado = 100;
        System.out.println("¿Está el valor " + valorBuscado + "? " + (arbol.buscar(valorBuscado) ? "Sí" : "No"));
    }
}