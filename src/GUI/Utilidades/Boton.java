
package GUI.Utilidades;


import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Daniel Dubón
 */
public class Boton extends JButton{
    public Boton(String texto, int x, int y, int ancho, int alto)
    {
        this.setText(texto);
        this.setBounds(x, y, ancho, alto);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFont(new Font("Arial", Font.PLAIN, 4));
    }
}
