
package Principal.Controlador;

import static Principal.Proyecto1_SAP.clientes;
import static Principal.Proyecto1_SAP.contadorCl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel Dubón
 */
public class Reporte {
    
    StringBuilder listClientes=new StringBuilder();
    
    public void reporteClientes()
    {
        Cliente[] edades=ordenarEdad(clientes);
        
        System.out.println(edades[0].getEdad());
        System.out.println(edades[1].getEdad());
        crearHeaderClientes();
        for(int i=contadorCl-1; i>=0;i--)
        {
            listClientes.append("<tr>");
            listClientes.append("<td>"+edades[i].getNombre()+"</td>");
            listClientes.append("<td>"+edades[i].getEdad()+"</td>");
            listClientes.append("<td>"+edades[i].getSexo()+"</td>");
            listClientes.append("<td>"+edades[i].getNit()+"</td>");
            listClientes.append("</tr>");
        }
        crearFinalClientes();
        crearArchivo(listClientes.toString(),"Reporte Clientes.html");
    }
    
    private Cliente[] ordenarEdad(Cliente[] clientes)
    {
        Cliente intercambio;
        for(int i=0; i<(contadorCl-1);i++)
        {
            for(int j=0; j<(contadorCl-1); j++)
            {
               if(clientes[j].getEdad()>clientes[j+1].getEdad())
               {
                   intercambio=clientes[j];
                   clientes[j]=clientes[j+1];
                   clientes[j+1]=intercambio;
               }
            }
        }
        return clientes;
    }
    
    public void crearArchivo(String contenido,String titulo){//este metodo me crea archivos planos
        
        File archivo = new File(titulo);
        
        try {
            FileWriter escritor = new FileWriter(archivo);//declaro mi variable que va a leer los datos
            escritor.write(contenido);
            escritor.close();
        } 
        catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    private void crearHeaderClientes()
    {
        listClientes.append("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<title>Reporte Clientes</title>\n" +
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
        "<body>\n" +
        "<div class=\"w3-container w3-deep-purple w3-margin-bottom w3-center\">\n" +
        "<h1>Reporte Clientes</h1>\n" +
        "<a href=\"Reporte Productos.html\"><span class=\"w3-left w3-xxlarge\">«</span></a>\n" +
        "<a href=\"Reporte Ventas.html\"><span class=\"w3-right w3-xxlarge\">»</span></a>\n" +
        "</div>\n" +
        "<div class=\"w3-container\">\n" +
        "<input class=\"w3-input w3-border w3-padding\" type=\"text\" placeholder=\"Buscar por NIT\" id=\"myInput\" onkeyup=\"myFunction()\">\n" +
        "<table class=\"w3-table-all w3-margin-top\" id=\"myTable\">\n" +
        "<tr>\n" +
        "<th style=\"width:35%;\">Nombre</th>\n" +
        "<th style=\"width:20%;\">Edad</th>\n" +
        "<th style=\"width:20%;\">Sexo</th>\n" +
        "<th style=\"width:25%;\">NIT</th>\n" +
        "</tr>");
    }
    
    private void crearFinalClientes()
    {
        listClientes.append("</table>\n" +"<br><br>\n" +"</div>\n" +"<script>\n" +
        "function myFunction() {\n" +
        "var input, filter, table, tr, td, i;\n" +
        "input = document.getElementById(\"myInput\");\n" +
        "filter = input.value.toUpperCase();\n" +
        "table = document.getElementById(\"myTable\");\n" +
        "tr = table.getElementsByTagName(\"tr\");\n" +
        "for (i = 0; i < tr.length; i++) {\n" +
        "td = tr[i].getElementsByTagName(\"td\")[3];\n" +
        "if (td) {\n" +
        "txtValue = td.textContent || td.innerText;\n" +
        "if (txtValue.toUpperCase().indexOf(filter) > -1) {\n" +
        "tr[i].style.display = \"\";\n" +
        "} else {\n" +
        "tr[i].style.display = \"none\";\n" +
        "}\n" +
        "}\n" +
        "}\n" +
        "}\n" +
        "</script>\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>");
    }
    
}

