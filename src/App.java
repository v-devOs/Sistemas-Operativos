
import utils.input.Entradas;
import utils.ui.MenuUi;

public class App {
    public static void main(String[] args) throws Exception {
        Entradas inputs = new Entradas();
        MenuUi menuUi = new MenuUi();

        do {
            menuUi.mostrarMenuOpciones();
            inputs.leerOpcion();
    
            menuUi.mostrarMensajeProcesos();
            inputs.leerNumProcesos();
        } while (inputs.getOpc() != 0);
    }
}
