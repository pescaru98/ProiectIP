package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.Alerts;
import com.wearablehealth.wearablehealth.repositories.AlertsRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertsService {
    @Autowired
    AlertsRepository alertsRepository;

    public ResponseEntity<Object> insert(Alerts alerts) {
        try{
            alertsRepository.insert(alerts);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> update(Alerts alerts) {
        try{
            alertsRepository.update(alerts);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(int id) {
        try{
            alertsRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try{
            List<Alerts> list = alertsRepository.getAll();
            if(list != null && !list.isEmpty())
                return new ResponseEntity<>(list, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getOne(int id) {
        try{
            Optional<Alerts> optional = alertsRepository.getOne(id);
            if(optional.isPresent())
                return new ResponseEntity<>(optional, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAllOf(String id) {
        try{
            List<Alerts> list = alertsRepository.getAllOf(id);
            if(list != null && !list.isEmpty())
                return new ResponseEntity<>(list, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }
}
