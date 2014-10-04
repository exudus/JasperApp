import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author PC5
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(JavaApplication1.class.getClass().getResourceAsStream("/reports/master.jrxml"));
            jasperPrint = JasperFillManager.fillReport(compileReport, new HashMap(), JdbcConnection.getConnection());
            JFrame frame = new JFrame();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.getContentPane().add(new JRViewer(jasperPrint));
            frame.setVisible(true);
            
        } catch (JRException | SQLException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
