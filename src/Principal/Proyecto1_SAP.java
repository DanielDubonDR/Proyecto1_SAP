
package Principal;

import EstructuraDatos.ManejadorArchivos;
import GUI.AdminClientes.AdminClientes;
import GUI.AdminClientes.DashboardClientes;
import GUI.AdminClientes.DetalleCliente;
import GUI.AdminClientes.InfoCliente;
import GUI.AdminProductos.MenuProductos;
import GUI.Login;
import GUI.Menu;
import GUI.Registro;
import Principal.Controlador.Cliente;
import Principal.Controlador.Usuario;
import java.io.IOException;

/**
 *
 * @author Daniel Dubón
 */
public class Proyecto1_SAP {
    
    public static Usuario [] users=new Usuario[10];
    public static Cliente [] clientes=new Cliente[100];
    public static String nameuser="Daniel Dubón";
    public static int contador=0, contadorCl=0;
    
    public static void main(String[] args) throws IOException
    {
        Cliente aux=new Cliente("Daniel Dubon",21,'M',49987,"Resources\\buscar.png");
        clientes[0]=aux;
        contadorCl++;
        //users[0]=new Usuario("admin","admin","admin");
//        Registro abrir=new Registro();
//        Login abrir=new Login();
//        Menu abrir=new Menu();
//        AdminClientes abrir=new AdminClientes();
//        abrir.setVisible(true);
//        ManejadorArchivos abrir=new ManejadorArchivos();
//        abrir.abrir();
//        abrir.cargarClientes();
//        DashboardClientes abrir=new DashboardClientes();
//        abrir.setVisible(true);
        
//        InfoCliente abrir=new InfoCliente();
        
//        DetalleCliente abrir=new DetalleCliente();
        MenuProductos abrir=new MenuProductos();
        abrir.setVisible(true);
    }
}
