package com.ztm_proj.ztm_proj.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "DRIVERS", schema = "prog_w")
public class Drivers {
    @Id
    @Column(name = "ID")
    @JsonProperty("id")
    @GeneratedValue(generator="SEQ_DRIVERS")
    @SequenceGenerator(name="SEQ_DRIVERS",sequenceName="SEQ_DRIVERS", allocationSize=1)
    private int Id;

    @Column(name = "DRIVERS_NAME")
    private String DriverName;

    @Column(name = "LINE_ID")
    private String LineId;

    public Drivers(){}

    public Drivers(int id, String driverName, String lineId) {
        Id = id;
        DriverName = driverName;
        LineId = lineId;
    }

    public int getId() {
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
