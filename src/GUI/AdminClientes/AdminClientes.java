
package GUI.AdminClientes;

import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import Principal.Funciones;
import static Principal.Proyecto1_SAP.nameuser;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Daniel Dubón
 */
public class AdminClientes extends JFrame{
    
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    Panel pane1=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color azul=new Color(36, 49, 60);
    Color gris=new Color(236, 240, 241);
    Color celeste=new Color(0, 102, 204);
    
    public AdminClientes()
    {
        setSize(800, 436);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Administración de clientes");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        textos();
        botones();
        etiquetas();
//        cerrar();
    }
    
    private void agregarpaneles()
    {
        getContentPane().add(pane);
        pane.setBackground(Color.WHITE);
        pane1.setBounds(0, 0, 800, 85);
        pane1.setBackground(azul);
        pane.add(pane1);
    }
    
    private void textos()
    {
        Label lb3=new Label(77,12,800,60);
        lb3.setText(fn.texto("Administración de clientes", true,6));
        lb3.setHorizontalAlignment(LEFT);
        pane1.add(lb3);
        
        JLabel s0=new JLabel();
        s0.setBounds(15, 12, 55, 55);
        ImageIcon im= new ImageIcon("Resources\\clientes.png");
        Icon scale=new ImageIcon(im.getImage().getScaledInstance(s0.getWidth(), s0.getHeight(), Image.SCALE_DEFAULT));
        s0.setIcon(scale);
        pane1.add(s0);
    }
    
    private void botones()
    {
        int x=0, y=-100;
        Boton clientes=new Boton(null,96+x,220+y,126,126);
        clientes.setBackground(gris);
        clientes.setIcon(setIcono("Resources\\clientes.png",clientes));
        pane.add(clientes);
        
        Boton productos=new Boton(null,255+x,220+y,126,126);
        productos.setBackground(gris);
        productos.setIcon(setIcono("Resources\\producto.png",productos));
        pane.add(productos);
        
        Boton venta=new Boton(null,414+x,220+y,126,126);
        venta.setBackground(gris);
        venta.setIcon(setIcono("Resources\\ventas.png",venta));
        pane.add(venta);
        
        Boton reporte=new Boton(null,568+x,220+y,126,126);
        reporte.setBackground(gris);
        reporte.setIcon(setIcono("Resources\\reporte.png",reporte));
        pane.add(reporte);
    }
    
    private void etiquetas()
    {
        int y=-80;
        Label cliente=new Label(96,344+y,126,50);
        cliente.setText(fn.texto("Administración de clientes", true,3));
        cliente.setForeground(celeste);
        pane.add(cliente);
        
        Label producto=new Label(255,334+y,126,50);
        producto.setText(fn.texto("Administración de productos", true,3));
        producto.setForeground(celeste);
        pane.add(producto);
        
        Label ventas=new Label(414,334+y,126,50);
        ventas.setText(fn.texto("Administración de ventas", true,3));
        ventas.setForeground(celeste);
        pane.add(ventas);
        
        Label reportes=new Label(568,334+y,126,50);
        reportes.setText(fn.texto("Reportes", true,3));
        reportes.setForeground(celeste);
        pane.add(reportes);
    }
    
    private Icon setIcono(String path, JButton boton)
    {
        ImageIcon icon=new ImageIcon(path);
        int ancho=boton.getWidth();
        int alto=boton.getHeight();
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    
}
