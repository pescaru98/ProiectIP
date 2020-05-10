package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.Doctors;
import com.wearablehealth.wearablehealth.entities.Pacients;
import com.wearablehealth.wearablehealth.repositories.DoctorsRepository;
import com.wearablehealth.wearablehealth.repositories.PacientsRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacientsService {
    @Autowired
    PacientsRepository pacientsRepository;

    @Autowired
    DoctorsRepository doctorsRepository;

    public ResponseEntity<Object> insert(Pacients pacients) {
        try{
            pacientsRepository.insert(pacients);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> update(Pacients pacients) {
        try{
            pacientsRepository.update(pacients);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(String id) {
        try{
            pacientsRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try{
            List<Pacients> list = pacientsRepository.getAll();
            if(list != null && !list.isEmpty())
                return new ResponseEntity<>(list, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getOne(String id) {
        try{
            Optional<Pacients> optional = pacientsRepository.getOne(id);
            if(optional.isPresent())
                return new ResponseEntity<>(optional, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAllDoctorsOf(String id) {
        try{
            List<String> allDoctorsOfPacient = pacientsRepository.getAllDoctorsOf(id);
            List<Doctors> doctorsList =  new ArrayList<>();
            if(allDoctorsOfPacient != null && !allDoctorsOfPacient.isEmpty()){
                for(String username:allDoctorsOfPacient){
                    Optional<Doctors> doctors = doctorsRepository.getOne(username);
                    if(doctors.isPresent())
                        doctorsList.add(doctors.get());
                }
                return new ResponseEntity<>(doctorsList,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }
}
