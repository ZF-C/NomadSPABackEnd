package com.nomadspa.backend.Therapist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="api/v1/therapist")
public class TherapistController {
    private final TherapistService TherapistService;

    @Autowired
    public TherapistController(com.nomadspa.backend.Therapist.TherapistService therapistService) {
        TherapistService = therapistService;
    }

    @GetMapping
    public List<Therapist> getTherapist(){
        return TherapistService.getTherapist();
    }
    @PostMapping
    public void registerNewTherapist(@RequestBody Therapist therapist){
        TherapistService.addNewTherapist(therapist);
    }
    @DeleteMapping(path = "{therapistId}")
    public void deleteTherapist(
            @PathVariable("therapistId") Long therapistId){
        TherapistService.deleteTherapist(therapistId);
    }
    @PutMapping(path = "{therapistId}")
    public void updateTherapist(@PathVariable("therapistId") Long therapistId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String phoneNumber){
        TherapistService.updateTherapist(therapistId,name,phoneNumber);

    }
    @PutMapping(path = "{therapistId}/state")
    public void updateTherapistState(@PathVariable("therapistId") Long therapistId,
                                     @RequestParam(required = false) Boolean active_or_not){
        TherapistService.updateTherapistState(therapistId,active_or_not);
    }
    @PutMapping(path = "{therapistId}/sequence")
    public void updateTherapistSequence(@PathVariable("therapistId") Long therapistId,
                                        @RequestParam(required = false) Integer sequenceNumber){
        TherapistService.updateTherapistSequence(therapistId,sequenceNumber);
    }



}
