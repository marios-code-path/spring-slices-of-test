package com.example.springslices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpinRepository extends JpaRepository<Spin, Long> {



    Spin findFirstByDirection(Directions d);
}
