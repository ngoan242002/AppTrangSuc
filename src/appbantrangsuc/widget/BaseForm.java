/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import appbantrangsuc.views.interfaces.FormListener;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author vipvl
 */
public abstract class BaseForm extends JFrame{
    
    protected FormListener listener;

    public BaseForm() throws HeadlessException {
    }

    public BaseForm(GraphicsConfiguration gc) {
        super(gc);
    }

    public BaseForm(String title) throws HeadlessException {
        super(title);
    }

    public BaseForm(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    public void setListener(FormListener listener) {
        this.listener = listener;
    }
    
    
    
}
