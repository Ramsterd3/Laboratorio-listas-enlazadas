// Eje9.java - Implementación completa de lista circular en un solo archivo
public class Eje9 {
    public static void main(String[] args) {
        ListaCircular<String> lista = new ListaCircular<>();

        lista.insertar("A");
        lista.insertar("B");
        lista.insertar("C");
        lista.insertar("D");

        System.out.println("Buscar 'B': " + lista.buscar("B"));  // true
        System.out.println("Buscar 'X': " + lista.buscar("X"));  // false

        lista.mostrar();
    }

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public static class ListaCircular<T> {
        private Nodo<T> ultimo;
        private int tamaño;

        public ListaCircular() {
            ultimo = null;
            tamaño = 0;
        }

        public void insertar(T dato) {
            Nodo<T> nuevoNodo = new Nodo<>(dato);

            if (ultimo == null) {
                // Lista vacía
                nuevoNodo.siguiente = nuevoNodo;  // Se apunta a sí mismo
                ultimo = nuevoNodo;
            } else {

                nuevoNodo.siguiente = ultimo.siguiente;
                ultimo.siguiente = nuevoNodo;
                ultimo = nuevoNodo;
            }
            tamaño++;
        }

        public boolean buscar(T dato) {
            if (ultimo == null) return false;

            Nodo<T> actual = ultimo.siguiente;
            Nodo<T> inicio = actual;

            do {
                if (actual.dato.equals(dato)) {
                    return true;
                }
                actual = actual.siguiente;
            } while (actual != inicio);

            return false;
        }

        public void mostrar() {
            if (ultimo == null) {
                System.out.println("Lista vacía");
                return;
            }

            Nodo<T> actual = ultimo.siguiente;
            Nodo<T> inicio = actual;

            do {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            } while (actual != inicio);

            System.out.println("(vuelta al inicio)");
        }

        public int getTamaño() {
            return tamaño;
        }
    }
}