package com.nomadspa.backend.SpaServiceCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="api/v1/SpaServiceCatalog")
public class SpaServiceCatalogController{
    private final SpaServiceCatalogService SpaServiceCatalogService;
    @Autowired
    public SpaServiceCatalogController(com.nomadspa.backend.SpaServiceCatalog.SpaServiceCatalogService spaServiceCatalogService) {
        SpaServiceCatalogService = spaServiceCatalogService;
    }
    @GetMapping
    public List<SpaServiceCatalog> getSpaServiceCatalog(){
        return SpaServiceCatalogService.getSpaServiceCatalog();
    }
    @PostMapping
    public void registerNewSpaServiceCatalog(@RequestBody SpaServiceCatalog spaServiceCatalog){
        SpaServiceCatalogService.addNewSpaServiceCatalog(spaServiceCatalog);
    }
    @DeleteMapping(path = "{spaServiceCatalogId}")
    public void deleteSpaServiceCatalog(
            @PathVariable("spaServiceCatalogId") Long spaServiceCatalogId){
        SpaServiceCatalogService.deleteSpaServiceCatalog(spaServiceCatalogId);
    }
    @PutMapping(path = "{spaServiceCatalogId}")
    public void updateSpaServiceCatalog(@PathVariable("spaServiceCatalogId") Long spaServiceCatalogId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) double commission,
                              @RequestParam(required = false) double price,
                                        @RequestParam(required = false) LocalTime duration){
        SpaServiceCatalogService.updateSpaServiceCatalog(spaServiceCatalogId,name,price,commission,duration);
    }
}
