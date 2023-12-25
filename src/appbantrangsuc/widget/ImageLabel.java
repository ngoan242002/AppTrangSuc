/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author vipvl
 */
public class ImageLabel extends JLabel{

    public ImageLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        init();
    }

    public ImageLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        init();
    }

    public ImageLabel(String text) {
        super(text);
        init();
    }

    public ImageLabel() {
        init();
    }
    
    

    public ImageLabel(Icon icon, int i) {
        super(icon, i);
        init();
    }

    public ImageLabel(Icon icon) {
        super(icon);
        init();
    }
    
    @SuppressWarnings("UnusedAssignment")
    private void init() {
        
    }

    @Override
    public void setIcon(Icon i) {
        
        super.setIcon(i);
    }
    
    
    
}
