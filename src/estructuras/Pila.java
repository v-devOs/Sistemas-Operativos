package estructuras;

import nodos.Proceso;

public class Pila {

  private Proceso tope;

  public void push( Proceso sig ){
    if( tope == null ) tope = sig;
    else{
      sig.setProcesoSig( tope );
      tope = sig;
    }
  }

  public Proceso pop(){
    if( tope == null ) return null;
    else{
      Proceso aux = tope;

      tope = tope.getProcesoSig();
      return aux;
    }
  }

  public boolean isEmpty(){
    return tope == null;
  }

  public Pila(){
    tope = null;
  }
}
