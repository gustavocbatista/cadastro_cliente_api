/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.service;

import br.com.gustavo.wscadcliente.model.Cliente;
import java.util.List;

/**
 *
 * @author HOME
 */
public interface IClienteService {
    
    public boolean cadastrar(Cliente cli, String ipOrigem);
    
    public boolean alterar(Cliente cli);
    
    public Cliente pesqClienteID(long idCliente);
    
    public List<Cliente> getClientes();
    
    public boolean excluirCliente(long idCliente); 
    
    
    
}
