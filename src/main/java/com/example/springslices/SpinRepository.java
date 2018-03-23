package com.example.springslices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpinRepository extends JpaRepository<Spin, Long>{
    @Query("select c from Spin c having max(c.timestamp) order by c.timestamp")
    Spin findCurrent();
}
