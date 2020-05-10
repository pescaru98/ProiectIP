package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.MedicalData;
import com.wearablehealth.wearablehealth.repositories.MedicalDataRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalDataService {
    @Autowired
    MedicalDataRepository medicalDataRepository;

    public ResponseEntity<Object> insert(MedicalData medicalData) {
        try{
            medicalDataRepository.insert(medicalData);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> update(MedicalData medicalData) {
        try{
            medicalDataRepository.update(medicalData);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(int id) {
        try{
            medicalDataRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try{
            List<MedicalData> list = medicalDataRepository.getAll();
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
            Optional<MedicalData> optional = medicalDataRepository.getOne(id);
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
            List<MedicalData> list = medicalDataRepository.getAllOf(id);
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
