/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.controller;

import br.com.gustavo.wscadcliente.model.Cliente;
import br.com.gustavo.wscadcliente.service.IClienteService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HOME
 */

@RestController
public class CadClienteController {
    
    @Autowired
    private IClienteService cliService;
  
    /**
     *   Metodo que faz o cadastramento do cliente e salva as temperaturas do dia, na regiao
     *   proximo do IP de Origem
     *
     *   @param Cliente
     *   @return boolean
    */
    @PostMapping("/cadCliente")
    public boolean cadastrarCliente(@RequestBody Cliente cli, HttpServletRequest request){
        
        return cliService.cadastrar(cli, request.getRemoteAddr());
        
    }
    
    /**
     *  Metodo que a alteracao dos dados do cliente ja cadastrado
     *
     *   @param cli
     *   @return boolean
    */    
    @PutMapping("/alterarCliente")
    public boolean alterarCliente(@RequestBody Cliente cli){
        
        return cliService.alterar(cli);
    }
    
    /**
     *  Metodo que retorna um cliente atraves do seu ID
     *
     *   @param idCliente
     *   @return Cliente
    */
    @GetMapping("/pesqCliente/{idCliente}")
    public Cliente pesqClienteID(@PathVariable long idCliente){
        
        return cliService.pesqClienteID(idCliente);
        
    }
    
    /**
     *   Metodo que retorna todos os clientes cadastrados na base de dados
     *
     *   @return List<Cliente>
    */
    @GetMapping("/pesqTodosCliente")
    public List<Cliente> getClientes(){
    
        return cliService.getClientes();
    }
    
    /**
     *   Metodo que exclui um cliente cadastrado na base de dados
     *
     *   @param idCliente
     *   @return boolean
    */
    @DeleteMapping("/deleteCli/{idCliente}")
    public boolean excluirClienteID(@PathVariable long idCliente){
        
        return cliService.excluirCliente(idCliente);
        
    }
    
}
