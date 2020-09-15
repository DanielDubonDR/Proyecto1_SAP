/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AdminVentas;

import GUI.AdminClientes.AdminClientes;
import GUI.AdminClientes.InfoCliente;
import GUI.Utilidades.Boton;
import GUI.Utilidades.Label;
import GUI.Utilidades.Panel;
import GUI.Utilidades.Texto;
import Principal.Controlador.Cliente;
import Principal.Funciones;
import static Principal.Proyecto1_SAP.clientes;
import static Principal.Proyecto1_SAP.contadorCl;
import static Principal.Proyecto1_SAP.contadorP;
import static Principal.Proyecto1_SAP.productos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Dubón
 */
public class AgregarVenta extends JFrame {
    Funciones fn=new Funciones();//en esta funcion se encuentra mi modificador de texto
    Panel pane=new Panel();//panel principal
    
    //Creacion de nuevos colores
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    Color gris=new Color(236, 240, 241);
    
    int y=-70;
    //hacer global los campos de texto
    private Texto Nombre=new Texto(38, 150+y, 313, 31);
    private Texto Edad=new Texto(38, 282+y, 313, 31);
    //private Texto Nit=new Texto(38, 346+y, 313, 31);
    private Panel panelTabla=new Panel();//panel principal
    private JComboBox combo=new JComboBox();
    private int cont;
    
    DefaultTableModel tb=new DefaultTableModel();
    JTable mytable=new JTable();
    
    public AgregarVenta()
    {
        setSize(390, 570);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Nueva Venta");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarpaneles();
        botones();
        textos();
        agregarLabel();
        tabla();
        cerrar();
    }
    
    private void agregarpaneles()
    {
        getContentPane().add(pane);
        pane.setBackground(azul);
    }
    
    private void botones()
    {
         
        Boton btnA=new Boton(fn.texto("Agregar", true,4),201,350+y,150,38);
        btnA.setBackground(azulp);
        btnA.setForeground(Color.WHITE);
        btnA.setBorderPainted(true);
        btnA.setBorder(null);
        pane.add(btnA);
        
        
        
        btnA.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tb.addRow(new Object[]{Nombre.getText(),Edad.getText()});
                if (cont>8)
                {
                panelTabla.setPreferredSize(new Dimension(295,145+((cont-8)*16)));
                }
                else
                {
                    panelTabla.setPreferredSize(new Dimension(295,145));
                }
                cont++;
                mytable.setModel(tb);
                mytable.repaint();
            }
        });
    }
    
    public void agregarLabel()
    {
        Label user=new Label(145,183+y,100,20);
        user.setText(fn.texto("NIT", true,3));
        pane.add(user);
        
        Label nombre=new Label(145,248+y,100,20);
        nombre.setText(fn.texto("Producto", true,3));
        pane.add(nombre);
        
        Label pass=new Label(145,315+y,100,20);
        pass.setText(fn.texto("Cantidad", true,3));
        pane.add(pass);
        
        Label passC=new Label(125,20,150,40);
        passC.setText(fn.texto("Nueva venta", true,5));
        pane.add(passC);
    }
    
    private void textos()
    {
        pane.add(Nombre);
        pane.add(Edad);
        combo.setBounds(38, 214+y, 313, 31);
//        for(int i=0;i<contadorP;i++)
//        {
//            combo.addItem(productos[i].getNombre());
//        }
        combo.setOpaque(false);
        combo.setBackground(azul);
        combo.setForeground(Color.WHITE);
        pane.add(combo);
        
        Label name=new Label(40,335,154,26);
        name.setText(fn.texto("Producto", true,3));
        name.setOpaque(true);
        name.setBackground(celeste);
        pane.add(name);
        
        Label ctn=new Label(195,335,157,26);
        ctn.setText(fn.texto("Cantidad", true,3));
        ctn.setOpaque(true);
        ctn.setBackground(celeste);
        pane.add(ctn);
    }
        
    public void cerrar()
    {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent a){
                MenuVentas abrir=new MenuVentas();
                abrir.setVisible(true);
            }
        });
    }
    
    public boolean verificarEspacios()
        {
            if(Nombre.getText().equals("")|Edad.getText().equals(""))
            {
                return true;
            }
            else return false;
        }
    
    public boolean buscar(int nit)
    {
        boolean aux=false;
        for(int i=0; i<contadorCl;i++)
        {
            if(nit==clientes[i].getNit())
            {
                aux= true;
                break;
            }
        }
        return aux;
    }
    
    public boolean verificarNumeros()
    {
        if(!Edad.getText().matches("[0-9]*$"))
        {
            return false;
        }
        else return true;
    }
    
    public void tabla()
    {
        //cont=6;
        JScrollPane scrol=new JScrollPane();
        scrol.setBounds(40, 360, 313, 150);
        panelTabla.setLayout(new BorderLayout());
        pane.add(scrol);
        scrol.setViewportView(panelTabla);
        panelTabla.setPreferredSize(new Dimension(295,145));
        tb.addColumn("Producto");
        tb.addColumn("Cantidad");
        mytable.setModel(tb);
        panelTabla.add(mytable);
    }
}
