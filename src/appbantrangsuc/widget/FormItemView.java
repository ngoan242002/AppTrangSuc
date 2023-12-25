/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.widget;

import appbantrangsuc.models.SanPham;
import appbantrangsuc.utils.AppUtils;
import appbantrangsuc.widget.interfaces.OnClickListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author vipvl
 */
public class FormItemView extends ItemView {

    private SanPham sanPham;
    private ImageLabel imageLabel;
    private CustomPanel imgPanel;
    private JLabel tenSp;
    private JLabel giaSp;
    private JButton deleteButton;
    private boolean isShowDelete = true;
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
    
    

    public FormItemView(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public FormItemView(LayoutManager layout) {
        super(layout);
    }

    public FormItemView(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public FormItemView() {
    }

    @Override
    protected void init() {
        super.init();
        this.setPreferredSize(new Dimension(200, 300));
        this.setBackground(Color.WHITE);
        this.setBorder(new BorderUIResource.EmptyBorderUIResource(2, 2, 2, 2));
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(Component view) {
                if (sanPham != null) {
                    if (onItemClick != null) {
                        onItemClick.onClick(view);
                    }
                }
            }
        });
        
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
        initDelete();
        initImage();
        initLabel();
    }

    private void initImage() {
        int imgPNW = (getPreferredSize().width - 20);
        int imgPNH = (getPreferredSize().height * 2 / 3) - 20;
        imgPanel = new CustomPanel();
        imgPanel.setPreferredSize(new Dimension(imgPNW, imgPNH));
        imgPanel.setLocation(10, 50);
        imageLabel = new ImageLabel();
        imageLabel.setIcon(AppUtils.resizeIcon(this.sanPham.getImageLabel().getIcon(), imgPanel));
        int iconW = imageLabel.getIcon().getIconWidth();
        int iconH = imageLabel.getIcon().getIconHeight();
       
        imageLabel.setPreferredSize(new Dimension(iconW, iconH));
        imageLabel.setLocation(imgPNW / 2 - iconW / 2, imgPNH / 2 - iconH / 2);
        imgPanel.add(imageLabel);
        this.add(imgPanel);
    }

    private void initLabel() {
        tenSp = new JLabel();
        tenSp.setText(sanPham.getTenSanPham());
        tenSp.setPreferredSize(new Dimension(imageLabel.getPreferredSize().width, 20));
        tenSp.setLocation(10, imageLabel.getY() + imageLabel.getPreferredSize().height + 30);
        tenSp.setFont(new java.awt.Font("Monospaced", 0, 14));
        this.add(tenSp);

        giaSp = new JLabel();
        giaSp.setText(String.format("Price: %.2f", sanPham.getGiaSanPham()));
        giaSp.setPreferredSize(new Dimension(tenSp.getPreferredSize().width, 20));
        giaSp.setLocation(10, tenSp.getY() + tenSp.getHeight() + 30);
        giaSp.setFont(new java.awt.Font("Monospaced", 0, 14));
        this.add(giaSp);
    }

    private void initDelete() {
        deleteButton = new JButton();
        deleteButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteButton.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setBorderPainted(false);
        deleteButton.setText("Delete");
        deleteButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            onItemClick.onDelete(deleteButton);
        });
        deleteButton.setLocation(200 - 80, 260);
        deleteButton.setPreferredSize(new Dimension(80, 30));
        deleteButton.setAlignmentX(CENTER_ALIGNMENT);
        deleteButton.setAlignmentY(CENTER_ALIGNMENT);
        this.add(deleteButton);
        deleteButton.setVisible(isShowDelete);
    }

    public void setIsShowDelete(boolean isShowDelete) {
        this.isShowDelete = isShowDelete;
        deleteButton.setVisible(isShowDelete);
    }
    
    
    
    public interface OnItemClick{
        void onClick(Component view);
        void onDelete(Component view);
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    
    
}
