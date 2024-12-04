public class Caballero extends Soldado {
    private String armaActual;
    private boolean montado;

    public Caballero(String nombre, int puntosDeVida, int fila, int columna, String armaActual) {
        super(nombre, puntosDeVida, fila, columna);
        this.armaActual = armaActual;
        this.montado = false;
    }

    public void montar() {
        if (!montado) {
            montado = true;
            armaActual = "Lanza";
            System.out.println(nombre + " ha montado su caballo y cambia a " + armaActual + ".");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            armaActual = "Espada";
            System.out.println(nombre + " ha desmontado de su caballo y cambia a " + armaActual + ".");
        }
    }

    public void alternarArma(String nuevaArma) {
        this.armaActual = nuevaArma;
        System.out.println(nombre + " ha cambiado a " + armaActual + ".");
    }

    public void envestir(Soldado enemigo) {
        if (montado) {
            System.out.println(nombre + " realiza una envestida con " + armaActual + " (montado).");
            enemigo.puntosDeVida -= 3;
        } else {
            System.out.println(nombre + " realiza una envestida con " + armaActual + " (desmontado).");
            enemigo.puntosDeVida -= 2;
        }
    }

    @Override
    public void atacar(Soldado enemigo) {
        envestir(enemigo);
    }
}
