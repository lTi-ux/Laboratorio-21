import java.util.*;
class Mapa {
    public static final int TAMANO_MAPA = 10;
    private String territorio; // Tipo de territorio (bosque, campo abierto, montaña, desierto, playa)
    private Soldado[][] tablero; // El tablero del mapa
    private Ejercito ejercito1;
    private Ejercito ejercito2;

    public Mapa(String territorio) {
        this.territorio = territorio;
        this.tablero = new Soldado[TAMANO_MAPA][TAMANO_MAPA];
        this.ejercito1 = new Ejercito("Inglaterra");
        this.ejercito2 = new Ejercito("Francia");
        crearEjercitos();
        aplicarBonificaciones();
       
    }

    public void crearEjercitos() {
        // Crear los dos ejércitos
        ejercito1.crearEjercito();
        ejercito2.crearEjercito();
        
        // Posicionar los soldados en el mapa
        posicionarEjercitos(ejercito1, ejercito2);
    }

    public void aplicarBonificaciones() {
        // Aplicar bonificaciones según el territorio
        if (territorio.equals("bosque")) {
            bonificarEjercito(ejercito1);  // Inglaterra y Sacro Imperio Romano
        } else if (territorio.equals("campo abierto")) {
            bonificarEjercito(ejercito2);  // Francia
        } else if (territorio.equals("montaña")) {
            bonificarEjercito(ejercito1);  // Castilla-Aragón
        } else if (territorio.equals("desierto")) {
            bonificarEjercito(ejercito2);  // Moros
        } else if (territorio.equals("playa")) {
            bonificarEjercito(ejercito1);  // Sacro Imperio Romano-Germánico
            bonificarEjercito(ejercito2);  // Francia
        }
    }

    public void bonificarEjercito(Ejercito ejercito) {
        for (Soldado soldado : ejercito.getSoldados()) {
            soldado.aumentarVida(1);  // Aumentar el nivel de vida en 1 a todos los soldados del ejército
        }
    }

    public void posicionarEjercitos(Ejercito ejercito1, Ejercito ejercito2) {
        posicionarEjercito(ejercito1, 'X');  // Posicionar el primer ejército (Inglaterra)
        posicionarEjercito(ejercito2, 'O');  // Posicionar el segundo ejército (Francia)
    }

    public void posicionarEjercito(Ejercito ejercito, char simbolo) {
        Random rand = new Random();
        for (Soldado soldado : ejercito.getSoldados()) {
            int fila, columna;
            do {
                fila = rand.nextInt(TAMANO_MAPA);
                columna = rand.nextInt(TAMANO_MAPA);
            } while (tablero[fila][columna] != null);  // Asegurarse de que no haya otro soldado en la misma posición
            tablero[fila][columna] = soldado;  // Colocar al soldado en la posición generada
        }
    }

    public void mostrarTablero() {
        System.out.println("=== MAPA DE LA BATALLA ===\n");
        System.out.println("Tipo de Territorio: " + territorio);
        System.out.println("Tamaño del mapa: " + TAMANO_MAPA + "x" + TAMANO_MAPA);
        
        System.out.println("E - Espadachin, A - Arquero, C - Caballero, L - Lancero");
        System.out.println("Ejército 1 (Inglaterra): X   Ejército 2 (Francia): O\n");
        
        System.out.println("Mapa:");
        for (int i = 0; i < TAMANO_MAPA; i++) {
            for (int j = 0; j < TAMANO_MAPA; j++) {
                if (tablero[i][j] != null) {
                    if (tablero[i][j] instanceof Espadachin) {
                        System.out.print("[X] ");
                    } else if (tablero[i][j] instanceof Arquero) {
                        System.out.print("[A] ");
                    } else if (tablero[i][j] instanceof Caballero) {
                        System.out.print("[C] ");
                    } else if (tablero[i][j] instanceof Lancero) {
                        System.out.print("[L] ");
                    }
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}