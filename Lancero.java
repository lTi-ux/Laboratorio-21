class Lancero extends Soldado {
    private int longitudLanza;

    public Lancero(String nombre, int nivelVida, int fila, int columna, int longitudLanza) {
        super(nombre, nivelVida, fila, columna);
        this.longitudLanza = longitudLanza;
    }

    @Override
    public String tipoDeSoldado() {
        return "Lancero";
    }

    public int getLongitudLanza() {
        return longitudLanza;
    }

    public void schiltrom() {
        System.out.println(nombre + " forma un schiltrom y aumenta su nivel de defensa!");
        this.nivelVida += 1;
    }
}
