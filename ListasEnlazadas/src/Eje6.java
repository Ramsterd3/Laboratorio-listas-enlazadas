public class Eje6 {

    private static class Nodo {
        int dato;
        Nodo anterior;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;
    private Nodo cola;

    public Eje6() {
        cabeza = null;
        cola = null;
    }

    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }

    public void imprimirHaciaAtras() {
        if (cola == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = cola;
        System.out.print("Elementos en orden inverso: ");

        while (actual != null) {
            System.out.print(actual.dato);
            actual = actual.anterior;
            if (actual != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public void imprimirHaciaAdelante() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = cabeza;
        System.out.print("Elementos en orden normal: ");

        while (actual != null) {
            System.out.print(actual.dato);
            actual = actual.siguiente;
            if (actual != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Eje6 lista = new Eje6();

        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(15);
        lista.agregar(20);

        lista.imprimirHaciaAdelante();
        lista.imprimirHaciaAtras();

        Eje6 listaVacia = new Eje6();
        listaVacia.imprimirHaciaAtras();
    }
}