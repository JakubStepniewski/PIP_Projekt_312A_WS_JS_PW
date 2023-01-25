package com.ztm_proj.ztm_proj.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DRIVERS", schema = "prog_w")
public class Drivers {
    @Id
    @Column(name = "ID")
    private long Id;

    @Column(name = "DRIVERS_NAME")
    private String DriverName;

    @Column(name = "LINE_ID")
    private String LineId;


    public Long getId() {
        return Id;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getLineId() {
        return LineId;
    }

    public void setLineId(String lineId) {
        LineId = lineId;
    }
}
