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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author HOME
 * 
 * 
 * Classe que mapeia a tabela tab_localizacao_cli do banco de dsdos
 */
@Entity
@SequenceGenerator(name = "seqlocalizacao", sequenceName = "seq_localizacao", allocationSize = 1, initialValue = 1)
@Table(name = "tab_localizacao_cli")
public class Localizacao implements Serializable{
    @Id
    @GeneratedValue(generator = "seqlocalizacao")
    @Column(name = "cd_localizacao")     
    private long cdLocalizacao;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @Column(name = "vr_temp_minima")
    private double tempMinima;
    @Column(name = "vr_temp_maxima")
    private double tempMaxima;

    /**
     * @return the cdLocalizacao
     */
    public long getCdLocalizacao() {
        return cdLocalizacao;
    }

    /**
     * @param cdLocalizacao the cdLocalizacao to set
     */
    public void setCdLocalizacao(long cdLocalizacao) {
        this.cdLocalizacao = cdLocalizacao;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the tempMinima
     */
    public double getTempMinima() {
        return tempMinima;
    }

    /**
     * @param tempMinima the tempMinima to set
     */
    public void setTempMinima(double tempMinima) {
        this.tempMinima = tempMinima;
    }

    /**
     * @return the tempMaxima
     */
    public double getTempMaxima() {
        return tempMaxima;
    }

    /**
     * @param tempMaxima the tempMaxima to set
     */
    public void setTempMaxima(double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }
    
}
