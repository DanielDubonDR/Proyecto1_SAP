
package GUI.AdminVentas;

import EstructuraDatos.AlgoritmosVentas;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import Principal.Funciones;
import static Principal.Proyecto1_SAP.contVA;
import static Principal.Proyecto1_SAP.contadorP;
import static Principal.Proyecto1_SAP.productos;
import static Principal.Proyecto1_SAP.ventasAgrupadas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
public class DashboardVentas extends JFrame{
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    Panel pane1=new Panel();//panel de barra
    Panel panelTabla=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color azul=new Color(36, 49, 60);
    Color gris=new Color(236, 240, 241);
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    
    private JTable tabla;
    
    
    public DashboardVentas()
    {
        AlgoritmosVentas a=new AlgoritmosVentas();
        a.controlador();
        setSize(820, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Dashboard Ventas");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        etiquetas();
        agregarTabla();
        cerrar();
    }
    
    private void agregarpaneles()
    {
        //panel principal
        getContentPane().add(pane);
        
        //panel dash
        pane.setBackground(Color.WHITE);
        pane1.setBounds(0, 0, 810, 85);
        pane1.setBackground(azul);
        pane.add(pane1);
        
        //tabla
        JScrollPane scrol=new JScrollPane();
        scrol.setBounds(10, 126, 790, 165);
        panelTabla.setLayout(new BorderLayout());
        pane.add(scrol);
        scrol.setViewportView(panelTabla);
        panelTabla.setPreferredSize(new Dimension(750,162+((contVA-10)*16)));
    }
    
    private void etiquetas()
    {
        int y=100, x=65;
        if(contVA>10)
        {
            x=61;
        }
        Label nombre=new Label(10,y,197+x,26);
        nombre.setText(fn.texto("Codigo Venta", true,3));
        nombre.setOpaque(true);
        nombre.setBackground(celeste);
        pane.add(nombre);
        
        Label edad=new Label(208+x,y,196+x,26);
        edad.setText(fn.texto("NIT Cliente", true,3));
        edad.setOpaque(true);
        edad.setBackground(celeste);
        pane.add(edad);
        
        Label sexo=new Label(405+(x*2),y,198+(x),26);
        sexo.setText(fn.texto("Total", true,3));
        sexo.setOpaque(true);
        sexo.setBackground(celeste);
        pane.add(sexo);
        
        
        Label lb3=new Label(77,12,800,60);
        lb3.setText(fn.texto("Dashboard Ventas", true,6));
        lb3.setHorizontalAlignment(LEFT);
        pane1.add(lb3);
        
        JLabel s0=new JLabel();
        s0.setBounds(15, 12, 55, 55);
        ImageIcon im= new ImageIcon("Resources\\clientesr.png");
        Icon scale=new ImageIcon(im.getImage().getScaledInstance(s0.getWidth(), s0.getHeight(), Image.SCALE_DEFAULT));
        s0.setIcon(scale);
        pane1.add(s0);
    }
    
    Object[][] filas=new Object[contadorP][3];
    
    private void agregarTabla()
    {
        String[] nombreC={"Codigo Venta","NIT Cliente","Total"};
        
        for(int i=0; i<contVA;i++)
        {
            if(ventasAgrupadas[i] !=null)
            {
                filas[i][0]=ventasAgrupadas[i].getCodigo();
                filas[i][1]=ventasAgrupadas[i].getNit();
                filas[i][2]=ventasAgrupadas[i].getTotal();
            }
        }
        
        tabla=new JTable(filas,nombreC);
        tabla.repaint();
        panelTabla.add(tabla);
    }
    
    public void cerrar()
    {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent a){
                contVA=0;
            }
        });
    }
    
}
