
package GUI.AdminClientes;

import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import GUI.Utilidades.Texto;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Daniel Dubón
 */
public class DetalleCliente extends JFrame {
    
    Panel pane=new Panel();//panel principal
    Panel pane1=new Panel();//panel principal
    
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    Color gris=new Color(236, 240, 241);
    
    private Boton modificar;
    private Boton eliminar;
    private Label md;
    private Label del;
    private Texto buscar;
    private Texto nombre;
    private Texto edad;
    private JComboBox sexo;
    private Texto nit;
    
    public DetalleCliente()
    {
        setSize(775, 502);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Información Clientes");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        agregarBtn();
        agregarLb();
        agregarTxt();
    }
    
    private void agregarpaneles()
    {
        getContentPane().add(pane);
        pane.setBackground(Color.WHITE);
        pane1.setBounds(0, 0, 270, 502);
        pane1.setBackground(azul);
        pane.add(pane1);
    }
    
    private void agregarBtn()
    {
        modificar=new Boton("Modificar",71,184,175,40,16);
        modificar.setBackground(menta);
        pane1.add(modificar);
        
        eliminar=new Boton("Eliminar",71,242,175,40,16);
        eliminar.setBackground(menta);
        pane1.add(eliminar);
    }
    
    private void agregarLb()
    {
        md=new Label(29,184,40,40);
        md.setBackground(menta);
        md.setOpaque(true);
        pane1.add(md);
        
        del=new Label(29,242,40,40);
        del.setBackground(menta);
        del.setOpaque(true);
        pane1.add(del);
        
        Label b=new Label(217,72,30,30);
        b.setBackground(menta);
        b.setOpaque(true);
        pane1.add(b);
    }
    
    private void agregarTxt()
    {
        buscar=new Texto(29,72,218,30);
        buscar.setText("Buscar");
        //buscar.setBorder(null);
        pane1.add(buscar);
    }
    
    private Icon setIcono(String path, JLabel label)
    {
        ImageIcon icon=new ImageIcon(path);
        int ancho=label.getWidth();
        int alto=label.getHeight();
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
}
