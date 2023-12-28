package com.nomadspa.backend.SpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="api/v1/SpaService")
public class SpaServiceController {
    private final SpaServiceService SpaServiceService;
    @Autowired
    public SpaServiceController(com.nomadspa.backend.SpaService.SpaServiceService spaServiceService) {
        SpaServiceService = spaServiceService;
    }
    @GetMapping
    public List<SpaServiceDTO> getSpaService(){
        return SpaServiceService.getSpaService();
    }
    @GetMapping(path = "{customerId}")
    public List<SpaServiceDTO> getSpaServiceByCustomer(@PathVariable("customerId") Long customerId){
        return SpaServiceService.getSpaServiceByCustomer(customerId);
    }
    @GetMapping(path = "{start}/{end}")
    public List<SpaServiceDTO> getStartTimeBetween(@PathVariable("start") LocalDateTime start, @PathVariable("end") LocalDateTime end){
        return SpaServiceService.getStartTimeBetween(start,end);
    }
    @GetMapping(path = "{therapistId}/{start}/{end}")
    public List<SpaServiceDTO> getSpaServiceByTherapistAndTime(
            @PathVariable("therapistId") Long therapistId,
            @PathVariable("start") LocalDateTime start,
            @PathVariable("end") LocalDateTime end){
        return SpaServiceService.getSpaServiceByTherapistAndTime(therapistId,start,end);
    }

    @PostMapping
    public void registerNewSpaService(@RequestBody SpaServiceDTO spaService){
        SpaServiceService.addNewSpaService(spaService);
    }
    @DeleteMapping(path = "{spaServiceId}")
    public void deleteSpaService(
            @PathVariable("spaServiceId") Long spaServiceId){
        SpaServiceService.deleteSpaService(spaServiceId);
    }
}
