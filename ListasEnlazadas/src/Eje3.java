public class Eje3 {

    public static class Node {
        public int dato;
        public Node next;

        public Node(int dato) {
            this.dato = dato;
            this.next = null;
        }
    }

    public static Node eliminarPares(Node cabeza) {
        while (cabeza != null && cabeza.dato % 2 == 0) {
            cabeza = cabeza.next;
        }

        if (cabeza == null) {
            return null;
        }

        Node current = cabeza;
        while (current.next != null) {
            if (current.next.dato % 2 == 0) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return cabeza;
    }

    public static void imprimirLista(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.dato + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node lista = new Node(2);
        lista.next = new Node(4);
        lista.next.next = new Node(1);
        lista.next.next.next = new Node(6);
        lista.next.next.next.next = new Node(3);
        lista.next.next.next.next.next = new Node(8);
        lista.next.next.next.next.next.next = new Node(5);

        imprimirLista(lista);

        lista = eliminarPares(lista);

        imprimirLista(lista);
    }
}
