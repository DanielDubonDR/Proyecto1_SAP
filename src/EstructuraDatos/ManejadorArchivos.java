
package EstructuraDatos;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daniel Dubón
 */
public class ManejadorArchivos {
    
    public void abrir()
    {
        JFileChooser entrada=new JFileChooser();
        entrada.setCurrentDirectory(new java.io.File("."));
        entrada.setDialogTitle("Cargar Archivo");
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivos Entrada","csv");
        entrada.addChoosableFileFilter(filtro);
        entrada.setAcceptAllFileFilterUsed(true);
        
        if(entrada.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            System.out.println("se abrio archivo");
        }
        else
        {
            System.out.println("NO se abrio archivo");
        }
    }
    
}
