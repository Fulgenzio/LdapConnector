import contracts.Credentials;
import helpers.ADConnector;
import implementation.OperationsImpl;
import interfaces.Operations;
import ui.LoginWindow;
import ui.MainFrame;

public class Main {

    public static void main(String[] args) throws Exception {
        ADConnector connector = ADConnector.getConnector();

        Operations op = new OperationsImpl();
        MainFrame frame = MainFrame.getMain();
        frame.startup();
    }
}

