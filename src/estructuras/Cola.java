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

  public Cola(){
    inicio = null;
  }
}
