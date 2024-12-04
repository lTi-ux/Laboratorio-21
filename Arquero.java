class Arquero extends Soldado {
    private int flechas;

    public Arquero(String nombre, int nivelVida, int fila, int columna, int flechas) {
        super(nombre, nivelVida, fila, columna);
        this.flechas = flechas;
    }

    @Override
    public String tipoDeSoldado() {
        return "Arquero";
    }

    public int getFlechas() {
        return flechas;
    }

    public void dispararFlecha() {
        if (flechas > 0) {
            flechas--;
            System.out.println(nombre + " dispara una flecha. Flechas restantes: " + flechas);
        } else {
            System.out.println(nombre + " no tiene flechas restantes.");
        }
    }
}
