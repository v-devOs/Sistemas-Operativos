package planificadores;

import java.util.ArrayList;

import nodos.Proceso;

public class General {
  public Proceso[] procesos, procesosTerminados;
  protected Proceso procesoCpu;
  public int posSalidaProceso;
  public int totalProcesosCompletados;


  public void reducirDuracionProcesoCpu(){
    if( procesoCpu != null ){
      procesoCpu.restDuracion();

      if( procesoCpu.getDuracion() == 0 ){
        procesoCpu.setEstado("F");
        procesoCpu.setUbicacion("S");
        procesosTerminados[posSalidaProceso] = procesoCpu;
        posSalidaProceso++;
        totalProcesosCompletados++;
        procesoCpu = null;
      }
    }
  }

  public ArrayList<Proceso> buscarProcesos( int tiempo ){
    ArrayList<Proceso> listProcesos = new ArrayList<>();
    int index;


    for ( index = 0; index < procesos.length; index++) {
      if( procesos[index].getLlegada() == tiempo ) listProcesos.add(procesos[index]);
    }

    return listProcesos;
  }

  public void  asignarProcesoCPUInicial( ArrayList<Proceso> listProcesos ){
    if( procesoCpu == null ){
      procesoCpu = listProcesos.get(0);
      listProcesos.remove(0);
      cambiarDatosCpu();
    }
  }

  public void cambiarDatosCpu(){
    procesoCpu.setEstado("X");
    procesoCpu.setUbicacion("CPU");
  }

  public void cambiarDatosProceso( Proceso proceso ){
    proceso.setEstado("W");
    proceso.setUbicacion("M");
  }

  public void mostrarDatosCPU(){
    System.out.println("-----------CPU-----------");

    if( procesoCpu != null ) System.out.println(procesoCpu.extendToString());
  }

  public void iniciarVariables( Proceso[] procesos ){
    this.procesos = procesos;
    procesoCpu = null;
    posSalidaProceso = 0;
    totalProcesosCompletados = 0;
    procesosTerminados = new Proceso[ procesos.length ];
  }
}
