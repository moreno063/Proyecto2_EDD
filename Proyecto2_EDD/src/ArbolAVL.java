public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public void insertar(Pelicula pelicula) {
        raiz = insertar(raiz, pelicula);
    }

    private NodoAVL insertar(NodoAVL nodo, Pelicula pelicula) {

        if (nodo == null) {
            return new NodoAVL(pelicula);
        }

        if (pelicula.compareTo(nodo.pelicula) < 0) {
            nodo.izquierdo = insertar(nodo.izquierdo, pelicula);
        } else if (pelicula.compareTo(nodo.pelicula) > 0) {
            nodo.derecho = insertar(nodo.derecho, pelicula);
        } else {
            return nodo;
        }
        
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && pelicula.compareTo(nodo.izquierdo.pelicula) < 0) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && pelicula.compareTo(nodo.derecho.pelicula) > 0) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && pelicula.compareTo(nodo.izquierdo.pelicula) > 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && pelicula.compareTo(nodo.derecho.pelicula) < 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public Pelicula buscar(String titulo) {
        return buscar(raiz, titulo);
    }

    private Pelicula buscar(NodoAVL nodo, String titulo) {
        if (nodo == null) return null;

        int comp = titulo.compareToIgnoreCase(nodo.pelicula.getTitulo());

        if (comp == 0) {
            return nodo.pelicula;
        } else if (comp < 0) {
            return buscar(nodo.izquierdo, titulo);
        } else {
            return buscar(nodo.derecho, titulo);
        }
    }

    private int altura(NodoAVL nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = 1 + Math.max(altura(y.izquierdo), altura(y.derecho));
        x.altura = 1 + Math.max(altura(x.izquierdo), altura(x.derecho));

        return x; 
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = 1 + Math.max(altura(x.izquierdo), altura(x.derecho));
        y.altura = 1 + Math.max(altura(y.izquierdo), altura(y.derecho));

        return y;
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(NodoAVL nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println(nodo.pelicula);
            inOrden(nodo.derecho);
        }
    }
}
