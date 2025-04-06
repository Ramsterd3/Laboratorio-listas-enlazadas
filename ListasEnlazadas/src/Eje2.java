import java.util.LinkedList;
import java.util.List;

public class Eje2 {
    static class Persona {
        private String nombre;
        private String cedula;

        public Persona(String nombre, String cedula) {
            this.nombre = nombre;
            this.cedula = cedula;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCedula() {
            return cedula;
        }

        @Override
        public String toString() {
            return nombre + " (Cédula: " + cedula + ")";
        }
    }

    public static class FiltrarPersonas {

        public static List<Persona> personasConCedulaPar(List<Persona> personas) {
            List<Persona> R = new LinkedList<>();

            for (Persona p : personas) {
                String cedulaLimpia = p.getCedula().replaceAll("[^0-9]", "");
                if (cedulaLimpia.length() % 2 == 0) {
                    R.add(p);
                }
            }

            return R;
        }

        public static void main(String[] args) {

            List<Persona> personas = new LinkedList<>();
            personas.add(new Persona("personaA", "12345678"));       // 8 dígitos (par)
            personas.add(new Persona("personaB", "876-543-21"));     // 8 dígitos (par)
            personas.add(new Persona("personaC", "13579"));          // 5 dígitos (impar)
            personas.add(new Persona("personaD", "246800"));         // 6 dígitos (par)

            List<Persona> personasFiltradas = personasConCedulaPar(personas);

            personas.forEach(System.out::println);

            personasFiltradas.forEach(System.out::println);
        }
    }
}
