/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.models;

import appbantrangsuc.widget.ImageLabel;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author vipvl
 */
public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private float giaSanPham;
    private Date ngayNhap;
    private String moTa;
    private String nhaSanXuat;
    private String fileImageUrl;

    public SanPham(int maSanPham, String tenSanPham, float giaSanPham, Date ngayNhap, String moTa, String nhaSanXuat, String fileImageUrl) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.ngayNhap = ngayNhap;
        this.moTa = moTa;
        this.nhaSanXuat = nhaSanXuat;
        this.fileImageUrl = fileImageUrl;
    }

    public SanPham() {
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(float giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getFileImageUrl() {
        return fileImageUrl;
    }

    public void setFileImageUrl(String fileImageUrl) {
        this.fileImageUrl = fileImageUrl;
    }
    
    public ImageLabel getImageLabel() {
        Icon icon = new ImageIcon(this.fileImageUrl);
        return new ImageLabel(icon);
    }
}
