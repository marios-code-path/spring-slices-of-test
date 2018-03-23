package com.example.springslices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpinRestController {


    private final SpinRepository spinRepository;

    public SpinRestController(SpinRepository spinRepository) {
        this.spinRepository = spinRepository;
    }

    @GetMapping("/now")
    public Spin getNow() {
        return spinRepository.findCurrent();
    }
}
