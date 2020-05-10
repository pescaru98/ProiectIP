package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.Alerts;
import com.wearablehealth.wearablehealth.services.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class AlertsController {
    @Autowired
    AlertsService alertsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Alerts alerts){
        return alertsService.insert(alerts);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Alerts alerts){
        return alertsService.update(alerts);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        return alertsService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return alertsService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") int id){return alertsService.getOne(id);}

    @GetMapping("/getAllOf/{id}")
    public ResponseEntity<Object> getAllOf(@PathVariable("id") String id){return alertsService.getAllOf(id);}
}
