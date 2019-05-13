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
public class DadosIP implements Serializable{
    
    private String ipv4;
    private String continent_name;
    private String country_name;
    private String subdivision_1_name;
    private String subdivision_2_name;
    private String city_name;
    private String latitude;
    private String longitude;

    public DadosIP(){}
    
    public DadosIP (String ipv4, String continent_name, String country_name,
                    String subdivision_1_name, String subdivision_2_name,
                    String city_name, String latitude, String longitude){
        
        this.ipv4 = ipv4;
	
        this.continent_name = continent_name;
	
        this.country_name = country_name;
	
        this.subdivision_1_name = subdivision_1_name;
	
        this.subdivision_2_name = subdivision_2_name;
	
        this.city_name = city_name;
	
        this.latitude = latitude;
	
        this.longitude = longitude;
    }
    
    /**
     * @return the ipv4
     */
    public String getIpv4() {
        return ipv4;
    }

    /**
     * @param ipv4 the ipv4 to set
     */
    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    /**
     * @return the continent_name
     */
    public String getContinent_name() {
        return continent_name;
    }

    /**
     * @param continent_name the continent_name to set
     */
    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    /**
     * @return the country_name
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * @param country_name the country_name to set
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    /**
     * @return the subdivision_1_name
     */
    public String getSubdivision_1_name() {
        return subdivision_1_name;
    }

    /**
     * @param subdivision_1_name the subdivision_1_name to set
     */
    public void setSubdivision_1_name(String subdivision_1_name) {
        this.subdivision_1_name = subdivision_1_name;
    }

    /**
     * @return the subdivision_2_name
     */
    public String getSubdivision_2_name() {
        return subdivision_2_name;
    }

    /**
     * @param subdivision_2_name the subdivision_2_name to set
     */
    public void setSubdivision_2_name(String subdivision_2_name) {
        this.subdivision_2_name = subdivision_2_name;
    }

    /**
     * @return the city_name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * @param city_name the city_name to set
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
}
