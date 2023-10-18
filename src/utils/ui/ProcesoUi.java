package utils.ui;

import nodos.Proceso;

public class ProcesoUi {
  

  public void mostarProcesos( Proceso[] procesos, boolean usarExtend, boolean esSalidaFinal ){
    String header = esSalidaFinal ? "Salida" : "Procesos creados";
    int index;

    System.out.println("--------"+header+"---------");
    for ( index = 0; index < procesos.length; index++) {

      if( usarExtend ) System.out.println(procesos[index].extendToString());
      else System.out.println(procesos[index].toString());
    }
  }

  public void mostrarProcesoCpu( Proceso proceso ){
    System.out.println("---------CPU--------");
    proceso.extendToString();
  }  
}
