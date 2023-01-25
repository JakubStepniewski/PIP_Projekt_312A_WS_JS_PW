package com.ztm_proj.ztm_proj.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STOPS", schema = "prog_w")
public class Stops {
    private Long Id;

    @Column(name = "STOP_CODE")
    private Long StopCode;

    @Column(name = "STOP_NAME")
    private String StopName;

    @Column(name = "STOP_LAT")
    private double StopLat;

    @Column(name = "STOP_LON")
    private double StopLon;

    @Column(name = "ZONE_ID")
    private int ZoneId;




    public void Stops(){}

    @Id
    @Column(name = "STOP_ID")
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getStopCode() {
        return StopCode;
    }

    public void setStopCode(Long stopCode) {
        StopCode = stopCode;
    }

    public String getStopName() {
        return StopName;
    }

    public void setStopName(String stopName) {
        StopName = stopName;
    }

    public double getStopLat() {
        return StopLat;
    }

    public void setStopLat(double stopLat) {
        StopLat = stopLat;
    }

    public double getStopLon() {
        return StopLon;
    }

    public void setStopLon(double stopLon) {
        StopLon = stopLon;
    }

    public int getZoneId() {
        return ZoneId;
    }

    public void setZoneId(int zoneId) {
        ZoneId = zoneId;
    }
}
