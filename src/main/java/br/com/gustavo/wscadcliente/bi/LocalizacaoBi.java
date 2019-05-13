/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.bi;

import br.com.gustavo.wscadcliente.model.Localizacao;
import br.com.gustavo.wscadcliente.wsexterno.ConsolidatedWeather;
import br.com.gustavo.wscadcliente.wsexterno.DadosIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gustavo
 */
@Component
public class LocalizacaoBi {
    
    @Autowired
    private IPOrigemBi ipBi;
    
    @Autowired
    private ClimaBi climaBi;

    public Localizacao getLocalizacao(String numIpOrigem) throws Exception{
        // Instancia o objeto LOcalizacao
        Localizacao local = new Localizacao(); 
        // Inicializa a temperatura Minima
        local.setTempMinima(0);
        // Inicializa a temperatura Maxima
        local.setTempMaxima(0);
        // Recebe os dados de geoLocalizacao do IP de Origem
        DadosIP dadosIp = ipBi.retornaLocalizacao(numIpOrigem);
        // Verifica se existe dados de geoLocalizacao
        if(dadosIp != null){            
            // Recebe os dados de Temperaturas do local de Origem do IP
            ConsolidatedWeather consolidatedweather = climaBi.getDadosClima(dadosIp.getLatitude(), dadosIp.getLongitude());
            // Verifica se existe dados de Temperaturas
            if(consolidatedweather != null){
                // Seta a temperatura minima no objeto Localizacao
                local.setTempMinima(consolidatedweather.getMin_temp());
                // Seta a temperatura maxima no objeto Localizacao
                local.setTempMaxima(consolidatedweather.getMax_temp());
            }
        
        }       
        // Retorna os dados da Localizacao
        return local;        
        
    }
    
}
