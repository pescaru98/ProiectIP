package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.SensorMeasurements;
import com.wearablehealth.wearablehealth.repositories.SensorMeasurementsRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorMeasurementsService {

    @Autowired
    SensorMeasurementsRepository sensorMeasurementsRepository;

    public ResponseEntity<Object> insert(SensorMeasurements sensorMeasurements) {
        try {
             sensorMeasurementsRepository.insert(sensorMeasurements);
             return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getLatestOf(String id) {
        try{
            Optional<SensorMeasurements> optional = sensorMeasurementsRepository.getLatestOf(id);
            if(optional.isPresent())
                return new ResponseEntity<>(optional.get(),HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAllOf(String id) {
        try{
            List<SensorMeasurements> list = sensorMeasurementsRepository.getAllOf(id);
            if(list != null && !list.isEmpty())
                return new ResponseEntity<>(list,HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }
}
