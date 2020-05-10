package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.Recommendations;
import com.wearablehealth.wearablehealth.services.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")
public class RecommendationsController {
    @Autowired
    RecommendationsService recommendationsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Recommendations recommendations){
        return recommendationsService.insert(recommendations);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Recommendations recommendations){
        return recommendationsService.update(recommendations);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        return recommendationsService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return recommendationsService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") int id){return recommendationsService.getOne(id);}

    @GetMapping("/getAllOf/{id}")
    public ResponseEntity<Object> getAllOf(@PathVariable("id") String id){return recommendationsService.getAllOf(id);}
}
