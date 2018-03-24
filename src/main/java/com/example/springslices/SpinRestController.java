package com.example.springslices;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SpinRestController {
    private final SpinRepository spinRepository;

    public SpinRestController(SpinRepository spinRepository) {
        this.spinRepository = spinRepository;
    }

    @GetMapping(value="/spins", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<Spin> getAll() {
        return spinRepository.findAll();//.findFirstByDirection(Directions.CHARM);
    }
}
