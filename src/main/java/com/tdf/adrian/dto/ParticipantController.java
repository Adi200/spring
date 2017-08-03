package com.tdf.adrian.dto;


import com.tdf.adrian.dao.ParticipantDAO;
import com.tdf.adrian.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by User on 7/26/2017.
 */

@RestController
public class ParticipantController {

    @Autowired
    MainService mainService;

    ParticipantDAO participant=new ParticipantDAO();

    @RequestMapping(value="/participant/add",method=RequestMethod.POST)
    public @ResponseBody String addParticipant(@RequestParam(value="Id") Long id, @RequestBody ParticipantDTO JSONparticipant ){
        if(participant.pTypeValidation(JSONparticipant.getType())){
        mainService.addParticipant(JSONparticipant, id);
        return "Participant added!";}
        return "Wrong type!";
    }

    @RequestMapping(value="/participant/delete", method=RequestMethod.DELETE)
    public String deleteParticipant(@RequestParam(value="Id") Long id) {
        mainService.deleteParticipant(id);
        return "Participant deleted!";
    }
}
