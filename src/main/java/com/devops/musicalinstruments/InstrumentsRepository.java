package com.devops.musicalinstruments;

import com.devops.musicalinstruments.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentsRepository extends JpaRepository<Instrument, Long> {
}
