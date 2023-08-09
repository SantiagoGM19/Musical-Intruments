package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.model.Instrument;

import java.util.List;
import java.util.Optional;

public interface CRUDInstrumentsService {
    void addInstrument(Instrument instrument);
    Optional<Instrument> getInstrumentById(Long id);
    List<Instrument> getAllInstruments();
    Boolean updateInstrument(Instrument instrument);
    Boolean deleteInstrument(Long id);
}
