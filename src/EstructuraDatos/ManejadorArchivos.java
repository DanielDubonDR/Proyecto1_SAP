
package EstructuraDatos;

import Principal.Controlador.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static Principal.Proyecto1_SAP.clientes;

/**
 *
 * @author Daniel Dubón
 */
public class ManejadorArchivos {
    private File path;
    private FileReader entrada;
    private int contador=0;
    public void abrir()
    {
        JFileChooser choose=new JFileChooser();
        choose.setCurrentDirectory(new java.io.File("."));
        choose.setDialogTitle("Cargar Archivo");
        FileNameExtensionFilter filtro=new FileNameExtensionFilter(".csv","csv");
        choose.addChoosableFileFilter(filtro);
        choose.setAcceptAllFileFilterUsed(true);
        
        if(choose.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            System.out.println("se abrio archivo");
            path =choose.getSelectedFile();
            System.out.println(path);
        }
        else
        {
            System.out.println("NO se abrio archivo");
        }
    }
    
    public void cargarClientes() throws IOException//este metodo me extrae lo que contiene el archivo de texto
    {
        try 
         {
             entrada=new FileReader(path);
             String linea;
             BufferedReader lector =new BufferedReader(entrada);//creo un buffer que me lee por lineas
             while((linea=lector.readLine())!=null)
             {
                 String cadena[];
                 cadena=linea.split(",");
                 Cliente aux=new Cliente(cadena[0],Integer.parseInt(cadena[1]),cadena[2].charAt(0),Integer.parseInt(cadena[3]),cadena[4]);
                 clientes[contador]=aux;
                 contador++;
             }
             System.out.println(clientes[6]);
         } catch (FileNotFoundException ex) {
             System.out.print("Error al abrir el archivo"); //agrego excepciones por si hay algun error
         }
            catch (IOException e)
            {
                System.out.println("Error");
            }
         finally
         {
            entrada.close();//simpre cierro mi buffer para evitar problemas
         }
    }
    
}
