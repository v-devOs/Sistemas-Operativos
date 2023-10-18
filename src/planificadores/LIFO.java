package planificadores;

import java.util.ArrayList;

import estructuras.Pila;
import nodos.Proceso;
import utils.input.Entradas;
import utils.ui.ProcesoUi;

public class LIFO {
  private Proceso[] procesos, procesosTerminados;
  private Pila pila;
  private Proceso procesoCpu;
  private int posSalidaProceso, totalProcesosCompleados;


  public void realizarProcesos(){
    ProcesoUi procesoUi = new ProcesoUi();
    Entradas inputs = new Entradas();
    ArrayList<Proceso> listProcesos;
    int tiempo = 0;

    while ( totalProcesosCompleados < procesos.length ) {
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

  private void reducirDuracionProcesoCpu(){
    if( procesoCpu != null ){
      procesoCpu.restDuracion();

      if( procesoCpu.getDuracion() == 0 ){
        procesoCpu.setEstado("F");
        procesoCpu.setUbicacion("S");
        procesosTerminados[posSalidaProceso] = procesoCpu;
        posSalidaProceso++;
        totalProcesosCompleados++;
        procesoCpu = null;
      }
    }
  }

  private ArrayList<Proceso> buscarProcesos( int tiempo ){
    ArrayList<Proceso> listProcesos = new ArrayList<>();
    int index;


    for ( index = 0; index < procesos.length; index++) {
      if( procesos[index].getLlegada() == tiempo ) listProcesos.add(procesos[index]);
    }

    return listProcesos;
  }

  private void asignarEstadosUbicaciones( ArrayList<Proceso> listProcesos ){

    if( procesoCpu == null ){
      procesoCpu = listProcesos.get(0);
      listProcesos.remove(0);
      cambiarDatosCpu();
    }

    ponerProcesosEnEspera(listProcesos);
  }

  private void ponerProcesosEnEspera( ArrayList<Proceso> listProcesos ){

    for (Proceso proceso : listProcesos) {
      proceso.setUbicacion("M");
      proceso.setEstado("W");
      proceso.extendToString();
      pila.push(proceso);
    }
  }

  private void cambiarDatosCpu(){
    procesoCpu.setEstado("X");
    procesoCpu.setUbicacion("CPU");
  }

  private void mostrarDatosCPU(){
    System.out.println("-----------CPU-----------");

    if( procesoCpu != null ) System.out.println(procesoCpu.extendToString());
  }
  

  public LIFO( Proceso[] procesos ){
    this.procesos = procesos;
    pila = new Pila();
    procesoCpu = null;
    posSalidaProceso = 0;
    procesosTerminados = new Proceso[ procesos.length ];
    totalProcesosCompleados = 0;
  }
}
