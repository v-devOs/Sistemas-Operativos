package utils;

import nodos.Proceso;
import planificadores.LIFO;
import utils.input.Entradas;

public class Controlador {
  private Entradas inputs;
  private Proceso[] procesosCreados;
  private LIFO lifo;


  public void crearProcesos(){
    int count;

    for ( count = 0; count < inputs.getNumProcesos(); count++) {
      procesosCreados[count] = new Proceso(count);
    }
  }

  public void realizarProcesosCreados(){

    switch (inputs.getOpc()) {
      case 1:
        lifo = new LIFO(procesosCreados);
        lifo.realizarProcesos();
        
        break;
    
      default:
        break;
    }
  }

  public Proceso[] getProcesosCreados(){
    return procesosCreados;
  }

  public Controlador( Entradas inputs ){
    this.inputs = inputs;
    this.procesosCreados = new Proceso[inputs.getNumProcesos()];
  }
}
