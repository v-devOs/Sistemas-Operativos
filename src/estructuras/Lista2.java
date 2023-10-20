package estructuras;

import nodos.Proceso;

public class Lista2 {
  private Proceso inicio;
  private boolean ordenarMayorMenor;

  public void in( Proceso sig ){

    if( inicio == null ) inicio = sig;
    else if( inicio.getDuracion() > sig.getDuracion() ){
      sig.setProcesoSig(inicio);
      inicio = sig;
    }
    else{
      Proceso aux = buscarPosicion(sig);
      sig.setProcesoSig(aux.getProcesoSig());
      aux.setProcesoSig(sig);
    }
    
  }
  
  private Proceso buscarPosicion( Proceso sig ){
    Proceso auxBusqueda = inicio, seguidor = auxBusqueda;

    while ( auxBusqueda.getProcesoSig() != null && auxBusqueda.getProcesoSig().getDuracion() < sig.getDuracion() ) {
      seguidor = auxBusqueda;
      auxBusqueda = auxBusqueda.getProcesoSig();
    }

    return seguidor;
  }

  public Proceso remove(){
    Proceso aux;

    if( inicio == null ) return null;
    else{
      aux = inicio;
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
      aux.extendToString();
      aux = aux.getProcesoSig();
    }
  }
  public Lista2( ){
    inicio = null;
  }
}
