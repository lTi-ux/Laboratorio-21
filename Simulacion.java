import java.util.*;
import java.util.stream.Collectors;
public class Simulacion {
    public static void main(String[] args) {
        Ejercito ejercito1 = new Ejercito("Inglaterra");
        ejercito1.crearEjercito();

        Ejercito ejercito2 = new Ejercito("Francia");
        ejercito2.crearEjercito();

        Mapa mapa = new Mapa("bosque");
        mapa.posicionarEjercitos(ejercito1, ejercito2);

        mapa.mostrarTablero();  // Mostrar el mapa

        // Mostrar detalles de los soldados
        System.out.println("\n=== DETALLE DE LOS SOLDADOS DE CADA EJÉRCITO ===");
        mostrarDetalleEjercito(ejercito1, "\nEjército 1: Inglaterra");
        mostrarDetalleEjercito(ejercito2, "\nEjército 2: Francia");

        // Calcular resultados de la batalla
        mostrarResultados(ejercito1, ejercito2);
    }

    private static void mostrarDetalleEjercito(Ejercito ejercito, String nombreEjercito) {
        System.out.println(nombreEjercito);
        System.out.println("Total de soldados: " + ejercito.getSoldados().size());

        Map<String, Long> distribucion = ejercito.getSoldados().stream()
            .collect(Collectors.groupingBy(Soldado::tipoDeSoldado, Collectors.counting()));
        
        distribucion.forEach((tipo, cantidad) -> System.out.println(tipo + ": " + cantidad));

        for (Soldado soldado : ejercito.getSoldados()) {
            System.out.printf("- %s (Vida: %d, Posición: [%d,%d])%n",
                    soldado.getNombre(), soldado.getNivelVida(), soldado.getFila(), soldado.getColumna());
        }

        Soldado soldadoMayorVida = ejercito.getSoldados().stream()
            .max(Comparator.comparingInt(Soldado::getNivelVida))
            .orElse(null);

        if (soldadoMayorVida != null) {
            System.out.println("Soldado con mayor vida: " + soldadoMayorVida.getNombre() + " (Vida: " + soldadoMayorVida.getNivelVida() + ")");
        }

        // Ranking por vida
        System.out.println("\n=== RANKING DEL " + nombreEjercito.split(":")[1] + " ===\n");
        ejercito.getSoldados().stream()
            .sorted(Comparator.comparingInt(Soldado::getNivelVida).reversed())
            .forEach(s -> System.out.printf("%s - Vida: %d%n", s.getNombre(), s.getNivelVida()));
    }

    private static void mostrarResultados(Ejercito ejercito1, Ejercito ejercito2) {
        int vida1 = ejercito1.obtenerVidaTotal();
        int vida2 = ejercito2.obtenerVidaTotal();

        double porcentaje1 = (vida1 / (double)(vida1 + vida2)) * 100;
        double porcentaje2 = 100 - porcentaje1;

        System.out.printf("\n=== RESULTADOS DE LA BATALLA ===%n\n");
        System.out.printf("Nivel de vida total:%n- Ejército 1 (Inglaterra): %d%n- Ejército 2 (Francia): %d%n", vida1, vida2);

        System.out.printf("Probabilidad de victoria:%n- Ejército 1: %.2f%%%n- Ejército 2: %.2f%%%n", porcentaje1, porcentaje2);

        String ganador = Math.random() * 100 < porcentaje1 ? "Ejército 1 de Inglaterra" : "Ejército 2 de Francia";
        System.out.println("El ganador es el " + ganador);
    }
}
