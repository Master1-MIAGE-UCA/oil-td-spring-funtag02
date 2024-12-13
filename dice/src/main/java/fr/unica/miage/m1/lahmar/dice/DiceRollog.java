package fr.unica.miage.m1.lahmar.dice;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class DiceRollog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int diceCount;

    @ElementCollection
    @Column
    private List<Integer> dices;

    @Column
    private LocalDateTime timestamp;
}
