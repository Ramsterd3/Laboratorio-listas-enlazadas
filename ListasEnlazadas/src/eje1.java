import java.util.LinkedList;
import java.util.List;
public class eje1 {
    public static List<Integer> obtenerPosicionesImpares(List<Integer> lista) {
        List<Integer> resultado = new LinkedList<>();

        for (int i = 0; i < lista.size(); i += 2) {
            resultado.add(lista.get(i));
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> numeros = new LinkedList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);


        List<Integer> impares = obtenerPosicionesImpares(numeros);

        System.out.println("Lista original: " + numeros);
        System.out.println("Elementos en posiciones impares: " + impares);
    }
}

