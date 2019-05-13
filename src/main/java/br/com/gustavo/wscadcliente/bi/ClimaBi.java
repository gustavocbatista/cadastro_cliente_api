/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.bi;

import br.com.gustavo.wscadcliente.wsexterno.ConsolidatedWeather;
import br.com.gustavo.wscadcliente.wsexterno.LocationWeather;
import br.com.gustavo.wscadcliente.wsexterno.MetaWeather;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author HOME
 */
@Component
public class ClimaBi {
   // URL para pesquisar os dados das cidades proximas da latitude e longitude do IP de Origem 
   private final String URL_LOCALIZACAO = "https://www.metaweather.com/api/location/search/?lattlong={latitude},{longitude}";
   // URL dos dados da cidade 
   private final String URL_TEMPERATURAS = "https://www.metaweather.com/api/location/{woeid}/";
   // Classe que fara a conversao dos dados para suas respectivas clssses
   private final RestTemplate restTemplate;
    
   public ClimaBi(){
       // Inicializa objeto
       restTemplate = new RestTemplate();
       
   }
        
   public ConsolidatedWeather getDadosClima(final String latitude, final String longitude) throws Exception{
       
       // Inicializa objeto
       ConsolidatedWeather dadosClima = null;
       // Pesquisa se existe cidades proximas da localizacao do IP
       List<LocationWeather> listaLocalizacao = this.getLocalizacoes(latitude, longitude);
       // Verifica se a lista de Localizacoes esta vazia ou com informacoes
       if(listaLocalizacao.size() > 0){ 
        // Pega a primeira cidade da lista, pois do site e retornado a mais proxima da sua origem primeiro
        LocationWeather localizacaoProxima = listaLocalizacao.get(0);
        // Acessa um WS externo e transforma o resultado em um objeto do tipo MetaWeather
        MetaWeather metaWeather = restTemplate.getForObject(URL_TEMPERATURAS, MetaWeather.class,localizacaoProxima.getWoeid());
        // Objeto dadosClima recebe as informacoes da primeira posicao da lista que e referente a data do dia 
        dadosClima = metaWeather.getConsolidated_weather().get(0);
        
       }
       // Retorna objeto contendo os dados das temperaturas
       return dadosClima;
       
   }
   
    private List<LocationWeather> getLocalizacoes(final String latitude, final String longitude){        
        // Acessa WS externo para receber a lista de cidades proximas da posicao do IP origem
        LocationWeather[] localizacoes = restTemplate.getForObject(URL_LOCALIZACAO, LocationWeather[].class, latitude, longitude);
	// Retorna a lista de cidades encontradas proximas a posicao de latitude e longitude de origem
        return Arrays.asList(localizacoes);
    }
    
    
}
