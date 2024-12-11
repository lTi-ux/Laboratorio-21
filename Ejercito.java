import java.util.*;
import java.util.stream.Collectors;


class Ejercito {
    private String reino;
    private List<Soldado> soldados;

    public Ejercito(String reino) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
    }

    public void crearEjercito() {
        Random rand = new Random();
        String[] tipos = {"Espadachin", "Arquero", "Caballero", "Lancero"};
        int numeroSoldados = rand.nextInt(10) + 1;

        for (int i = 0; i < numeroSoldados; i++) {
            String tipo = tipos[rand.nextInt(tipos.length)];
            String nombre = tipo + rand.nextInt(10) + "X" + (i + 1);
            int fila = rand.nextInt(Mapa.TAMANO_MAPA);
            int columna = rand.nextInt(Mapa.TAMANO_MAPA);

            switch (tipo) {
                case "Espadachin" -> soldados.add(new Espadachin(nombre, rand.nextInt(3) + 8, fila, columna, rand.nextInt(5) + 1));
                case "Arquero" -> soldados.add(new Arquero(nombre, rand.nextInt(3) + 3, fila, columna, rand.nextInt(10) + 5));
                case "Caballero" -> soldados.add(new Caballero(nombre, rand.nextInt(3) + 10, fila, columna, rand.nextBoolean(), "espada"));
                case "Lancero" -> soldados.add(new Lancero(nombre, rand.nextInt(4) + 5, fila, columna, rand.nextInt(5) + 1));
            }
        }
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public String getReino() {
        return reino;
    }

    public int obtenerVidaTotal() {
        return soldados.stream().mapToInt(Soldado::getNivelVida).sum();
    }

    public void mostrarResumen() {
        Map<String, Long> distribucion = soldados.stream()
            .collect(Collectors.groupingBy(Soldado::tipoDeSoldado, Collectors.counting()));
        System.out.println("Ejército: " + reino);
        System.out.println("Total de soldados: " + soldados.size());
        distribucion.forEach((tipo, cantidad) -> System.out.println(tipo + ": " + cantidad));
        System.out.println("Nivel de vida total: " + obtenerVidaTotal());
    }
}