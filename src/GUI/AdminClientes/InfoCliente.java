
package GUI.AdminClientes;

import GUI.Login;
import GUI.Registro;
import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import GUI.Utilidades.Texto;
import Principal.Controlador.Usuario;
import Principal.Funciones;
import static Principal.Proyecto1_SAP.contador;
import static Principal.Proyecto1_SAP.users;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Daniel Dubón
 */
public class InfoCliente extends JFrame {
    
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    
    //hacer global los campos de texto
    Texto User=new Texto(38, 120, 313, 31);
    Texto nombre=new Texto(38, 184, 313, 31);
    //Texto Pass=new Texto(38, 252, 313, 31);
    Texto PassC=new Texto(38, 316, 313, 31);
    
    JComboBox combo=new JComboBox();
    
    public InfoCliente()
    {
        setSize(388, 488);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Agregar Cliente");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        botones();
        textos();
        agregarLabel();
        close();
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
                
            }
        });
        
        btnA.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                String pass=String.valueOf(Pass.getPassword());
//                String passC=String.valueOf(PassC.getPassword());
////                System.out.println(User.getText()+" "+nombre.getText()+" "+pass);
//                if(verificarEspacios(pass,passC))
//                {
//                    JOptionPane.showMessageDialog(null,"Llene todos los campos");
//                }
//                else
//                {
//                    if(verificarPass(pass,passC))
//                    {
//                        Usuario useraux=new Usuario(User.getText(),nombre.getText(),pass);
//                        if(contador<10)
//                        {
//                                if(buscar(User.getText()))
//                                {
//                                    JOptionPane.showMessageDialog(null,"Ya existe un usuario con el mismo nombre");
//                                }
//                                else
//                                {
//                                    users[contador]=useraux;
//                                    JOptionPane.showMessageDialog(null,"Se ha registrado correctamente");
//                                    contador++;
//                                }
//                        }
//                        else
//                        {
//                            JOptionPane.showMessageDialog(null,"Ha llegado al limite de usuarios");
//                        }
//                    }
//                    else
//                    {
//                        JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
//                    }
//                }
            }
        });
    }
    
    public void agregarLabel()
    {
        Label user=new Label(145,153,100,20);
        user.setText(fn.texto("Nombre", true,3));
        pane.add(user);
        
        Label nombre=new Label(145,218,100,20);
        nombre.setText(fn.texto("Edad", true,3));
        pane.add(nombre);
        
        Label pass=new Label(145,285,100,20);
        pass.setText(fn.texto("Sexo", true,3));
        pane.add(pass);
        
        Label passC=new Label(125,349,150,20);
        passC.setText(fn.texto("NIT", true,3));
        pane.add(passC);
    }
    
    private void textos()
    {
        pane.add(User);
        pane.add(nombre);
        combo.setBounds(38, 252, 313, 31);
        combo.addItem("M");
        combo.addItem("F");
        combo.setOpaque(false);
        combo.setBackground(azul);
        combo.setForeground(Color.WHITE);
        pane.add(combo);
        pane.add(PassC);
    }
        
    public void close()
    {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent a){
                
            }
        });
    }
    
//    public boolean verificarEspacios(String pass, String passC)
//        {
//            if(User.getText().equals("")||nombre.getText().equals("")||pass.equals("")||passC.equals(""))
//            {
//                return true;
//            }
//            else return false;
//        }
    
//    public boolean verificarPass(String pass, String passC)
//        {
//            if(passC.equals(pass))
//            {
//                return true;
//            }
//            else return false;
//        }
    
//    public boolean buscar(String user)
//    {
//        boolean aux=false;
//        for(int i=0; i<contador;i++)
//        {
//            if(user.equals(users[i].getUsuario()))
//            {
//                aux= true;
//                break;
//            }
//        }
//        return aux;
//    }
    
}
