/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.controller;

import appbantrangsuc.Const;
import appbantrangsuc.models.SanPham;
import appbantrangsuc.models.TaiKhoan;
import appbantrangsuc.utils.ConnectionUtils;
import appbantrangsuc.views.ViewResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vipvl
 */
public class TaiKhoanController {
    
    private final ViewResult viewResult;

    public TaiKhoanController(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    
    public void login(TaiKhoan taiKhoan) {
        List<TaiKhoan> list = new ArrayList<>();
        String query = String.format("select * from TaiKhoan where TaiKhoan = '%s' and MatKhau = '%s';", taiKhoan.getTaiKhoan(), taiKhoan.getPass());
        try {
            Connection connection = ConnectionUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(new TaiKhoan(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)));
            }
            viewResult.onViewResultSuccess(Const.ACCOUNT_QUERY_ALL, list);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            viewResult.onViewResultFailed(ex.getMessage());
        }
    }
    
    public void signup(TaiKhoan taiKhoan) {
        String query = String.format("insert into TaiKhoan values ('%s', '%s', '%s', '%d');", taiKhoan.getTaiKhoan(), taiKhoan.getPass(), taiKhoan.getEmail(), taiKhoan.getPermission());
        try {
            Connection connection = ConnectionUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
            viewResult.onViewResultSuccess(Const.ACCOUNT_QUERY_INSERT, taiKhoan);
        } catch (SQLException ex) {
            //Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            viewResult.onViewResultFailed(ex.getMessage());
        }
    }
    
}
