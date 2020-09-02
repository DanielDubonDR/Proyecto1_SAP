
package GUI;

import GUI.Utilidades.Boton;
import GUI.Utilidades.Panel;
import GUI.Utilidades.Texto;
import Principal.Funciones;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Daniel Dubón
 */
public class Login extends JFrame {
    
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    
    public Login()
    {
        setSize(388, 488);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Login");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        botones();
        textos();
    }
    
    private void agregarpaneles()
    {
        getContentPane().add(pane);
        pane.setBackground(azul);
    }
    
    private void botones()
    {
        Boton btnlogin=new Boton(fn.texto("INGRESAR", true,4),56,36,128,34);
        btnlogin.setBackground(azul);
        btnlogin.setForeground(Color.WHITE);
        pane.add(btnlogin);
        
        Boton btnR=new Boton(fn.texto("REGISTRAR", true,4),201,36,128,34);
        btnR.setBackground(azul);
        btnR.setForeground(Color.WHITE);
        pane.add(btnR);
        
        Boton btnA=new Boton(fn.texto("INICIAR SESION", true,4),62,406,264,44);
        btnA.setBackground(azul);
        btnA.setForeground(Color.WHITE);
        btnA.setBorderPainted(true);
        pane.add(btnA);
    }
    
    private void textos()
    {
        Texto User=new Texto(42, 263, 305, 35);
        User.setText("Usuario");
        pane.add(User);
        
//        Texto Pass=new Texto(42, 263, 305, 35);
//        Pass.setText("Contraseña");
//        pane.add(Pass);
        
        JPasswordField Pass=new JPasswordField();
        Pass.setBounds(42, 330, 305, 35);
        Pass.setOpaque(false);
        Pass.setForeground(Color.white);
        Pass.setHorizontalAlignment(CENTER);
        Pass.setText("Contraseña");
        Pass.setEchoChar((char)0);
        pane.add(Pass);
        
        User.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                User.setText("");
            }
        });
        
        Pass.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent a)
            {
                Pass.setText("");
                Pass.setEchoChar('•');
            }
        });
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
