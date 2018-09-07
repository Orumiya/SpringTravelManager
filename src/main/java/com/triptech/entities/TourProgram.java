package com.triptech.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class TourProgram {
    @Id
    @GeneratedValue
    private Long id;

    private String programtype;
    @ManyToMany(mappedBy = "programList")
    private List<Travel> travelListInTourProgram;

    public List<Travel> getTravelListInTourProgram() {
        return travelListInTourProgram;
    }

    public void setTravelListInTourProgram(List<Travel> travelListInTourProgram) {
        this.travelListInTourProgram = travelListInTourProgram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramtype() {
        return programtype;
    }

    public void setProgramtype(String programtype) {
        this.programtype = programtype;
    }


}
