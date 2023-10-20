package planificadores;

import java.util.ArrayList;

import estructuras.Cola;
import nodos.Proceso;
import utils.input.Entradas;
import utils.ui.ProcesoUi;

public class FIFO extends General{
  private Cola cola;

  public void realizarProcesos(){
    ProcesoUi procesoUi = new ProcesoUi();
    Entradas inputs = new Entradas();
    ArrayList<Proceso> listProcesos;
    int tiempo = 0;

    while ( totalProcesosCompletados < procesos.length ) {
      tiempo++;
      System.out.println("---Tiempo--\n|   " + tiempo + "     |" + "\n-----------");
      reducirDuracionProcesoCpu();

      listProcesos = buscarProcesos(tiempo);
      if( !listProcesos.isEmpty() ) asignarEstadosUbicaciones(listProcesos);

      if( procesoCpu == null && listProcesos.isEmpty() && !cola.isEmpty()){
        procesoCpu = cola.out();
        cambiarDatosCpu();
      }

      mostrarDatosCPU();
      cola.showElements();
      
      inputs.esperar();
    }

    procesoUi.mostarProcesos(procesosTerminados, true, true);
  }

  private void asignarEstadosUbicaciones(ArrayList<Proceso> listProcesos) {
    asignarProcesoCPUInicial(listProcesos);
    ponerProcesosEnEspera(listProcesos);
  }

  private void ponerProcesosEnEspera( ArrayList<Proceso> listProcesos ){

    for (Proceso proceso : listProcesos) {
      cambiarDatosProceso(proceso);
      cola.in(proceso);
    }
  }

  public FIFO( Proceso[] procesos){
    iniciarVariables( procesos );
    cola = new Cola();
  }  
}