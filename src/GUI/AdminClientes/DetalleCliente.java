
package GUI.AdminClientes;

import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import GUI.Utilidades.Texto;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private Boton b;
    private Label md;
    private Label del;
    private Label bb;
    private Label txt;
    private Label n;
    private Label e;
    private Label s;
    private Label nt;
    private Texto buscar;
    private Label nombre;
    private Label edad;
    private Label sexo;
    private Label nit;
    private Label foto;
    
    public DetalleCliente()
    {
        setSize(725, 430);
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
        modificar=new Boton("Modificar",66,184,180,40,16);
        modificar.setBackground(menta);
        pane1.add(modificar);
        
        eliminar=new Boton("Eliminar",66,242,180,40,16);
        eliminar.setBackground(menta);
        pane1.add(eliminar);
        
        
        b=new Boton(null,217,72,30,30);
        b.setBackground(azul);
        b.setIcon(setIconoB("Resources\\buscar.png",b));
        pane1.add(b);
        
    }
    
    private void agregarLb()
    {
        foto=new Label(435,40,120,130);
        foto.setOpaque(true);
        foto.setIcon(setIcono("Resources\\agregar.png",foto));
        foto.setVisible(false);
        pane.add(foto);
        
        md=new Label(29,184,40,40);
        md.setBackground(menta);
        md.setIcon(setIcono("Resources\\md.png",md));
        md.setOpaque(true);
        pane1.add(md);
        
        del=new Label(29,242,40,40);
        del.setBackground(menta);
        del.setIcon(setIcono("Resources\\del.png",del));
        del.setOpaque(true);
        pane1.add(del);
        
        bb=new Label(440,130,120,120);
        bb.setIcon(setIcono("Resources\\b1.png",bb));
        pane.add(bb);
        
        txt=new Label(440,260,120,15);
        txt.setForeground(rosa);
        txt.setText("Nueva Busqueda");
        pane.add(txt);
        
        int y=-80, x=70;
        n=new Label("Nombre:",340+x,266+y,98,34);
        n.setVisible(false);
        pane.add(n);
        
        e=new Label("Edad:",340+x,306+y,98,34);
        e.setVisible(false);
        pane.add(e);
        
        s=new Label("Sexo",340+x,346+y,98,34);
        s.setVisible(false);
        pane.add(s);
        
        nt=new Label("NIT:",340+x,386+y,98,34);
        nt.setVisible(false);
        pane.add(nt);
        
        nombre=new Label("xxxxxxxxxx",420+x,266+y,250,34,true);
        nombre.setVisible(false);
        pane.add(nombre);
        
        edad=new Label("xxxxxxxxxx",420+x,306+y,250,34,true);
        edad.setVisible(false);
        pane.add(edad);
        
        sexo=new Label("xxxxxxxxxx",420+x,346+y,250,34,true);
        sexo.setVisible(false);
        pane.add(sexo);
        
        nt=new Label("xxxxxxxxxx",420+x,386+y,250,34,true);
        nt.setVisible(false);
        pane.add(nt);
    }
    
    private void agregarTxt()
    {
        buscar=new Texto(29,72,218,30);
        buscar.setText("Buscar");
        buscar.setBorder(null);
        buscar.setFont(new Font("Arial", Font.BOLD, 15));
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
    
    private Icon setIconoB(String path, JButton boton)
    {
        ImageIcon icon=new ImageIcon(path);
        int ancho=boton.getWidth();
        int alto=boton.getHeight();
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D linea=(Graphics2D)g;
        linea.setStroke(new BasicStroke(2.f));
        linea.setPaint(rosa);
        linea.drawRect(29, 135, 219, 0);
    }
}
