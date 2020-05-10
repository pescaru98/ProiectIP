package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.ManualMeasurements;
import com.wearablehealth.wearablehealth.services.ManualMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manualmeasurements")
public class ManualMeasurementsController {

    @Autowired
    ManualMeasurementsService manualMeasurementsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody ManualMeasurements manualMeasurements){
        return manualMeasurementsService.insert(manualMeasurements);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ManualMeasurements manualMeasurements){
        return manualMeasurementsService.update(manualMeasurements);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        return manualMeasurementsService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return manualMeasurementsService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") int id){return manualMeasurementsService.getOne(id);}

    @GetMapping("/getAllOf/{id}")
    public ResponseEntity<Object> getAllOf(@PathVariable("id") String id){return manualMeasurementsService.getAllOf(id);}
}
