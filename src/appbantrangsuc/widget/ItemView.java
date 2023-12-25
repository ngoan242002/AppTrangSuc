/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import java.awt.LayoutManager;

/**
 *
 * @author vipvl
 */
public abstract class ItemView extends BaseView{

    
    public ItemView(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ItemView(LayoutManager layout) {
        super(layout);
    }

    public ItemView(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public ItemView() {
    }

    @Override
    protected void init() {
        super.init();
    }

    
}
