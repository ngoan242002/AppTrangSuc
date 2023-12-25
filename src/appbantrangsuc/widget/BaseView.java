/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import appbantrangsuc.widget.interfaces.OnClickListener;
import appbantrangsuc.widget.interfaces.OnHoverListener;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author vipvl
 */
public abstract class BaseView extends JPanel implements MouseListener{

    private OnClickListener onClickListener;
    private OnHoverListener onHoverListener;
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BaseView(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        init();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BaseView(LayoutManager layout) {
        super(layout);
        init();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BaseView(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        init();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BaseView() {
        init();
    }
    
    protected void init() {
        this.setFocusable(true);
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
        if (onHoverListener != null ) {
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
