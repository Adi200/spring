package com.tdf.adrian.dao;

import com.tdf.adrian.dto.ParticipantDTO;
import javax.persistence.*;

/**
 * Created by User on 7/26/2017.
 */
@Entity
@Table(name = "Participants", catalog = "competitions")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ParticipantDAO {


    private Long id;
    private String name;
    private int number;
    //private boolean flag;
    private String dateOfBirth;
    private ParticipantType type;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

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

//    public boolean isFlag() {
//        return flag;
//    }
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participant_id", unique = true, nullable = false)
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
    public  ParticipantDTO toDTO() {
        ParticipantDTO participant = new ParticipantDTO();
        participant.setId(getId());
        participant.setName(getName());
        participant.setNumber(getNumber());
        participant.setDateOfBirth(getDateOfBirth());
        participant.setType(getType());
        return participant;
    }

    public static ParticipantDAO fromDTO(ParticipantDTO participantDto){
        ParticipantDAO participant= new ParticipantDAO();
        participant.setId(participantDto.getId());
        participant.setName(participantDto.getName());
        participant.setNumber(participantDto.getNumber());
        participant.setDateOfBirth(participantDto.getDateOfBirth());
        participant.setType(participantDto.getType());
        return participant;
    }
}