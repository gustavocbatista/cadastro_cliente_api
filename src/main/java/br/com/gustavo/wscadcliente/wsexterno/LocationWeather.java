/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.wsexterno;

import java.io.Serializable;

/**
 *
 * @author HOME
 */
public class LocationWeather implements Serializable {
    
    private String title;
    private String location_type;
    private String latt_long;
    private Long woeid;
    private Long distance;
    
    
    public LocationWeather(){
        
    }
    
    public LocationWeather(String title,String locationtype,String lattlong,Long woeid, Long distance){
        
        this.title = title;
        this.location_type = locationtype;
        this.latt_long = lattlong;
        this.woeid = woeid;
        this.distance = distance;                
        
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
     * @return the woeid
     */
    public Long getWoeid() {
        return woeid;
    }

    /**
     * @param woeid the woeid to set
     */
    public void setWoeid(Long woeid) {
        this.woeid = woeid;
    }

    /**
     * @return the distance
     */
    public Long getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(Long distance) {
        this.distance = distance;
    }

    
    
    
    
}
