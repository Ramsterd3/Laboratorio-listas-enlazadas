// Eje10.java - Implementación completa en un solo archivo
public class Eje10 {
    public static void main(String[] args) {
        ListaSimple<Integer> lista1 = new ListaSimple<>();
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(2);
        lista1.insertarAlFinal(3);

        ListaSimple<Integer> lista2 = new ListaSimple<>();
        lista2.insertarAlFinal(4);
        lista2.insertarAlFinal(5);
        lista2.insertarAlFinal(6);


        ListaSimple<Integer> listaConcatenada = ListaSimple.concatenar(lista1, lista2);

        System.out.println("Lista 1:");
        lista1.mostrar();

        System.out.println("\nLista 2:");
        lista2.mostrar();

        System.out.println("\nLista concatenada:");
        listaConcatenada.mostrar();
    }


    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }


    public static class ListaSimple<T> {
        private Nodo<T> cabeza;
        private Nodo<T> cola;
        private int tamaño;

        public ListaSimple() {
            cabeza = null;
            cola = null;
            tamaño = 0;
        }

        public void insertarAlFinal(T dato) {
            Nodo<T> nuevoNodo = new Nodo<>(dato);

            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
            } else {
                cola.siguiente = nuevoNodo;
                cola = nuevoNodo;
            }
            tamaño++;
        }


        public static <T> ListaSimple<T> concatenar(ListaSimple<T> lista1, ListaSimple<T> lista2) {
            ListaSimple<T> nuevaLista = new ListaSimple<>();

            // Copiar elementos de la primera lista
            Nodo<T> actual = lista1.cabeza;
            while (actual != null) {
                nuevaLista.insertarAlFinal(actual.dato);
                actual = actual.siguiente;
            }

            actual = lista2.cabeza;
            while (actual != null) {
                nuevaLista.insertarAlFinal(actual.dato);
                actual = actual.siguiente;
            }

            return nuevaLista;
        }

        public void mostrar() {
            Nodo<T> actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }

        public int getTamaño() {
            return tamaño;
        }
    }
}