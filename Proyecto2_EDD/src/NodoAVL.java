public class NodoAVL {

    Pelicula pelicula;
    NodoAVL izquierdo;
    NodoAVL derecho;
    int altura;

    public NodoAVL(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1; // Un nodo nuevo tiene altura 1
    }
}
