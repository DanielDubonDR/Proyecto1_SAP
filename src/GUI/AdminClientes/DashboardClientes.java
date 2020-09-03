
package GUI.AdminClientes;


import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import Principal.Funciones;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Daniel Dubón
 */
public class DashboardClientes extends JFrame {
    
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    Panel pane1=new Panel();//panel principal
    Panel panelTabla=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color azul=new Color(36, 49, 60);
    Color gris=new Color(236, 240, 241);
    Color celeste=new Color(0, 102, 204);
    
    private JTable tabla;
    
    
    public DashboardClientes()
    {
        setSize(800, 436);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Dashboard");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        etiquetas();
        agregarTabla();
//        cerrar();
    }
    
    private void agregarpaneles()
    {
        //panel principal
        getContentPane().add(pane);
        
        //panel dash
        pane.setBackground(Color.WHITE);
        pane1.setBounds(0, 0, 800, 85);
        pane1.setBackground(azul);
        pane.add(pane1);
        
        //tabla
        JScrollPane scrol=new JScrollPane();
        scrol.setBounds(0, 150, 790, 150);
        panelTabla.setLayout(new BorderLayout());
        pane.add(scrol);
        scrol.setViewportView(panelTabla);
        panelTabla.setPreferredSize(new Dimension(750,145));
    }
    
    private void etiquetas()
    {
        int y=120;
        Label nombre=new Label(0,y,197,30);
        nombre.setText(fn.texto("Nombre", true,3));
        nombre.setOpaque(true);
        nombre.setBackground(celeste);
        pane.add(nombre);
        
        Label edad=new Label(198,y,197,30);
        edad.setText(fn.texto("Edad", true,3));
        edad.setOpaque(true);
        edad.setBackground(celeste);
        pane.add(edad);
    }
    
    private void agregarTabla()
    {
        String[] nombreC={"Nombre","Edad","Sexo","NIT"};
        Object[][] filas={{"hola","asdf","sdf","dddd"},{"hola","asdf","sdf","dddd"},{"hola","asdf","sdf","dddd"},{"holad","adsdf","sddf","ddddd"},{"holfa","adsdf","sddf","ddddd"},{"holad","adsdf","sddf","ddddd"},{"holfa","adsdf","sddf","ddddd"}};
        tabla=new JTable(filas,nombreC);
        tabla.repaint();
        panelTabla.add(tabla);
    }
}
