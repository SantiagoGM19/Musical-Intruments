package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.repositories.InstrumentRepository;
import com.devops.musicalinstruments.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUDInstrumentsServiceImpl implements CRUDInstrumentsService{

    private final InstrumentRepository instrumentRepository;

    public CRUDInstrumentsServiceImpl(InstrumentRepository instrumentRepository){
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    @Override
    public Optional<Instrument> getInstrumentById(Long id) {
        return instrumentRepository.findById(id);
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @Override
    public Boolean updateInstrument(Instrument instrument) {
        Boolean instrumentUpdated= false;
        if(instrumentRepository.existsById(instrument.getId())){
            instrumentRepository.save(instrument);
            instrumentUpdated = true;
        }
        return instrumentUpdated;
    }

    @Override
    public Boolean deleteInstrument(Long id) {
        Boolean elementDeleted = false;
        if(instrumentRepository.existsById(id)){
            instrumentRepository.deleteById(id);
            elementDeleted=true;
        }
        return elementDeleted;
    }
}
