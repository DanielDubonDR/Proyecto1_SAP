
package EstructuraDatos;

import static Principal.Proyecto1_SAP.contadorV;
import static Principal.Proyecto1_SAP.ventas;

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
    }
}
