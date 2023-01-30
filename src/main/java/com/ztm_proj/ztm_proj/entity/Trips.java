package com.ztm_proj.ztm_proj.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRIPS", schema = "prog_w")
public class Trips {
    private Long id;
    @Column(name = "SHAPE_ID")
    private String routeId;

    @Column(name = "SERVICE_ID")
    private String serviceId;

    @Column(name = "TRIP_ID")
    private String tripId;

    @Column(name = "TRIP_HEADSIGN")
    private String tripHeadsign;

    public Trips(Long id, String routeId, String serviceId, String tripId, String tripHeadsign, Long directionId, Long shapeId) {
        this.id = id;
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
        this.directionId = directionId;
        this.shapeId = shapeId;
    }

    @Column(name = "DIRECTION_ID")
    private Long directionId;

    @Column(name = "SHAPE_ID")
    private Long shapeId;

    public Trips() {
        super();
    }



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }


    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Long getShapeId() {
        return shapeId;
    }

    public void setShapeId(Long shapeId) {
        this.shapeId = shapeId;
    }

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }
}