public class Nodo<T>{
    private T elemento;
    private Nodo<T> siguiente;
    public T getElemento(){
        return this.elemento;
    }
    public void setElemento(T elemento){
        this.elemento = elemento;
    }
    public Nodo<T> getSiguiente(){
        return this.siguiente;
    }
    public void setSiguiente(Nodo<T> siguiente){
        this.siguiente = siguiente;
    }
}
