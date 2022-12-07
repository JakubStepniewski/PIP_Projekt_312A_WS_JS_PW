package com.ztm_proj.ztm_proj.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRIPS", schema = "prog_w")
public class Trips {
    private Long id;
    private String route_id;
    private String service_id;
    private String trip_id;
    private String trip_headsign;
    private Long direction_id;
    private Long shape_id;

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

    @Column(name = "SHAPE_ID")
    public Long getShape_id() {
        return shape_id;
    }
    @Column(name = "SHAPE_ID")
    public void setShape_id(Long shape_id) {
        this.shape_id = shape_id;
    }
    @Column(name = "DIRECTION_ID")
    public Long getDirection_id() {
        return direction_id;
    }
    @Column(name = "DIRECTION_ID")
    public void setDirection_id(Long direction_id) {
        this.direction_id = direction_id;
    }
    @Column(name = "TRIP_HEADSIGN")
    public String getTrip_headsign() {
        return trip_headsign;
    }
    @Column(name = "TRIP_HEADSIGN")
    public void setTrip_headsign(String trip_headsign) {
        this.trip_headsign = trip_headsign;
    }
    @Column(name = "TRIP_ID")
    public String getTrip_id() {
        return trip_id;
    }
    @Column(name = "TRIP_ID")
    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }
    @Column(name = "SERVICE_ID")
    public String getService_id() {
        return service_id;
    }
    @Column(name = "SERVICE_ID")
    public void setService_id(String service_id) {
        this.service_id = service_id;
    }
    @Column(name = "ROUTE_ID")
    public String getRoute_id() {
        return route_id;
    }
    @Column(name = "ROUTE_ID")
    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", trip_headsign='" + trip_headsign + '\'' +
                ", route_id=" + route_id +
                '}';
    }
}