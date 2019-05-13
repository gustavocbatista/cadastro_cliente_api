/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.service;

import br.com.gustavo.wscadcliente.bi.LocalizacaoBi;
import br.com.gustavo.wscadcliente.model.Cliente;
import br.com.gustavo.wscadcliente.model.Localizacao;
import br.com.gustavo.wscadcliente.repository.LocalizacaoRepository;
import br.com.gustavo.wscadcliente.util.UtilLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gustavo
 */
@Service
public class LocalizacaoService implements ILocalizacaoService{

    @Autowired
    private LocalizacaoRepository localRepository;
    
    @Autowired
    private LocalizacaoBi localBi;
    
    @Override
    public void cadastrar(Cliente cli, String ipOrigem) {
    
        try{
            //REcebe o objeto Localizacao preenchido com os dados das temperaturas
            //Minima e maxima
            Localizacao local = localBi.getLocalizacao(ipOrigem);
            // Preenche os dados do cliente
            local.setCliente(cli);
            //Salva os dados da temperatura na base de dados
            localRepository.save(local);
            
        }catch(Exception ex){
            //Salva log de erro caso ocorra alguma excessao
            UtilLog.regLogErro("CadastarLocalizacao", ex);
            
        }
    
    }

    @Override
    public void deletar(Cliente cli) {
    
        try{
            //Pesquisa os dados da localizacao pelo id do cliente
            Localizacao localDel = localRepository.findByClienteCdCliente(cli.getCdCliente());
        
            //Deleta os dados da Localizacao do cliente
            localRepository.delete(localDel);  
        
        }catch(Exception ex){
            //Salva log de erro caso ocorra alguma excessao
            UtilLog.regLogErro("DeletarLocalizacao", ex);
            
        }
        
    }
    
    
    
}
