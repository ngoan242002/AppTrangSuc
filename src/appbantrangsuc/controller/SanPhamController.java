/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.controller;

import appbantrangsuc.Const;
import appbantrangsuc.models.SanPham;
import appbantrangsuc.utils.ConnectionUtils;
import appbantrangsuc.views.ViewResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vipvl
 */
public class SanPhamController {

    private ViewResult viewResult;

    private static final String SAN_PHAM_TAB = "QuanLySanPham";

    public SanPhamController(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    public void queryAll() {
        String query = "select * from " + SAN_PHAM_TAB + "";
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                sanPhams.add(new SanPham(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        new Date(),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
            viewResult.onViewResultSuccess(Const.SP_QUERY_ALL, sanPhams);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            viewResult.onViewResultFailed(ex.getMessage());
        }
    }
// insert into QuanLySanPham values('ScreenShot', 1200, '2023/3/19', '', '', 'D:\NguoiYeu\AppBanTrangSuc\src\res\pictures\sanpham\Screenshot.png')    

    public void addSanPham(SanPham sanPham) {
        String query
                = "insert into "
                + SAN_PHAM_TAB
                + " values("
                + "N'" + sanPham.getTenSanPham() + "', "
                + sanPham.getGiaSanPham() + ", "
                + "'" + new SimpleDateFormat("yyyy/MM/dd").format(sanPham.getNgayNhap()) + "', "
                + "N'" + sanPham.getMoTa() + "', "
                + "N'" + sanPham.getNhaSanXuat() + "', "
                + "N'" + sanPham.getFileImageUrl() + "')";
        try {
            Connection connection = ConnectionUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            boolean isInserted = statement.execute(query);
            viewResult.onViewResultSuccess(Const.SP_QUERY_INSERT);

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            viewResult.onViewResultFailed(ex.getMessage());
        }
    }

    public void udpateSanPham(SanPham before, SanPham newSp) {
        String query = String.format(
                "update " + SAN_PHAM_TAB + "\n"
                + "set\n"
                + "TenSanPham = N'%s',\n"
                + "GiaSanPham = " + newSp.getGiaSanPham() + ",\n"
                + "NgayNhap = '%s',\n"
                + "MoTa = N'%s',\n"
                + "NhaSanXuat = N'%s',\n"
                + "JsonStringBitmap = '%s'\n"
                + "where MaSanPham = %d",
                newSp.getTenSanPham(),
                new SimpleDateFormat("yyyy/MM/dd").format(newSp.getNgayNhap()),
                newSp.getMoTa(),
                newSp.getNhaSanXuat(),
                newSp.getFileImageUrl(),
                before.getMaSanPham()
        );
        System.out.println(query);
        try {
            Connection connection = ConnectionUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            boolean isInserted = statement.execute(query);

            if (isInserted) {
                viewResult.onViewResultSuccess(Const.SP_QUERY_UPDATE, before, newSp);
            } else {
                viewResult.onViewResultFailed("return false");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            viewResult.onViewResultFailed(ex.getMessage());
        }
    }

    public void delete(SanPham sp) {
        String query = "delete from " + SAN_PHAM_TAB + " where MaSanPham = " + sp.getMaSanPham();
        try {
            Connection connection = ConnectionUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            boolean isInserted = statement.execute(query);

            viewResult.onViewResultSuccess(Const.SP_QUERY_DELETE);

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            viewResult.onViewResultFailed(ex.getMessage());
        }
    }
}
