package kz.prog.service;

import kz.prog.entity.Results;
import kz.prog.repository.ResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record ResultService(
        ResultRepository resultRepository
) {
    public void saveResults(Results results){
        resultRepository.save(results);

        log.info("{} saved !", results);
    }
}
