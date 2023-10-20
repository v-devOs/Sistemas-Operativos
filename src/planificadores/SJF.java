package planificadores;

import java.util.ArrayList;

import estructuras.Lista;
import estructuras.Lista2;
import nodos.Proceso;
import utils.input.Entradas;
import utils.ui.ProcesoUi;

public class SJF extends General {
  private Lista2 lista;

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

      if( procesoCpu == null && listProcesos.isEmpty() && !lista.isEmpty()){
        procesoCpu = lista.remove();
        cambiarDatosCpu();
      }

      mostrarDatosCPU();
      lista.showElements();
      
      // inputs.esperar();
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
      lista.in(proceso);
    }
  }

  public SJF( Proceso[] procesos ){
    iniciarVariables(procesos);
    lista = new Lista2();
  }
}
