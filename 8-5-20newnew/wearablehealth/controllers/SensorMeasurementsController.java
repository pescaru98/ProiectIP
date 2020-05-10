package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.SensorMeasurements;
import com.wearablehealth.wearablehealth.services.SensorMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensormeasure")
public class SensorMeasurementsController {

    @Autowired
    SensorMeasurementsService sensorMeasurementsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody SensorMeasurements sensorMeasurements) {
        return sensorMeasurementsService.insert(sensorMeasurements);
    }

    @GetMapping("/getLatestOf/{id}")
    public ResponseEntity<Object> getLatestOf(@PathVariable("id") String id){
        return sensorMeasurementsService.getLatestOf(id);
    }

    @GetMapping("/getAllOf/{id}")
    public ResponseEntity<Object> getAllOf(@PathVariable("id") String id){
        return sensorMeasurementsService.getAllOf(id);
    }

    //getAllOfPacientInInterval

}
