/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.wsexterno;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class MetaWeather implements Serializable{
    
    private String title;
    private String location_type;
    private String latt_long;
    private String timezone_name;
    private LocationWeather parent;
    private List<ConsolidatedWeather> consolidated_weather;
    private List<SourceWeather> sources;
    
    public MetaWeather(){}
    
    public MetaWeather(String title, String location_type, String latt_long, String timezone_name,
                       LocationWeather parent, List<ConsolidatedWeather> consolidated_weather,
                       List<SourceWeather> sources){
        
        this.title = title;
        
        this.location_type = location_type;
        
        this.latt_long = latt_long;
        
        this.timezone_name = timezone_name;
        
        this.parent = parent;
        
        this.consolidated_weather = consolidated_weather;
        
        this.sources = sources;
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
     * @return the location_type
     */
    public String getLocation_type() {
        return location_type;
    }

    /**
     * @param location_type the location_type to set
     */
    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    /**
     * @return the latt_long
     */
    public String getLatt_long() {
        return latt_long;
    }

    /**
     * @param latt_long the latt_long to set
     */
    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    /**
     * @return the timezone_name
     */
    public String getTimezone_name() {
        return timezone_name;
    }

    /**
     * @param timezone_name the timezone_name to set
     */
    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    /**
     * @return the parent
     */
    public LocationWeather getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(LocationWeather parent) {
        this.parent = parent;
    }

    /**
     * @return the consolidated_weather
     */
    public List<ConsolidatedWeather> getConsolidated_weather() {
        return consolidated_weather;
    }

    /**
     * @param consolidated_weather the consolidated_weather to set
     */
    public void setConsolidated_weather(List<ConsolidatedWeather> consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    /**
     * @return the sources
     */
    public List<SourceWeather> getSources() {
        return sources;
    }

    /**
     * @param sources the sources to set
     */
    public void setSources(List<SourceWeather> sources) {
        this.sources = sources;
    }
    
}
