/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbantrangsuc.utils;

import appbantrangsuc.widget.ImageLabel;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author vipvl
 */
public class AppUtils {

    public static byte[] getImageByteArray(String fileName) {
        File f = new File(fileName);
        try {
            BufferedImage o = ImageIO.read(f);
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(o, f.getName().split("\\.")[1], b);
            byte[] img = b.toByteArray();
            return img;
        } catch (IOException e) {
            return null;
        }

    }
    
    public static Image getImageFromByteArray(byte [] bytes) {
        try {
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
            return img;
        } catch (IOException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
    
    public static ImageIcon resizeIcon(Icon i, JPanel parent) {
        ImageIcon icon = (ImageIcon) i;
        Image image = icon.getImage();
        int width = image.getWidth(parent);
        int height = image.getHeight(parent);
        
        int wPercent = width / ucln(width, height);
        int hPercent = height / ucln(width, height);
        int newWidth;
        int newHeight;
        int parentWidth = parent.getPreferredSize().width;
        if (parentWidth <= 0) {
            parentWidth = parent.getSize().width;
        }
        int parentHeight = parent.getPreferredSize().height;
        if (parentHeight <= 0) {
            parentHeight = parent.getSize().height;
        }
        if (width > height) {
            newWidth = parentWidth;
            newHeight = (int) (newWidth * hPercent / wPercent);
        } else if (width < height) {
            newHeight = parentHeight;
            newWidth = (int) (newHeight * wPercent / hPercent);
        } else {
            newWidth = newHeight = parentWidth;
        }
        if (newWidth == 0) {
            newWidth = parentWidth;
        }
        if (newHeight == 0) {
            newHeight = parentHeight;
        }
        image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);
        return icon;
    }
    public static int ucln(int a, int b) {
        if (b == 0) return a;
        return ucln(b, a % b);
    }
}
