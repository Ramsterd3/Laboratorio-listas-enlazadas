import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

public class Eje8 {
    public static void main(String[] args) {
        MiListaDoblePersonas lista = new MiListaDoblePersonas();
        lista.agregarPersona("Juan", "123456");    // 6 dígitos (par)
        lista.agregarPersona("María", "7890");     // 4 dígitos (par)
        lista.agregarPersona("Pedro", "12345");    // 5 dígitos (impar)
        lista.agregarPersona("Ana", "12345678");   // 8 dígitos (par)
        lista.agregarPersona("Luis", "1");         // 1 dígito (impar)

        List<Persona> personasConCedulaPar = lista.obtenerPersonasCedulaPar();


        for (Persona p : personasConCedulaPar) {
            System.out.println(p);
        }
    }

    static class Persona {
        private String nombre;
        private String cedula;

        public Persona(String nombre, String cedula) {
            this.nombre = nombre;
            this.cedula = cedula;
        }

        public boolean tieneCedulaPar() {
            return cedula.length() % 2 == 0;
        }

        @Override
        public String toString() {
            return nombre + " - Cédula: " + cedula + " (" + cedula.length() + " dígitos)";
        }
    }

    static class Nodo {
        Persona persona;
        Nodo anterior;
        Nodo siguiente;

        public Nodo(Persona persona) {
            this.persona = persona;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    static class MiListaDoblePersonas implements Iterable<Persona> {
        private Nodo cabeza;
        private Nodo cola;
        private int tamaño;

        public MiListaDoblePersonas() {
            cabeza = null;
            cola = null;
            tamaño = 0;
        }

        public void agregarPersona(String nombre, String cedula) {
            Persona nuevaPersona = new Persona(nombre, cedula);
            Nodo nuevoNodo = new Nodo(nuevaPersona);

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

        public List<Persona> obtenerPersonasCedulaPar() {
            List<Persona> resultado = new ArrayList<>();
            for (Persona p : this) {
                if (p.tieneCedulaPar()) {
                    resultado.add(p);
                }
            }
            return resultado;
        }

        @Override
        public java.util.Iterator<Persona> iterator() {
            return new IteradorPersonas(cabeza);
        }

        private static class IteradorPersonas implements java.util.Iterator<Persona> {
            private Nodo actual;

            public IteradorPersonas(Nodo cabeza) {
                this.actual = cabeza;
            }

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public Persona next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Persona persona = actual.persona;
                actual = actual.siguiente;
                return persona;
            }
        }
    }
}
