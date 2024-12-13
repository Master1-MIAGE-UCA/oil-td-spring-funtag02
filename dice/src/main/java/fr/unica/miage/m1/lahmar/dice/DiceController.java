package fr.unica.miage.m1.lahmar.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @Autowired
    private DiceService diceService;

    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.rollDice();
    }

    @GetMapping("/rollDice/{n}")
    public String rollNDicesToString(@PathVariable int n) {
        return diceService.rollNDicesToString(n);
    }

}
