/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package appbantrangsuc.views;

import appbantrangsuc.AppBanTrangSuc;
import appbantrangsuc.models.SanPham;
import appbantrangsuc.utils.AppUtils;
import appbantrangsuc.widget.ItemView;
import appbantrangsuc.widget.interfaces.OnClickListener;
import java.awt.Component;

/**
 *
 * @author vipvl
 */
public class MyItemView extends ItemView {

    /**
     * Creates new form MyItemView
     */
    private SanPham sanPham;
    private OnItemClick onItemClick;
    
    public MyItemView(SanPham sanPham, OnItemClick onItemClick) {
        this.sanPham = sanPham;
        this.onItemClick = onItemClick;
        initComponents();
        this.udpateBtn.setVisible(AppBanTrangSuc.isAdmin);
        this.deleteBtn.setVisible(AppBanTrangSuc.isAdmin);
        this.imgLabel.setIcon(AppUtils.resizeIcon(this.sanPham.getImageLabel().getIcon(), this.imgPanel));
        
        this.tenSp.setText(this.sanPham.getTenSanPham());
        this.giaSp.setText(String.format("Gia: %.2f", this.sanPham.getGiaSanPham()));
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(Component view) {
                onItemClick.onClick(MyItemView.this);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgPanel = new appbantrangsuc.widget.CustomPanel();
        imgLabel = new appbantrangsuc.widget.ImageLabel();
        tenSp = new javax.swing.JLabel();
        giaSp = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        udpateBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 153));

        imgPanel.setPreferredSize(new java.awt.Dimension(188, 188));

        imgLabel.setAlignmentY(0.0F);
        imgLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout imgPanelLayout = new javax.swing.GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        imgPanelLayout.setVerticalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        tenSp.setFont(new java.awt.Font("Monospaced", 1, 11)); // NOI18N
        tenSp.setText("Ten San Pham");
        tenSp.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        giaSp.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        giaSp.setText("Gia");
        giaSp.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        deleteBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteBtn.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Xóa");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onDeleteClick(evt);
            }
        });

        udpateBtn.setBackground(new java.awt.Color(0, 255, 0));
        udpateBtn.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        udpateBtn.setText("Cập Nhật");
        udpateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onUpdateClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giaSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(udpateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(tenSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(giaSp, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteBtn)
                    .addComponent(udpateBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void onDeleteClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onDeleteClick
        // TODO add your handling code here:
        this.onItemClick.onDelete(this);
    }//GEN-LAST:event_onDeleteClick

    private void onUpdateClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onUpdateClick
        // TODO add your handling code here:
        this.onItemClick.onUpdate(this);
    }//GEN-LAST:event_onUpdateClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel giaSp;
    private appbantrangsuc.widget.ImageLabel imgLabel;
    private appbantrangsuc.widget.CustomPanel imgPanel;
    private javax.swing.JLabel tenSp;
    private javax.swing.JButton udpateBtn;
    // End of variables declaration//GEN-END:variables
    public interface OnItemClick {

        void onClick(Component view);

        void onDelete(Component view);

        void onUpdate(Component view);
    }

    
}
