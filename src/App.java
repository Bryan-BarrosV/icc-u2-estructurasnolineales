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

    }
}