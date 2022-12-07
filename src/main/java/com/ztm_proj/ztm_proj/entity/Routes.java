package com.ztm_proj.ztm_proj.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROUTES", schema = "prog_w")
public class Routes {
    private Long ID;
    private String ROUTE_ID;
    private String AGENCY_ID;
    private String ROUTE_SHORT_NAME;
    private String ROUTE_LONG_NAME;
    private Long ROUTE_TYPE;
    private String ROUTE_COLOR;
    private Long ROUTE_TEXT_COLOR;
    private Long id;

    public Routes() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public String getROUTE_ID() {
        return ROUTE_ID;
    }

    public void setROUTE_ID(String ROUTE_ID) {
        this.ROUTE_ID = ROUTE_ID;
    }

    public String getAGENCY_ID() {
        return AGENCY_ID;
    }

    public void setAGENCY_ID(String AGENCY_ID) {
        this.AGENCY_ID = AGENCY_ID;
    }

    public String getROUTE_SHORT_NAME() {
        return ROUTE_SHORT_NAME;
    }

    public void setROUTE_SHORT_NAME(String ROUTE_SHORT_NAME) {
        this.ROUTE_SHORT_NAME = ROUTE_SHORT_NAME;
    }

    public String getROUTE_LONG_NAME() {
        return ROUTE_LONG_NAME;
    }

    public void setROUTE_LONG_NAME(String ROUTE_LONG_NAME) {
        this.ROUTE_LONG_NAME = ROUTE_LONG_NAME;
    }

    public Long getROUTE_TYPE() {
        return ROUTE_TYPE;
    }

    public void setROUTE_TYPE(Long ROUTE_TYPE) {
        this.ROUTE_TYPE = ROUTE_TYPE;
    }

    public String getROUTE_COLOR() {
        return ROUTE_COLOR;
    }

    public void setROUTE_COLOR(String ROUTE_COLOR) {
        this.ROUTE_COLOR = ROUTE_COLOR;
    }

    public Long getROUTE_TEXT_COLOR() {
        return ROUTE_TEXT_COLOR;
    }

    public void setROUTE_TEXT_COLOR(Long ROUTE_TEXT_COLOR) {
        this.ROUTE_TEXT_COLOR = ROUTE_TEXT_COLOR;
    }

}
