package planificadores;

import java.util.ArrayList;

import estructuras.Pila;
import nodos.Proceso;

public class LIFO {
  private Proceso[] procesos, procesosTerminados;
  private Pila pila;
  private Proceso procesoCpu;
  private int posSalidaProceso;


  public void realizarProcesos(){
    ArrayList<Proceso> listProcesos;
    int tiempo = 0;

    do {
      tiempo++;
      listProcesos = buscarProcesos(tiempo);
      asignarEstadosUbicaciones(listProcesos);
      
    } while (pila.isEmpty() == false);
    
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

    if( procesoCpu == null ) {
      procesoCpu = listProcesos.get(0);
      cambiarDatosCpu();
      ponerProcesosEnEspera(listProcesos);
    }
    else{
      procesoCpu.restDuracion();

      if( procesoCpu.getDuracion() == 0 ) {
        procesosTerminados[posSalidaProceso] = procesoCpu;
        procesoCpu = pila.pop();
        posSalidaProceso++;
        cambiarDatosCpu();
      };

      ponerProcesosEnEspera(listProcesos);
    }
  }

  public void ponerProcesosEnEspera( ArrayList<Proceso> listProcesos ){
    for (Proceso proceso : listProcesos) {
      proceso.setUbicacion("M");
      proceso.setEstado("W");
      pila.push(proceso);
    }
  }

  public void cambiarDatosCpu(){
    procesoCpu.setEstado("X");
    procesoCpu.setUbicacion("CPU");
  }
  



  public LIFO( Proceso[] procesos ){
    this.procesos = procesos;
    pila = new Pila();
    procesoCpu = null;
    posSalidaProceso = 0;
    procesosTerminados = new Proceso[ procesos.length ];
  }
}
