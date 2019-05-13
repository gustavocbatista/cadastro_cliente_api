/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.wsexterno;

import java.io.Serializable;

/**
 *
 * @author gustavo
 */
public class SourceWeather implements Serializable{
    
    private String title;
    private String slug;
    private String url;
    private String crawl_rate;
    
    public SourceWeather(){
     
    }
    
    public SourceWeather(String title, String slug,String url, String crawl_rate){
        
        this.title = title;
        
        this.slug = slug;
        
        this.url = url;
        
        this.crawl_rate = crawl_rate;
        
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug the slug to set
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the crawl_rate
     */
    public String getCrawl_rate() {
        return crawl_rate;
    }

    /**
     * @param crawl_rate the crawl_rate to set
     */
    public void setCrawl_rate(String crawl_rate) {
        this.crawl_rate = crawl_rate;
    }

    
}
