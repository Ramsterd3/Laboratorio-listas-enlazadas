public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamanio;
    public Nodo<T> getFrente() {
        return frente;
    }
    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }
    public Nodo<T> getFin() {
        return fin;
    }
    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }
    public Cola(){
        this.frente = null;
        this.fin = null;
        this.tamanio = 0;
    }
}
