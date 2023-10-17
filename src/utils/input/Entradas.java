package utils.input;

import java.util.Scanner;

public class Entradas {

  private int opc, numProcesos;
  private Scanner input;

  public void leerOpcion(){
    opc = input.nextInt();
  }

  public void leerNumProcesos(){
    numProcesos = input.nextInt();
  }

  public int getOpc(){
    return opc;
  }

  public int getNumProcesos(){
    return numProcesos;
  }

  public Entradas(){
    input = new Scanner(System.in);
  }  
}