package utils.ui;

public class MenuUi {
  
  public void mostrarMenuOpciones(){
    System.out.println("-------Seleciona el tipo de que deseas seguir----------");
    System.out.println("1. LIFO\n2. FIFO\n3. SFJ\n4. LFJ\n0. Salir");
    System.out.print("Ingresa tu opción(0-4): ");
  }

  public void mostrarMensajeProcesos(){
    System.out.println("-------Ingresa el numero de procesos que deseas crear--------");
    System.out.print("Num: ");
  }

}
