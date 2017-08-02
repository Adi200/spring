package com.tdf.adrian.dto;


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

    @RequestMapping(value="/participant/add",method=RequestMethod.POST)
    public @ResponseBody String addParticipant(@RequestParam(value="Id") Long id, @RequestBody ParticipantDTO JSONparticipant ){
        mainService.addParticipant(JSONparticipant, id);
        return "ok";
    }

    @RequestMapping(value="/participant/delete", method=RequestMethod.DELETE)
    public String deleteParticipant(@RequestParam(value="Id") Long id) {
        mainService.deleteParticipant(id);
        return "Participant deleted!";
    }
}
