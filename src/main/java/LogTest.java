import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogTest {
    private static Logger log = Logger.getLogger(LogTest.class.getName());

    public static void div (int a, int b){
        try {
            System.out.println("result of division = " + a / b);
        }
        catch (ArithmeticException e){
            log.log(Level.SEVERE,"Division by zero", e);
        }
        finally {
            log.fine("Everithing is ok");
        }

    }


    public static void main(String[] args) {
        //log init
        try {
            LogManager.getLogManager().readConfiguration(
                    LogTest.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        // exec
        int a  =15;
        int b = 0;
        LogTest.div(a,b);
    }
}
