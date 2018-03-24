package com.example.springslices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Just Another Data Object
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Spin {
    @Id
    @GeneratedValue
    Long id;
    Date timestamp;
    Directions direction;
}

enum Directions {
    UP,
    TOP,
    CHARM,
    DOWN,
    STRANGE,
    BOTTOM
}
