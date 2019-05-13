/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.service;

import br.com.gustavo.wscadcliente.model.Cliente;
import br.com.gustavo.wscadcliente.repository.ClienteRepository;
import br.com.gustavo.wscadcliente.util.UtilLog;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HOME
 */
@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository cliRepository;
    
    @Autowired
    private ILocalizacaoService localService;
    
    @Override
    public boolean cadastrar(Cliente cli, String ipOrigem) {
    
        try{
            //Chama o metodo que ira salvar os dados do cliente novo
            Cliente cliCadastrado =  cliRepository.save(cli);
            
            //Salva os dados de temperaturas do local onde esta sendo cadastrado o cliente
            localService.cadastrar(cliCadastrado, ipOrigem);
            //Retorna verdadeiro caso ocorra tudo certo
            return true;
            
        }catch(Exception ex){
            //Salva log de erro caso ocorra alguma excessao
            UtilLog.regLogErro("CadastrarCliente", ex);
            // Retorna false para o client que chamou o servico, como não teve sucesso
            return false;
        }
    
    }

    @Override
    public boolean alterar(Cliente cli) {
    
         try{
            // Recebe o objeto Cliente com os dados alterados e salva a alteracao no baco  de dados
            cliRepository.save(cli);
            //Retorna verdadeiro caso ocorra tudo certo
            return true;
            
        }catch(Exception ex){
            //Salva log de erro caso ocorra alguma excessao
            UtilLog.regLogErro("AlterarCliente", ex);
            // Retorna false para o client que chamou o servico, como não teve sucesso
            return false;
        }         
    
    }

    @Override
    public Cliente pesqClienteID(long idCliente) {
    
        //Pesquisa o cliente por codigo de identificacao
        Cliente cli = cliRepository.findOne(idCliente);
        
        return cli;
    
    }

    @Override
    public List<Cliente> getClientes() {        
        // Retorna todos Clientes cadastrado na base de dados
        return cliRepository.findAll();
    
    }

    @Override
    public boolean excluirCliente(long id) {
    
        try{
            //Pesquisa o cliente por id para ser excluido
            Cliente cliDeletar = cliRepository.findOne(id);
            // Delete os dados da temperatura do cliente na hora do cadastro
            localService.deletar(cliDeletar);
            // Delete o cliente na base de dados
            cliRepository.delete(cliDeletar);
            //Retorna verdadeiro caso ocorra tudo certo
            return true;
            
        }catch(Exception ex)
        {
            //Salva log de erro caso ocorra alguma excessao
            UtilLog.regLogErro("DeletarCliente", ex);
            // Retorna false para o client que chamou o servico, como não teve sucesso
            return false;
        
        }
    
    }
    
    
}
