package utils.ui;

import nodos.Proceso;

public class ProcesoUi {
  

  public void mostarProcesosCreados( Proceso[] procesos ){

    int index;


    System.out.println("--------Procesos Creados---------");
    System.out.println("PID | Llegada | Duración");
    for ( index = 0; index < procesos.length; index++) {
      System.out.println(procesos[index].toString());
    }

  }
}
