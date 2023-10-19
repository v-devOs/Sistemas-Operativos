package utils;

import nodos.Proceso;
import planificadores.FIFO;
import planificadores.LIFO;
import planificadores.LJF;
import planificadores.SJF;
import utils.input.Entradas;

public class Controlador {
  private Entradas inputs;
  private Proceso[] procesosCreados;
  private LIFO lifo;
  private FIFO fifo;
  private SJF sjf;
  private LJF ljf;


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
      case 2: 
        fifo = new FIFO(procesosCreados);
        fifo.realizarProcesos();
      case 3:
        sjf = new SJF(procesosCreados);
        sjf.realizarProcesos();
      case 4:
        ljf = new LJF(procesosCreados);
        ljf.realizarProcesos();
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
