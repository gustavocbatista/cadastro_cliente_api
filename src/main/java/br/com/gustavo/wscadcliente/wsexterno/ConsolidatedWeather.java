/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.wscadcliente.wsexterno;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HOME
 */
public class ConsolidatedWeather implements Serializable{
    
    	private Long id;
	private String weather_state_name;
	private String weather_state_abbr;
	private String wind_direction_compass;
	//private Date created;
	//private LocalDate applicable_date;
	private Double min_temp;
	private Double max_temp;
	private Double the_temp;
	private Double wind_speed;
	private Double wind_direction;
	private Double air_pressure;
	private Integer humidity;
	private Double visibility;
	private Integer predictability;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the weather_state_name
     */
    public String getWeather_state_name() {
        return weather_state_name;
    }

    /**
     * @param weather_state_name the weather_state_name to set
     */
    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    /**
     * @return the weather_state_abbr
     */
    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    /**
     * @param weather_state_abbr the weather_state_abbr to set
     */
    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    /**
     * @return the wind_direction_compass
     */
    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    /**
     * @param wind_direction_compass the wind_direction_compass to set
     */
    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    /**
     * @return the min_temp
     */
    public Double getMin_temp() {
        return min_temp;
    }

    /**
     * @param min_temp the min_temp to set
     */
    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    /**
     * @return the max_temp
     */
    public Double getMax_temp() {
        return max_temp;
    }

    /**
     * @param max_temp the max_temp to set
     */
    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    /**
     * @return the the_temp
     */
    public Double getThe_temp() {
        return the_temp;
    }

    /**
     * @param the_temp the the_temp to set
     */
    public void setThe_temp(Double the_temp) {
        this.the_temp = the_temp;
    }

    /**
     * @return the wind_speed
     */
    public Double getWind_speed() {
        return wind_speed;
    }

    /**
     * @param wind_speed the wind_speed to set
     */
    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    /**
     * @return the wind_direction
     */
    public Double getWind_direction() {
        return wind_direction;
    }

    /**
     * @param wind_direction the wind_direction to set
     */
    public void setWind_direction(Double wind_direction) {
        this.wind_direction = wind_direction;
    }

    /**
     * @return the air_pressure
     */
    public Double getAir_pressure() {
        return air_pressure;
    }

    /**
     * @param air_pressure the air_pressure to set
     */
    public void setAir_pressure(Double air_pressure) {
        this.air_pressure = air_pressure;
    }

    /**
     * @return the humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the visibility
     */
    public Double getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the predictability
     */
    public Integer getPredictability() {
        return predictability;
    }

    /**
     * @param predictability the predictability to set
     */
    public void setPredictability(Integer predictability) {
        this.predictability = predictability;
    }
    
}
