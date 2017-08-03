package com.tdf.adrian.dao;

/**
 * Created by User on 7/27/2017.
 */
public enum  ParticipantType {
    ACTIVE("ACTIVE"),
    MEDIUM("MEDIUM"),
    LOW("LOW");


    private  final  String type;
    private ParticipantType(String type){this.type=type;}




}
