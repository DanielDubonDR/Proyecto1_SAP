
package GUI;

import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import Principal.Funciones;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Daniel Dubón
 */
public class Menu extends JFrame {
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    Panel pane1=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    
    public Menu()
    {
        setSize(800, 436);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Registro");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        textos();
//        botones();
//        cerrar();
    }
    
    private void agregarpaneles()
    {
        getContentPane().add(pane);
        pane.setBackground(Color.WHITE);
        pane1.setBounds(0, 0, 800, 150);
        pane1.setBackground(azul);
        pane.add(pane1);
    }
    
    private void textos()
    {
        int x=-10, y=-5;
        Label lb1=new Label(76+x,18+y,80,54);
        lb1.setText(fn.texto("SAS", true,6));
        pane1.add(lb1);
        
        Label lb2=new Label(88+x,72+y,90,30);
        lb2.setText(fn.texto("Bienvenido", true,4));
        pane1.add(lb2);
        
        Label lb3=new Label(70+x,92+y,310,49);
        lb3.setText(fn.texto("Daniel Dubón", true,8));
        pane1.add(lb3);
        
        JLabel s0=new JLabel();
        s0.setBounds(15, 12, 55, 55);
        ImageIcon im= new ImageIcon("Resources\\inicio.png");
        Icon scale=new ImageIcon(im.getImage().getScaledInstance(s0.getWidth(), s0.getHeight(), Image.SCALE_DEFAULT));
        s0.setIcon(scale);
        pane1.add(s0);
    }
}
