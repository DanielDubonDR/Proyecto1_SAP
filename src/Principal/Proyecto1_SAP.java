
package Principal;

import GUI.Login;
import GUI.Menu;
import GUI.Registro;
import Principal.Controlador.Usuario;

/**
 *
 * @author Daniel Dubón
 */
public class Proyecto1_SAP {
    
    public static Usuario [] users=new Usuario[10];
    public static int contador=0;
    
    public static void main(String[] args)
    {
        Registro abrir=new Registro();
//        Login abrir=new Login();
//        Menu abrir=new Menu();
        abrir.setVisible(true);
    }
}
