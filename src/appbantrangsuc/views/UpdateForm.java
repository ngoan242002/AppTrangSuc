/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package appbantrangsuc.views;

import appbantrangsuc.controller.SanPhamController;
import appbantrangsuc.models.SanPham;
import appbantrangsuc.widget.BaseForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author vipvl
 */
public class UpdateForm extends BaseForm {

    /**
     * Creates new form AddForm
     */
    private final SanPham sanPham;

    public UpdateForm(SanPham sanPham) {
        this.sanPham = sanPham;
        initComponents();
        initView();
        warningText.setVisible(false);
        fieldPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                //warn();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (fieldPrice.getText().isEmpty()) {
                    fieldPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                    warningText.setVisible(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {

                try {
                    float x = Float.parseFloat(fieldPrice.getText());
                    fieldPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                    warningText.setVisible(false);
                } catch (NumberFormatException ex) {
                    fieldPrice.setBorder(new BasicBorders.FieldBorder(Color.BLACK, Color.BLACK, Color.RED, Color.RED));
                    warningText.setVisible(true);
                }
            }

        });
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imagePath = new javax.swing.JTextField();
        browserBtn = new javax.swing.JButton();
        fielName = new javax.swing.JTextField();
        fieldPrice = new javax.swing.JTextField();
        motaField = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        addBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        dateTimeSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        fieldProducer = new javax.swing.JTextField();
        warningText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setText("Import Image");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel2.setText("Details");

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setText("Jewelry Name");

        imagePath.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        imagePath.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        imagePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagePathActionPerformed(evt);
            }
        });

        browserBtn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        browserBtn.setText("Browser");
        browserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBrowerClick(evt);
            }
        });

        fielName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        fielName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldPrice.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        fieldPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        textArea.setColumns(20);
        textArea.setRows(5);
        motaField.setViewportView(textArea);

        addBtn.setBackground(new java.awt.Color(51, 255, 0));
        addBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        addBtn.setText("Update");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAddClick(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel5.setText("Date Import");

        dateTimeSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1679222967152L), null, null, java.util.Calendar.DAY_OF_MONTH));

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel6.setText("Producer");

        fieldProducer.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        fieldProducer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        warningText.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        warningText.setForeground(new java.awt.Color(255, 0, 0));
        warningText.setText("Input must is number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldProducer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateTimeSpinner))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(motaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fielName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warningText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldPrice))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(browserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fielName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldProducer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(motaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagePathActionPerformed

    private void onBrowerClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBrowerClick
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.imagePath.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_onBrowerClick

    private void onAddClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAddClick
        // TODO add your handling code here:
        
        SanPham newSp = new SanPham(
                0,
                this.fielName.getText().trim(),
                Float.parseFloat(this.fieldPrice.getText().trim()),
                (Date) this.dateTimeSpinner.getValue(),
                textArea.getText(),
                this.fieldProducer.getText(),
                this.imagePath.getText().trim()
        );
        if (this.listener != null) {
            listener.onFormResult(this, sanPham, newSp);
        }
    }//GEN-LAST:event_onAddClick

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton browserBtn;
    private javax.swing.JSpinner dateTimeSpinner;
    private javax.swing.JTextField fielName;
    private javax.swing.JTextField fieldPrice;
    private javax.swing.JTextField fieldProducer;
    private javax.swing.JTextField imagePath;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane motaField;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel warningText;
    // End of variables declaration//GEN-END:variables

    private void initView() {
        this.imagePath.setText(this.sanPham.getFileImageUrl());
        this.fielName.setText(this.sanPham.getTenSanPham());
        this.fieldPrice.setText(this.sanPham.getGiaSanPham() + "");
        this.dateTimeSpinner.setValue(this.sanPham.getNgayNhap());
        this.fieldProducer.setText(this.sanPham.getNhaSanXuat());
        this.textArea.setText(this.sanPham.getMoTa());
    }

}