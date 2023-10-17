package nodos;

public class Proceso {
  private Proceso procesoSig;
  private String pid, llegada, estado, ubicacion;
  private int duracion;

  public Proceso( int pid ){
    procesoSig = null;
    estado = ubicacion = "";

    this.pid = pid > 9 ? String.valueOf(pid) : "0" + String.valueOf(pid);
    this.duracion = (int) Math.floor(Math.random() * 10);
    this.llegada = String.valueOf(Math.floor(Math.random() * 10));
  }

  public void setProcesoSig( Proceso sig ){
    procesoSig = sig;
  }

  public Proceso getProcesoSig(){
    return procesoSig;
  }

  public void restDuracion(){
    duracion--;
  }

  public void setUbicacion( String ubicacion ){
    this.ubicacion = ubicacion;
  }

  @Override
  public String toString(){
    return pid + " | " + llegada + " | " + duracion;
  }

  public String extendToString(){
    return toString() + " | " + estado + " | " + ubicacion;
  }
}
