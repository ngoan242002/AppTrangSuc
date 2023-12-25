/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package appbantrangsuc.views;

/**
 *
 * @author vipvl
 */
public interface ViewResult {
    
    void onViewResultSuccess(int key, Object... data);
    
    void onViewResultFailed(String mess);
    
    
}
