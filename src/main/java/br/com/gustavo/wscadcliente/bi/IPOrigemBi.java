/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.bi;

import br.com.gustavo.wscadcliente.wsexterno.DadosIP;
import br.com.gustavo.wscadcliente.wsexterno.IpVigilante;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author gustavo
 */
@Component
public class IPOrigemBi {
    // URL para receber os dados de geoLOcalizacao do IP origem, que solicitou o servico de cadastro de cliente
    private final String URL_IP_LOCALIZACAO = "https://ipvigilante.com/json/{ipLocalizacao}";
    
    public DadosIP retornaLocalizacao(String numIpOrigem) throws Exception{
        // Instancia Objeto que ira acessar e transformar os dados do WS externo
        RestTemplate restTemplate = new RestTemplate();
        // Acessa WS externo enviando o IP de origem e recebe os dados como cidade, latitude e longitude
        IpVigilante ipVigilante = restTemplate.getForObject(URL_IP_LOCALIZACAO, IpVigilante.class, numIpOrigem);
        // Retorna os dados de geoLocalizacao
        return ipVigilante.getData();
    }
  
}
