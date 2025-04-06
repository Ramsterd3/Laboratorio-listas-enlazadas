
public class Eje7 {
    public static void main(String[] args) {

        MiListaDoblementeEnlazada<String> lista = new MiListaDoblementeEnlazada<>();
        lista.agregarAlFinal("uno");
        lista.agregarAlFinal("dos");
        lista.agregarAlFinal("tres");

        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    private static class Nodo<T> {
        T dato;
        Nodo<T> anterior;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    public static class MiListaDoblementeEnlazada<T> implements java.lang.Iterable<T> {
        private Nodo<T> cabeza;
        private Nodo<T> cola;
        private int tamaño;

        public MiListaDoblementeEnlazada() {
            cabeza = null;
            cola = null;
            tamaño = 0;
        }

        public void agregarAlFinal(T dato) {
            Nodo<T> nuevoNodo = new Nodo<>(dato);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
            } else {
                nuevoNodo.anterior = cola;
                cola.siguiente = nuevoNodo;
                cola = nuevoNodo;
            }
            tamaño++;
        }

        public int getTamaño() {
            return tamaño;
        }

        @Override
        public java.util.Iterator<T> iterator() {
            return new MiIterador<>(cabeza);
        }

        private static class MiIterador<T> implements java.util.Iterator<T> {
            private Nodo<T> actual;

            public MiIterador(Nodo<T> cabeza) {
                this.actual = cabeza;
            }

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        }
    }
}