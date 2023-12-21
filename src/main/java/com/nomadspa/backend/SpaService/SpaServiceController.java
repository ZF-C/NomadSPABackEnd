package com.nomadspa.backend.SpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public List<SpaService> getSpaService(){
        return SpaServiceService.getSpaService();
    }
    @PostMapping
    public void registerNewSpaService(@RequestBody SpaService spaService){
        SpaServiceService.addNewSpaService(spaService);
    }
    @DeleteMapping(path = "{spaServiceId}")
    public void deleteSpaService(
            @PathVariable("spaServiceId") Long spaServiceId){
        SpaServiceService.deleteSpaService(spaServiceId);
    }
}
