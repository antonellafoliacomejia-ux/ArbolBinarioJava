import java.util.Scanner;

class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        izquierdo = derecho = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar un nuevo nodo
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }
        if (dato < raiz.dato)
            raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
        else if (dato > raiz.dato)
            raiz.derecho = insertarRec(raiz.derecho, dato);
        return raiz;
    }

    // Mostrar recorrido inorden
    public void mostrarInorden() {
        System.out.print("Recorrido inorden: ");
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.dato + " ");
            inordenRec(raiz.derecho);
        }
    }

    // Buscar un valor
    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo raiz, int dato) {
        if (raiz == null)
            return false;
        if (raiz.dato == dato)
            return true;
        if (dato < raiz.dato)
            return buscarRec(raiz.izquierdo, dato);
        else
            return buscarRec(raiz.derecho, dato);
    }
}

public class ArbolBinarioApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion, numero;

        do {
            System.out.println("\n===== MENÚ ÁRBOL BINARIO =====");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar recorrido inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número: ");
                    numero = sc.nextInt();
                    arbol.insertar(numero);
                    System.out.println("Número insertado correctamente.");
                    break;
                case 2:
                    arbol.mostrarInorden();
                    break;
                case 3:
                    System.out.print("Ingrese número a buscar: ");
                    numero = sc.nextInt();
                    if (arbol.buscar(numero))
                        System.out.println("El número " + numero + " SÍ está en el árbol.");
                    else
                        System.out.println("El número " + numero + " NO se encuentra en el árbol.");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}