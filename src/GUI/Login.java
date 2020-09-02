
package GUI;

import GUI.Utilidades.Boton;
import GUI.Utilidades.Panel;
import Principal.Funciones;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author Daniel Dubón
 */
public class Login extends JFrame {
    
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    Panel pane1=new Panel();//panel que encierra solo bnt ingresar registrar
    Panel pane2=new Panel();//panel que encierra cuerpo de ingresar
    Panel pane3=new Panel();//panel que encierra cuerpo registrar
    
    //Creacion de nuevos colores
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    
    public Login()
    {
        setSize(/*388*/450, 488);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Login");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        botones();
        pane1.setVisible(true);
    }
    
    private void agregarpaneles()
    {
        getContentPane().add(pane);
        pane.setBackground(azul);
        pane1.setBackground(azulp);
        pane1.setBounds(0, 0, 381, 75);
        pane2.setBackground(azulp);
        pane2.setBounds(0, 75, 381, 413);
        pane.add(pane1);
        pane.add(pane2);
    }
    
    private void botones()
    {
        Boton btnlogin=new Boton(fn.texto("INGRESAR", true,4),56,36,128,34);
        btnlogin.setBackground(azul);
        btnlogin.setForeground(Color.WHITE);
        pane1.add(btnlogin);
        
        Boton btnR=new Boton(fn.texto("REGISTRAR", true,4),201,36,128,34);
        btnR.setBackground(azul);
        btnR.setForeground(Color.WHITE);
        pane1.add(btnR);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        //pane1.paint(g);
        Graphics2D linea=(Graphics2D)g;
        linea.setStroke(new BasicStroke(2.f));
        linea.setPaint(menta);
        linea.drawRect(59, 98, 128, 0);
        
        Graphics2D linea1=(Graphics2D)g;
        linea1.setStroke(new BasicStroke(2.f));
        linea1.setPaint(rosa);
        linea1.drawRect(204, 98, 128, 0);
        
    }
}
