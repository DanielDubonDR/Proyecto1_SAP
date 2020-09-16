
package EstructuraDatos;

import Principal.Controlador.VentaAgrupada;
import static Principal.Proyecto1_SAP.*;


/**
 *
 * @author Daniel Dubón
 */
public class AlgoritmosVentas {
    int []ids=new int[100];
    int contids=0;
    
    public void getIds()
    {
        for(int i=1; i<1000;i++)
        {
            for(int j=0;j<contadorV;j++)
            {
                if(ventas[j].getCodigo()==i)
                {
                    ids[contids]=i;
                    contids++;
                    break;
                }
            }
        }
        
        for(int i=0; i<contids;i++)
        {
            System.out.print(ids[i]+" ");
        }
    }
    
    public void agrupar()
    {
        for(int i=0; i<contids;i++)
        {
            double total=0;
            for(int j=0;j<contadorV;j++)
            {
                if(ventas[j].getCodigo()==ids[i])
                {
                    total+=buscarPrecio(ventas[j].getNombreproducto())*ventas[j].getCantidad();
                }
            }
            VentaAgrupada a = new VentaAgrupada(ids[i],buscarCliente(ids[i]),total);
            ventasAgrupadas[contVA]=a;
            contVA++;
        }
    }
    
    public float buscarPrecio(String nombre)
    {
        int id=0;
        for(int i=0; i<contadorP;i++)
        {
            if(nombre.equalsIgnoreCase(productos[i].getNombre().trim()))
            {
                id=i;
                break;
            }
        }
        return productos[id].getPrecio();
    }
    
    public int buscarCliente(int id)
    {
        int aux=0;
        for(int i=0; i<contadorV;i++)
        {
            if(ventas[i].getCodigo()==id)
            {
                aux=i;
                break;
            }
        }
        return ventas[aux].getNit();
    }
    
    public double error(double numero)//este metodo me quita los errores decimales que se generan
    {
        double resultado;
        resultado=numero*Math.pow(100,100);
        resultado=Math.round(resultado);
        resultado=resultado/Math.pow(100,100);
        return resultado;
    }
    
    public void controlador()
    {
        getIds();
        agrupar();
        System.out.println(ventasAgrupadas[0]);
        System.out.println(ventasAgrupadas[3]);
    }
}
