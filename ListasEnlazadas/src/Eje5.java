public class Eje5 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public static int contarRepeticiones(Node head, int valorBuscado) {
        int contador = 0;
        Node current = head;

        while (current != null) {
            if (current.value == valorBuscado) {
                contador++;
            }
            current = current.next;
        }

        return contador;
    }


    public static void imprimirLista(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Node lista = new Node(5);
        lista.next = new Node(2);
        lista.next.next = new Node(5);
        lista.next.next.next = new Node(8);
        lista.next.next.next.next = new Node(5);
        lista.next.next.next.next.next = new Node(1);
        lista.next.next.next.next.next.next = new Node(5);
        lista.next.next.next.next.next.next.next = new Node(3);

        imprimirLista(lista);

        int valorABuscar = 5;
        int repeticiones = contarRepeticiones(lista, valorABuscar);
        valorABuscar = 2;
        repeticiones = contarRepeticiones(lista, valorABuscar);
        valorABuscar = 10;
        repeticiones = contarRepeticiones(lista, valorABuscar);

        System.out.println("El valor " + valorABuscar + " aparece " + repeticiones + " veces en la lista");

        System.out.println("El valor " + valorABuscar + " aparece " + repeticiones + " veces en la lista");

        System.out.println("El valor " + valorABuscar + " aparece " + repeticiones + " veces en la lista");
    }
}