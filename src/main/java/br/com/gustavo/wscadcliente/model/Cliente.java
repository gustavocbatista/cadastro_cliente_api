/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author HOME
 * 
 * Classe que mapeia a tavela tab_cliente do banco de dados
 */
@Entity
@SequenceGenerator(name = "seqcliente", sequenceName = "seq_cliente", allocationSize = 1, initialValue = 1)
@Table(name = "tab_cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(generator = "seqcliente")
    @Column(name = "cd_cliente") 
    private long cdCliente;
    @Column(name = "ds_nome")
    private String nmCliente;
    @Column(name = "nr_idade")
    private int nrIdade;
 
    /**
     * @return the cdCliente
     */
    public long getCdCliente() {
        return cdCliente;
    }

    /**
     * @param cdCliente the cdCliente to set
     */
    public void setCdCliente(long cdCliente) {
        this.cdCliente = cdCliente;
    }

    /**
     * @return the nmCliente
     */
    public String getNmCliente() {
        return nmCliente;
    }

    /**
     * @param nmCliente the nmCliente to set
     */
    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    /**
     * @return the nrIdade
     */
    public int getNrIdade() {
        return nrIdade;
    }

    /**
     * @param nrIdade the nrIdade to set
     */
    public void setNrIdade(int nrIdade) {
        this.nrIdade = nrIdade;
    }
   
    
}
