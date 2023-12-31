package planificadores;

import java.util.ArrayList;

import estructuras.Pila;
import nodos.Proceso;
import utils.input.Entradas;
import utils.ui.ProcesoUi;

public class LIFO extends General {
  private Pila pila;

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

      if( procesoCpu == null && listProcesos.isEmpty() && !pila.isEmpty()){
        procesoCpu = pila.pop();
        cambiarDatosCpu();
      }

      mostrarDatosCPU();
      pila.showElements();
      
      inputs.esperar();
    }

    procesoUi.mostarProcesos(procesosTerminados, true, true);
  }
  
  private void asignarEstadosUbicaciones( ArrayList<Proceso> listProcesos ){
    asignarProcesoCPUInicial(listProcesos);
    ponerProcesosEnEspera(listProcesos);
  }

  private void ponerProcesosEnEspera( ArrayList<Proceso> listProcesos ){

    for (Proceso proceso : listProcesos) {
      cambiarDatosProceso(proceso);
      pila.push(proceso);
    }
  }
  
  public LIFO( Proceso[] procesos ){
    iniciarVariables(procesos);
    pila = new Pila();
  }
}