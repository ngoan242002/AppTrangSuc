/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.models;

/**
 *
 * @author vipvl
 */
public class TaiKhoan {
    private String taiKhoan;
    private String pass;
    private String email;
    private int permission;

    public TaiKhoan(String taiKhoan, String pass, String email, int permission) {
        this.taiKhoan = taiKhoan;
        this.pass = pass;
        this.email = email;
        this.permission = permission;
    }

    public TaiKhoan() {
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
    
    
}
