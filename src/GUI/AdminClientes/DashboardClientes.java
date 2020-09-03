
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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static Principal.Proyecto1_SAP.clientes;
import static Principal.Proyecto1_SAP.contadorCl;

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
        scrol.setBounds(0, 126, 790, 165);
        panelTabla.setLayout(new BorderLayout());
        pane.add(scrol);
        scrol.setViewportView(panelTabla);
        panelTabla.setPreferredSize(new Dimension(750,162+((contadorCl-10)*16)));
    }
    
    private void etiquetas()
    {
        int y=100, x=0;
        if(contadorCl>10)
        {
            x=-4;
        }
        Label nombre=new Label(0,y,197+x,26);
        nombre.setText(fn.texto("Nombre", true,3));
        nombre.setOpaque(true);
        nombre.setBackground(celeste);
        pane.add(nombre);
        
        Label edad=new Label(198+x,y,196+x,26);
        edad.setText(fn.texto("Edad", true,3));
        edad.setOpaque(true);
        edad.setBackground(celeste);
        pane.add(edad);
        
        Label sexo=new Label(395+(x*2),y,196+(x),26);
        sexo.setText(fn.texto("Sexo", true,3));
        sexo.setOpaque(true);
        sexo.setBackground(celeste);
        pane.add(sexo);
        
        Label nit=new Label(592+(x*3),y,196,26);
        nit.setText(fn.texto("NIT", true,3));
        nit.setOpaque(true);
        nit.setBackground(celeste);
        pane.add(nit);
        
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
    Object[][] filas=new Object[contadorCl][contadorCl];
    private void agregarTabla()
    {
        String[] nombreC={"Nombre","Edad","Sexo","NIT"};
        
        for(int i=0; i<contadorCl;i++)
        {
            if(clientes[i] !=null)
            {
                filas[i][0]=clientes[i].getNombre();
                filas[i][1]=clientes[i].getEdad();
                filas[i][2]=clientes[i].getSexo();
                filas[i][3]=clientes[i].getNit();
            }
        }
        
        tabla=new JTable(filas,nombreC);
        tabla.repaint();
        panelTabla.add(tabla);
    }
}
