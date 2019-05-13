/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.wsexterno;

import java.io.Serializable;

/**
 *
 * @author gustavo
 */
public class IpVigilante implements Serializable {
    
    private String status;
    private DadosIP data;

    public IpVigilante(){}
    
    public IpVigilante (String status, DadosIP data){
        
        this.status = status;
        
        this.data = data;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the data
     */
    public DadosIP getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(DadosIP data) {
        this.data = data;
    }
    
}
