
package GUI.AdminClientes;

import GUI.Menu;
import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import Principal.Funciones;
import static Principal.Proyecto1_SAP.nameuser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
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
        textos();
        botones();
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
    
    private void textos()
    {
        Label lb3=new Label(77,12,800,60);
        lb3.setText(fn.texto("Dashboard", true,6));
        lb3.setHorizontalAlignment(LEFT);
        pane1.add(lb3);
        
        JLabel s0=new JLabel();
        s0.setBounds(15, 12, 55, 55);
        ImageIcon im= new ImageIcon("Resources\\clientesr.png");
        Icon scale=new ImageIcon(im.getImage().getScaledInstance(s0.getWidth(), s0.getHeight(), Image.SCALE_DEFAULT));
        s0.setIcon(scale);
        pane1.add(s0);
    }
    
    private void botones()
    {
//        int x=0, y=-25;
//        Boton clientes=new Boton(null,96+x,220+y,126,126);
//        clientes.setBackground(gris);
//        clientes.setIcon(setIcono("Resources\\clientes.png",clientes));
//        pane.add(clientes);
        
    }
    
    private void etiquetas()
    {
//        int y=-15;
//        Label cliente=new Label(96,344+y,126,50);
//        cliente.setText(fn.texto("Administración de clientes", true,3));
//        cliente.setForeground(celeste);
//        pane.add(cliente);
    }
    
    private Icon setIcono(String path, JButton boton)
    {
        ImageIcon icon=new ImageIcon(path);
        int ancho=boton.getWidth();
        int alto=boton.getHeight();
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
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
