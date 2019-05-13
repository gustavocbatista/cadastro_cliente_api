/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.repository;

import br.com.gustavo.wscadcliente.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author HOME
 */
@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long>{
    
    public Localizacao findByClienteCdCliente(long cdCliente);
    
}
