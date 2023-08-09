package com.devops.musicalinstruments.controllers;

import com.devops.musicalinstruments.model.Instrument;
import com.devops.musicalinstruments.services.CRUDInstrumentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "api/v1/instruments")
public class InstrumentController {

    private final CRUDInstrumentsService crudInstrumentsService;

    public InstrumentController(CRUDInstrumentsService crudInstrumentsService){
        this.crudInstrumentsService = crudInstrumentsService;
    }

    @PostMapping
    public ResponseEntity<String> addInstrument(@RequestBody Instrument instrument){
        try{
            crudInstrumentsService.addInstrument(instrument);
            return new ResponseEntity<>("Instrument added to DB", HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Instrument>> getInstrumentById(@PathVariable Long id){
        try{
            Optional<Instrument> instrumentFound = crudInstrumentsService.getInstrumentById(id);
            if(instrumentFound.isEmpty()){
                return new ResponseEntity<>(instrumentFound,  HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(instrumentFound, HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Instrument>> getAllInstruments(){
        try{
            List<Instrument> instrumentsFetched = crudInstrumentsService.getAllInstruments();
            return new ResponseEntity<>(instrumentsFetched, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateInstrument(@RequestBody Instrument instrument){
        try{
            Boolean instrumentUpdated = crudInstrumentsService.updateInstrument(instrument);
            if(!instrumentUpdated){
                return new ResponseEntity<>("Instrument does not exist on the DB, so it can not being updated", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Instrument updated!", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstrument(@PathVariable Long id){
        try{
            Boolean elementIsDeleted = crudInstrumentsService.deleteInstrument(id);
            if(!elementIsDeleted){
                return new ResponseEntity<>("Instrument does not exist on the DB, so it can not being deleted", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Instrument deleted!", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
