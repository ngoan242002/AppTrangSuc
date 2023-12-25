/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import appbantrangsuc.views.MyItemView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author vipvl
 */
public class AdapterPanel extends BaseView {

    public int spanCount = 1;
    private final List<JComponent> list = new ArrayList<>();

    public AdapterPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public AdapterPanel(LayoutManager layout) {
        super(layout);
    }

    public AdapterPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public AdapterPanel() {
    }

    @Override
    protected void init() {
        super.init();
        setBackground(new Color(0,0,0,0));
    }

    private void reloadView() {
        this.removeAll();
        init();
        if (list.size() <= 0) {
            revalidate();
            return;
        }
        this.setPreferredSize(new Dimension(this.getPreferredSize().width, (1 + (list.size()) / spanCount) * list.get(0).getPreferredSize().height));
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < getCount()) {

            list.get(i).setLocation(j * list.get(i).getPreferredSize().width, k * list.get(i).getPreferredSize().height);
            
            this.add(list.get(i));
            i++;
            j++;
            if (j >= spanCount - 1) {
                j = 0;
                k++;
            }
        }
        revalidate();
    }

    public void updateList(List<MyItemView> l) {
        this.list.clear();
        this.list.addAll(l);
        reloadView();
    }
    
    public List<JComponent> getList() {
        return list;
    }

    
    public int getCount() {
        return list.size();
    }

}
