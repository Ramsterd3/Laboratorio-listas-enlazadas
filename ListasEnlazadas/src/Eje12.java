import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Eje12 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Eje12 <archivo.txt>");
            return;
        }

        ListaNumeros lista = new ListaNumeros();

        try {
            Scanner fileScanner = new Scanner(new File(args[0]));
            while (fileScanner.hasNextDouble()) {
                lista.insertar(fileScanner.nextDouble());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + args[0]);
            return;
        }

        if (lista.getTamano() == 0) {
            System.out.println("El archivo no contiene números válidos.");
            return;
        }

        double media = lista.calcularMedia();
        double desviacion = lista.calcularDesviacionEstandar(media);

        System.out.println("Resultados:");
        System.out.println("Cantidad de números: " + lista.getTamano());
        System.out.printf("Media: %.4f\n", media);
        System.out.printf("Desviación estándar: %.4f\n", desviacion);
    }

    private static class Nodo {
        double valor;
        Nodo siguiente;

        public Nodo(double valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private static class ListaNumeros {
        private Nodo cabeza;
        private Nodo cola;
        private int tamano;

        public ListaNumeros() {
            cabeza = null;
            cola = null;
            tamano = 0;
        }

        public void insertar(double valor) {
            Nodo nuevo = new Nodo(valor);
            if (cabeza == null) {
                cabeza = nuevo;
                cola = nuevo;
            } else {
                cola.siguiente = nuevo;
                cola = nuevo;
            }
            tamano++;
        }

        public double calcularMedia() {
            if (tamano == 0) return 0;

            double suma = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                suma += actual.valor;
                actual = actual.siguiente;
            }
            return suma / tamano;
        }


        public double calcularDesviacionEstandar(double media) {
            if (tamano <= 1) return 0;

            double sumaDiferencias = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                double diferencia = actual.valor - media;
                sumaDiferencias += diferencia * diferencia;
                actual = actual.siguiente;
            }
            return Math.sqrt(sumaDiferencias / (tamano - 1));
        }

        public int getTamano() {
            return tamano;
        }
    }
}