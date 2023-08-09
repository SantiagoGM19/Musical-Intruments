package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.InstrumentsRepository;
import com.devops.musicalinstruments.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUDInstrumentsServiceImpl implements CRUDInstrumentsService{

    private final InstrumentsRepository instrumentsRepository;

    public CRUDInstrumentsServiceImpl(InstrumentsRepository instrumentsRepository){
        this.instrumentsRepository =  instrumentsRepository;
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instrumentsRepository.save(instrument);
    }

    @Override
    public Optional<Instrument> getInstrumentById(Long id) {
        return instrumentsRepository.findById(id);
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentsRepository.findAll();
    }

    @Override
    public Boolean updateInstrument(Instrument instrument) {
        Boolean instrumentUpdated= false;
        if(instrumentsRepository.existsById(instrument.getId())){
            instrumentsRepository.save(instrument);
            instrumentUpdated = true;
        }
        return instrumentUpdated;
    }

    @Override
    public Boolean deleteInstrument(Long id) {
        Boolean elementDeleted = false;
        if(instrumentsRepository.existsById(id)){
            instrumentsRepository.deleteById(id);
            elementDeleted=true;
        }
        return elementDeleted;
    }
}
