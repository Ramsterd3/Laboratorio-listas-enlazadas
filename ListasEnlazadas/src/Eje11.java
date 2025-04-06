// Eje11.java - Representación de polinomios con listas enlazadas
import java.util.Scanner;

public class Eje11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polinomio polinomio = new Polinomio();

        System.out.println("Ingrese los términos del polinomio (coeficiente exponente):");
        System.out.println("Ejemplo: para 3x^4 -4x^2 +11, ingrese:");
        System.out.println("3 4");
        System.out.println("-4 2");
        System.out.println("11 0");
        System.out.println("Termine con 'fin'");

        while (true) {

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fin")) break;

            String[] partes = input.split(" ");
            if (partes.length != 2) {
                System.out.println("Formato incorrecto. Use 'coeficiente exponente'");
                continue;
            }

            try {
                double coeficiente = Double.parseDouble(partes[0]);
                int exponente = Integer.parseInt(partes[1]);
                polinomio.agregarTermino(coeficiente, exponente);
            } catch (NumberFormatException e) {
                System.out.println("Valores numéricos inválidos");
            }
        }

        System.out.println("\nTabla de valores del polinomio:");
        System.out.println("x\t\tP(x)");
        System.out.println("---------------------");

        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double valor = polinomio.evaluar(x);
            System.out.printf("%.1f\t\t%.4f\n", x, valor);
        }

        scanner.close();
    }

    private static class NodoPolinomio {
        double coeficiente;
        int exponente;
        NodoPolinomio siguiente;

        public NodoPolinomio(double coef, int exp) {
            this.coeficiente = coef;
            this.exponente = exp;
            this.siguiente = null;
        }
    }


    private static class Polinomio {
        private NodoPolinomio cabeza;

        public Polinomio() {
            cabeza = null;
        }


        public void agregarTermino(double coeficiente, int exponente) {
            NodoPolinomio nuevoNodo = new NodoPolinomio(coeficiente, exponente);

            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                NodoPolinomio actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }

        public double evaluar(double x) {
            double resultado = 0.0;
            NodoPolinomio actual = cabeza;

            while (actual != null) {
                resultado += actual.coeficiente * Math.pow(x, actual.exponente);
                actual = actual.siguiente;
            }

            return resultado;
        }

        public void mostrar() {
            NodoPolinomio actual = cabeza;
            boolean primerTermino = true;

            while (actual != null) {
                if (primerTermino) {
                    System.out.print(formatearTermino(actual, true));
                    primerTermino = false;
                } else {
                    System.out.print(" " + formatearTermino(actual, false));
                }
                actual = actual.siguiente;
            }
            System.out.println();
        }

        private String formatearTermino(NodoPolinomio termino, boolean esPrimero) {
            StringBuilder sb = new StringBuilder();

            if (termino.coeficiente >= 0 && !esPrimero) {
                sb.append("+ ");
            } else if (termino.coeficiente < 0) {
                sb.append("- ");
            }


            double coefAbs = Math.abs(termino.coeficiente);


            if (coefAbs != 1.0 || termino.exponente == 0) {
                sb.append(coefAbs);
            }

            if (termino.exponente > 0) {
                sb.append("x");
                if (termino.exponente > 1) {
                    sb.append("^").append(termino.exponente);
                }
            }

            return sb.toString();
        }
    }
}