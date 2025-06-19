package controllers;

import models.Node;

public class ArbolBinario {
    public Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            int alturaNodo = getHeightRec(node);
            System.out.print(node.getValue() + "(h=" + alturaNodo + ") ");
            System.out.print(node.getValue() + " ");
            inOrderRec(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderRec(node.getLeft());
            preOrderRec(node.getRight());
        }
    }

    public void imprimir() {
        imprimir(root);
    }

    private void imprimir(Node node) {
        if (node != null) {
            imprimir(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimir(node.getRight());
        }
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        if (value < node.getValue()) {
            return buscarRec(node.getLeft(), value);
        } else {
            return buscarRec(node.getRight(), value);
        }
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getHeightRec() {
        return getHeightRec(root);
    }

    public void inOrderConBalance() {
        inOrderEquilibrado(root);
        System.out.println();
    }

    public void inOrderEquilibrado(Node node) {
        if (node != null) {
            inOrderEquilibrado(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            System.out.print(node.getValue() + "(bf= " + bf + "), ");
            inOrderEquilibrado(node.getRight());
        }
    }

    public boolean arbolEquilibrado(int value) {
        boolean equilibrado = arbolEquilibradoRec(root);
        System.out.println("Arbol esta quilibrado = " + equilibrado);
        if (equilibrado == true) {
            int nuevoValor = 15;
            insert(nuevoValor);
            System.out.println("Agregamos el nuevo valor: " + nuevoValor);
        }
        return equilibrado;
    }

    private boolean arbolEquilibradoRec(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        int balance = Math.abs(leftHeight - rightHeight);
        return (balance <= 1) &&
                arbolEquilibradoRec(node.getLeft()) &&
                arbolEquilibradoRec(node.getRight());
    }

    public int contarNodos(){
        return contarNodosRec(root);
    }

    private int contarNodosRec(Node node) {
        if (node == null) return 0;
        return 1 + contarNodosRec(node.getLeft()) + contarNodosRec(node.getRight());
    }

    public void imprimirBalanceFinal() {
        System.out.println("\nArbol InOrder con factor de equilibrio");
        inOrderEquilibrado(root);
        System.out.println();
        System.out.print("Nodos desequilibrados ");
        imprimirNodosDesequilibrados(root);
        System.out.println();
    }

    private void imprimirNodosDesequilibrados(Node node) {
        if (node != null) {
            imprimirNodosDesequilibrados(node.getLeft());
            int bf = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + ") ");
            }
            imprimirNodosDesequilibrados(node.getRight());
        }
    }
}
