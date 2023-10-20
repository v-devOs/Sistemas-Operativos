
import utils.Controlador;
import utils.input.Entradas;
import utils.ui.MenuUi;
import utils.ui.ProcesoUi;

public class App {
    public static void main(String[] args) throws Exception {
        // Logica
        Entradas inputs = new Entradas();
        Controlador controller;

        // Salida consola
        MenuUi menuUi = new MenuUi();
        ProcesoUi processUi = new ProcesoUi();

        do {
            menuUi.mostrarMenuOpciones();
            inputs.leerOpcion();

            if( inputs.getOpc() != 0 ){

                menuUi.mostrarMensajeProcesos();
                inputs.leerNumProcesos();
    
                controller = new Controlador(inputs);
                controller.crearProcesos();
    
                processUi.mostarProcesos(controller.getProcesosCreados(), false, false );

                // inputs.esperar();
    
                controller.realizarProcesosCreados();
            } 
    
        } while (inputs.getOpc() != 0);
    }
}
