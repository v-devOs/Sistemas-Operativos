package nodos;

public class Proceso {
  private Proceso procesoSig;
  private String pid, estado, ubicacion;
  private int duracion, llegada;

  public Proceso( int pid ){
    procesoSig = null;
    estado = ubicacion = "";

    this.pid = pid > 9 ? String.valueOf(pid + 1) : "0" + String.valueOf(pid + 1);
    this.duracion = (int) (Math.floor(Math.random() * 10) + 1);
    this.llegada = (int) (Math.floor(Math.random() * 10) + 1);
  }

  public void setProcesoSig( Proceso sig ){
    procesoSig = sig;
  }

  public void setUbicacion( String ubicacion ){
    this.ubicacion = ubicacion;
  }

  public void setEstado( String estado ){
    this.estado = estado;
  }

  public int getDuracion(){
    return duracion;
  }

  public Proceso getProcesoSig(){
    return procesoSig;
  }

  public int getLlegada(){
    return llegada;
  }

  public void restDuracion(){
    duracion--;
  }


  @Override
  public String toString(){
    return "PID: " + pid + " | Llegada: " + llegada + " | Duración: " + duracion;
  }

  public String extendToString(){
    return toString() + "| Estado:  " + estado + " | Ubicación: " + ubicacion;
  }
}
