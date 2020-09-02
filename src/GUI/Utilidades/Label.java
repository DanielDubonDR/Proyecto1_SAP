
package GUI.Utilidades;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Daniel Dubón
 */
public class Label extends JLabel {
    
    public Label(int x, int y, int w, int h)
    {
        this.setBounds(x, y, w, h);
        this.setForeground(Color.white);
        this.setHorizontalAlignment(CENTER);
        this.setFont(new Font("Verdana", Font.PLAIN, 13));
    }
}
