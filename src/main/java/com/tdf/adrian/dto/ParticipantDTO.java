package com.tdf.adrian.dto;

import com.tdf.adrian.dao.ParticipantType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by User on 7/26/2017.
 */

public class ParticipantDTO {

    private Long id;
    private String name;
    private int number;
    private boolean flag;
    private String dateOfBirth;
  //  private String specialAttribute;
    private ParticipantType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public String getSpecialAttribute() {
//        return specialAttribute;
//    }
//
//    public void setSpecialAttribute(String specialAttribute) {
//        this.specialAttribute = specialAttribute;
//    }

//    public String getCompetition() {
//        return competition;
//    }
//
//    public void setCompetition(String competition) {
//        this.competition = competition;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParticipantType getType() {
        return type;
    }

    public void setType(ParticipantType type) {
        this.type = type;
    }
}