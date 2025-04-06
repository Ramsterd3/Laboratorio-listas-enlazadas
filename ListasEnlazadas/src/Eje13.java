public class Eje13 {
    public static void main(String[] args) {

        MiLista lista = new MiLista();
        lista.insertarFinal(1);
        lista.insertarFinal(4);
        lista.insertarFinal(2);
        lista.insertarFinal(3);
        lista.insertarFinal(4);
        lista.insertarFinal(5);
        lista.insertarFinal(4);

        int claveBuscada = 4;
        int maxDistancia = lista.maximaDistancia(claveBuscada);

        System.out.println("La máxima distancia entre nodos con clave " + claveBuscada +
                " es: " + maxDistancia);
    }


    static class Nodo {
        int clave;
        Nodo siguiente;

        public Nodo(int clave) {
            this.clave = clave;
            this.siguiente = null;
        }
    }

    static class MiLista {
        private Nodo inicio;

        public MiLista() {
            inicio = null;
        }


        public void insertarFinal(int clave) {
            Nodo nuevo = new Nodo(clave);
            if (inicio == null) {
                inicio = nuevo;
            } else {
                Nodo actual = inicio;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }

        public int maximaDistancia(int x) {
            return maximaDistanciaRec(inicio, x, 0, 0, -1);
        }
        private int maximaDistanciaRec(Nodo actual, int x, int distancia,
                                       int maxActual, int ultimaPos) {
            if (actual == null) {
                return maxActual;
            }

            if (actual.clave == x) {
                if (ultimaPos != -1 && distancia > maxActual) {
                    maxActual = distancia;}
                ultimaPos = distancia;
                distancia = 0;
            }
            if (ultimaPos != -1) {
                distancia++;
            }
            return maximaDistanciaRec(actual.siguiente, x, distancia, maxActual, ultimaPos);
        }
    }
}