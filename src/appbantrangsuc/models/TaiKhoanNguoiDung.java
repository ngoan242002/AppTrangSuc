/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.models;

/**
 *
 * @author vipvl
 */
public class TaiKhoanNguoiDung extends TaiKhoan{
    
    private static TaiKhoanNguoiDung instance;

    private TaiKhoanNguoiDung() {
    }

    private TaiKhoanNguoiDung(String taiKhoan, String pass, String email, int permission) {
        super(taiKhoan, pass, email, permission);
    }

    public static TaiKhoanNguoiDung getInstance() {
        if (instance == null) {
            instance = new TaiKhoanNguoiDung();
        }
        return instance;
    }
    
    
    public static TaiKhoanNguoiDung getInstance(String taiKhoan, String pass, String email, int permission) {
        if (instance == null) {
            instance = new TaiKhoanNguoiDung(taiKhoan, pass, email, permission);
        }
        return instance;
    }
    
    public static TaiKhoanNguoiDung getInstance(TaiKhoan taiKhoan) {
        if (instance == null) {
            instance = new TaiKhoanNguoiDung(
                    taiKhoan.getTaiKhoan(),
                    taiKhoan.getPass(),
                    taiKhoan.getEmail(),
                    taiKhoan.getPermission()
            );
        }
        return instance;
    }
    
    public void distroy() {
        instance = null;
    }
}
