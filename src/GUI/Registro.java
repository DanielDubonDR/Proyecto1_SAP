
package GUI;

import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import GUI.Utilidades.Texto;
import Principal.Funciones;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Daniel Dubón
 */
public class Registro extends JFrame{
    
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    
    public Registro()
    {
        setSize(388, 488);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Registro");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        botones();
        textos();
        agregarLabel();
        cerrar();
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
        
        Boton btnA=new Boton(fn.texto("REGISTRARSE", true,4),62,386,264,44);
        btnA.setBackground(azulp);
        btnA.setForeground(Color.WHITE);
        btnA.setBorderPainted(true);
        btnA.setBorder(null);
        pane.add(btnA);
        
        btnlogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Login abrir=new Login();
                abrir.setVisible(true);
                Registro.this.dispose();
            }
        });
    }
    
    public void agregarLabel()
    {
        Label user=new Label(145,153,100,20);
        user.setText(fn.texto("Usuario", true,3));
        pane.add(user);
        
        Label nombre=new Label(145,218,100,20);
        nombre.setText(fn.texto("Nombre", true,3));
        pane.add(nombre);
        
        Label pass=new Label(145,285,100,20);
        pass.setText(fn.texto("Contraseña", true,3));
        pane.add(pass);
        
        Label passC=new Label(125,349,150,20);
        passC.setText(fn.texto("Confirmar contraseña", true,3));
        pane.add(passC);
    }
    
    private void textos()
    {
        Texto User=new Texto(38, 120, 313, 31);
        pane.add(User);
        
        Texto nombre=new Texto(38, 184, 313, 31);
        pane.add(nombre);
        
        JPasswordField Pass=new JPasswordField();
        Pass.setBounds(38, 252, 313, 31);
        Pass.setOpaque(false);
        Pass.setForeground(Color.white);
        Pass.setHorizontalAlignment(CENTER);
        pane.add(Pass);
        
        JPasswordField PassC=new JPasswordField();
        PassC.setBounds(38, 316, 313, 31);
        PassC.setOpaque(false);
        PassC.setForeground(Color.white);
        PassC.setHorizontalAlignment(CENTER);
        pane.add(PassC);
          
    }
    
    
    public void paint(Graphics g){
        super.paint(g);        
        Graphics2D linea1=(Graphics2D)g;
        linea1.setStroke(new BasicStroke(2.f));
        linea1.setPaint(menta);
        linea1.drawRect(204, 98, 128, 0);     
    }
    
    public void cerrar()
    {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                Login abrir=new Login();
                abrir.setVisible(true);
            }
        });
    }
    
}
