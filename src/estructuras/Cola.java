package estructuras;

import nodos.Proceso;

public class Cola {
  private Proceso inicio;

  public void in( Proceso sig ){

    if( inicio == null ) inicio = sig;
    else{
      Proceso aux = buscarPosicion();
      aux.setProcesoSig(sig);
    }
  }

  private Proceso buscarPosicion(){
    Proceso aux = inicio;

    while( aux.getProcesoSig() != null ){
      aux = aux.getProcesoSig();
    }

    return aux;
  }

  public Proceso out(){
    if( inicio == null ) return null;
    else{
      Proceso aux = inicio;
      inicio = inicio.getProcesoSig();
      
      return aux;
    }
  }

  public boolean isEmpty(){
    return inicio == null;
  }

  public void showElements(){
    Proceso aux = inicio;

    System.out.println("----Memoria----");

    if( inicio != null ){
      while (aux.getProcesoSig() != null ) {
        System.out.println(aux.extendToString());
        aux = aux.getProcesoSig();
      }
    }
  }

  public Cola(){
    inicio = null;
  }
}
