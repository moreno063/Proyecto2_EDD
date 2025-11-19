public class Pelicula implements Comparable<Pelicula> {

    private int id;
    private String titulo;
    private String genero;
    private int anio;

    public Pelicula(int id, String titulo, String genero, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return titulo + " (" + anio + ") - " + genero;
    }

    @Override
    public int compareTo(Pelicula otra) {
        // Ordenar por título para usar en el AVL
        return this.titulo.compareToIgnoreCase(otra.titulo);
    }
}
