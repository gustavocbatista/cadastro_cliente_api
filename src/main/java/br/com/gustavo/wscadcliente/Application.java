/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 *
 * @author HOME
 */
@SpringBootApplication
@EntityScan(basePackages = {
              "br.com.gustavo.wscadcliente.model"
              })
@EnableJpaRepositories(basePackages = {
              "br.com.gustavo.wscadcliente.repository"
              })
public class Application {
    
        public static void main(String[] args) {
            //Iniciliza o WebService RestFull na porta 8081
          SpringApplication.run(Application.class, args);    
        }
    
    
}
