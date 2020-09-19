
package Principal.Controlador.PDF;

import static Principal.Proyecto1_SAP.contadorP;
import static Principal.Proyecto1_SAP.contadorV;
import static Principal.Proyecto1_SAP.productos;
import static Principal.Proyecto1_SAP.ventas;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Daniel Dubón
 */
public class Factura {
    
    private int id;
    
    public Factura(int buscar)
    {
        buscarID(buscar);
    }
    
    public void pdf() throws IOException
    {
      PDDocument document = new PDDocument();
      PDPage blankPage = new PDPage();
      
      document.addPage(blankPage);
      PDImageXObject pdImage = PDImageXObject.createFromFile("Resources\\modelo.jpg",document);
      PDPageContentStream contents = new PDPageContentStream(document, blankPage);
      contents.drawImage(pdImage, 0, 20);
      
      contents.beginText(); 
      contents.setFont(PDType1Font.HELVETICA, 12);
      contents.newLineAtOffset(105, 615);
      String text = "HOLA DANIEL";
      contents.showText(text); 
      contents.endText();
      
      contents.beginText(); 
      contents.setFont(PDType1Font.HELVETICA, 12);
      contents.newLineAtOffset(105, 580);
      String text2 = "4856645";
      contents.showText(text2);
      contents.endText();
      
      int cont=0;
        for(int i=0; i<contadorV;i++)
        {
            if(id==ventas[i].getCodigo())
            {
                contents.beginText(); 
                contents.setFont(PDType1Font.HELVETICA, 13);
                contents.newLineAtOffset(35, 465+(cont));
                String text3 =String.valueOf(ventas[i].getCantidad());
                contents.showText(text3);
                contents.endText();
                
                contents.beginText(); 
                contents.setFont(PDType1Font.HELVETICA, 13);
                contents.newLineAtOffset(100, 465+(cont));
                String text4 =String.valueOf(id);
                contents.showText(text4);
                contents.endText();
                
                contents.beginText(); 
                contents.setFont(PDType1Font.HELVETICA, 13);
                contents.newLineAtOffset(145, 465+(cont));
                String text5 = String.valueOf(ventas[i].getNombreproducto());
                contents.showText(text5);
                contents.endText();
                
                contents.beginText(); 
                contents.setFont(PDType1Font.HELVETICA, 13);
                contents.newLineAtOffset(490, 465+cont);
                String text6 = "Q. "+String.valueOf(buscarPrecio(ventas[i].getNombreproducto())*ventas[i].getCantidad());
                contents.showText(text6);
                contents.endText();
                
                
                
                cont-=20;
            }
        }       
        
      
      
      contents.beginText(); 
      contents.setFont(PDType1Font.HELVETICA, 13);
      contents.newLineAtOffset(480, 58);
      String text7 = "Q. "+String.valueOf(obtenerTotal());
      contents.showText(text7);
      contents.endText();
      
      contents.beginText(); 
      contents.setFont(PDType1Font.HELVETICA, 13);
      contents.newLineAtOffset(270, 58);
      String text8 = "Q. "+String.valueOf(obtenerTotal()*0.12);
      contents.showText(text8);
      contents.endText();
      
      contents.beginText(); 
      contents.setFont(PDType1Font.HELVETICA, 10);
      contents.newLineAtOffset(415, 689);
      String text9 = "A quien le interesa";
      contents.showText(text9);
      contents.endText();
      
      contents.beginText(); 
      contents.setFont(PDType1Font.HELVETICA, 10);
      contents.newLineAtOffset(485, 713);
      String text11 = "A quien le interesa";
      contents.showText(text11);
      contents.endText();
      
      contents.close();
      
      document.save("Rrte.pdf");
      document.close();
    }
    
    public boolean buscarID(int ida)
    {
        boolean aux=false;
        for(int i=0; i<contadorV;i++)
        {
            if(ida==ventas[i].getCodigo())
            {
                aux= true;
                id=ventas[i].getCodigo();
                break;
            }
        }
        return aux;
    }
    
    private double obtenerTotal()
    {
        double total=0;
        for(int i=0; i<contadorP;i++)
        {
            if(id==ventas[i].getCodigo())
            {
                total+=buscarPrecio(ventas[i].getNombreproducto())*ventas[i].getCantidad();
            }
        }
        return total;
    }
    
    public double buscarPrecio(String nombre)
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
}
