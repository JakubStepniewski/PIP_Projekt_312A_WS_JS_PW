package com.ztm_proj.ztm_proj.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROUTES", schema = "prog_w")
public class Routes {
    @Column(name = "ROUTE_ID")
    private String routeId;

    @Column(name = "AGENCY_ID")
    private String agencyId;

    @Column(name = "ROUTE_SHORT_NAME")
    private String routeShortName;

    @Column(name = "ROUTE_LONG_NAME")
    private String routeLongName;

    @Column(name = "ROUTE_TYPE")
    private Long routeType;

    @Column(name = "ROUTE_COLOR")
    private String routeColor;

    @Column(name = "ROUTE_TEXT_COLOR")
    private Long routeTextColor;
    private int id;

    public Routes() {
    }

    public Routes(String routeId, String agencyId, String routeShortName, String routeLongName, Long routeType, String routeColor, Long routeTextColor, int id) {
        this.routeId = routeId;
        this.agencyId = agencyId;
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeType = routeType;
        this.routeColor = routeColor;
        this.routeTextColor = routeTextColor;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }


    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public Long getRouteType() {
        return routeType;
    }

    public void setRouteType(Long routeType) {
        this.routeType = routeType;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public Long getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(Long routeTextColor) {
        this.routeTextColor = routeTextColor;
    }
}
