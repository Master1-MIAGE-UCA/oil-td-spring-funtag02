package fr.unica.miage.m1.lahmar.dice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRepository extends JpaRepository<DiceRollog, Long>{
    // DiceRollog findById(int id);


}
