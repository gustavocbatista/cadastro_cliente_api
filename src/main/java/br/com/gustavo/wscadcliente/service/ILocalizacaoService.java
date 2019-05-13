/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.service;

import br.com.gustavo.wscadcliente.model.Cliente;


/**
 *
 * @author gustavo
 */
public interface ILocalizacaoService {
    
    public void cadastrar(Cliente cli, String ipOrigem);
    
    public void deletar(Cliente cli);
    
}
