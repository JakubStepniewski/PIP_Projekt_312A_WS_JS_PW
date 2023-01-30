package com.ztm_proj.ztm_proj.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STOP_TIMES", schema = "prog_w")
public class StopTimes {
    private int Id;
    private String TripId;
    private String ArrivalTime;
    private int StopId;
    private int StopSequence;


    public StopTimes() {
    }

    public void setId(int id) {
        this.Id = id;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return Id;
    }

    @Column(name = "TRIP_ID")
    public String getTripId() {
        return TripId;
    }

    @Column(name = "TRIP_ID")
    public void setTripId(String tripId) {
        TripId = tripId;
    }

    @Column(name = "ARRIVAL_TIME")
    public String getArrivalTime() {
        return ArrivalTime;
    }

    @Column(name = "ARRIVAL_TIME")
    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    @Column(name = "STOP_ID")
    public int getStopId() {
        return StopId;
    }

    @Column(name = "STOP_ID")
    public void setStopId(int stopId) {
        StopId = stopId;
    }

    @Column(name = "STOP_SEQUENCE")
    public int getStopSequence() {
        return StopSequence;
    }

    @Column(name = "STOP_SEQUENCE")
    public void setStopSequence(int stopSequence) {
        StopSequence = stopSequence;
    }
}
