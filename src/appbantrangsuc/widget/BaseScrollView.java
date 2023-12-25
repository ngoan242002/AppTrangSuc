/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import appbantrangsuc.widget.interfaces.OnClickListener;
import appbantrangsuc.widget.interfaces.OnHoverListener;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;

/**
 *
 * @author vipvl
 */
public abstract class BaseScrollView extends JScrollPane implements MouseListener {

    private OnClickListener onClickListener;
    private OnHoverListener onHoverListener;

    public BaseScrollView(Component view, int vsbPolicy, int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);
        init();
    }

    public BaseScrollView(Component view) {
        super(view);
        init();
    }

    public BaseScrollView(int vsbPolicy, int hsbPolicy) {
        super(vsbPolicy, hsbPolicy);
        init();
    }

    public BaseScrollView() {
        init();
    }

    protected void init() {
        this.addMouseListener(this);
    }
    
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnHoverListener(OnHoverListener onHoverListener) {
        this.onHoverListener = onHoverListener;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (onClickListener != null && e.getButton() == MouseEvent.BUTTON1) {
            onClickListener.onClick(this);
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (onClickListener != null && e.getButton() == MouseEvent.BUTTON1) {
            onClickListener.onClick(this);
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        if (onHoverListener != null) {
            onHoverListener.onHover(this, true);
        }
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        if (onHoverListener != null) {
            onHoverListener.onHover(this, false);
        }
    }

}
