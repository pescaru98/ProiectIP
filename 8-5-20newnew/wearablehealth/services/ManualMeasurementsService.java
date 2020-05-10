package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.ManualMeasurements;
import com.wearablehealth.wearablehealth.repositories.ManualMeasurementsRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManualMeasurementsService {
    @Autowired
    ManualMeasurementsRepository manualMeasurementsRepository;

    public ResponseEntity<Object> insert(ManualMeasurements manualMeasurements) {
        try{
            manualMeasurementsRepository.insert(manualMeasurements);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> update(ManualMeasurements manualMeasurements) {
        try{
            manualMeasurementsRepository.update(manualMeasurements);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(int id) {
        try{
            manualMeasurementsRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try{
            List<ManualMeasurements> list = manualMeasurementsRepository.getAll();
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
            Optional<ManualMeasurements> optional = manualMeasurementsRepository.getOne(id);
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
            List<ManualMeasurements> list = manualMeasurementsRepository.getAllOf(id);
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
