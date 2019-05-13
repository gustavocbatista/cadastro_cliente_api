/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.util;

/**
 *
 * @author gustavo
 */
public class TipoSO {
    
    public static boolean isLinux() {

        return System.getProperty("os.name").contains("Linux");
    }


    public static boolean isWindows() {
        
         return System.getProperty("os.name").contains("Windows");
    }
    
}
