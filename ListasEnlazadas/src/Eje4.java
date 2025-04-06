
public class Eje4 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node obtenerImpares(Node head) {
        Node nuevaLista = null;
        Node tail = null;

        Node current = head;
        while (current != null) {
            if (current.value % 2 != 0) {
                Node nuevoNodo = new Node(current.value);

                if (nuevaLista == null) {
                    nuevaLista = nuevoNodo;
                    tail = nuevoNodo;
                } else {
                    tail.next = nuevoNodo;
                    tail = nuevoNodo;
                }
            }
            current = current.next;
        }

        return nuevaLista;
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

        Node lista = new Node(1);
        lista.next = new Node(2);
        lista.next.next = new Node(3);
        lista.next.next.next = new Node(4);
        lista.next.next.next.next = new Node(5);
        lista.next.next.next.next.next = new Node(6);
        lista.next.next.next.next.next.next = new Node(7);

        imprimirLista(lista);

        Node impares = obtenerImpares(lista);

        imprimirLista(impares);

        imprimirLista(lista);
    }
}
