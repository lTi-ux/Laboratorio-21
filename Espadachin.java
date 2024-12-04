class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(String nombre, int nivelVida, int fila, int columna, int longitudEspada) {
        super(nombre, nivelVida, fila, columna);
        this.longitudEspada = longitudEspada;
    }

    @Override
    public String tipoDeSoldado() {
        return "Espadachin";
    }

    public int getLongitudEspada() {
        return longitudEspada;
    }

    public void crearMuroDeEscudos() {
        System.out.println(nombre + " crea un muro de escudos para defenderse!");
    }
}
