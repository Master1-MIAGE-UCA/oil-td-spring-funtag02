package fr.unica.miage.m1.lahmar.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/rollDice")
    public int rollDice() {
        Face faceObtenue = Dice.throwDice();
        return faceObtenue.getValue();
    }

    public int[] rollNDices(int n) {

        int[] facesValues = new int[n];

        for (int i = 0; i < n; i++) {
            rollDice();
            facesValues[i] = Dice.throwDice().getValue();
        }

        return facesValues;
    }

    @GetMapping("/rollDice/{n}")
    public String rollNDicesToString(@PathVariable int n) {
        int[] intValues = rollNDices(n);
        String stringToReturn = "";

        for (int i = 0; i < n; i++) {

            stringToReturn += intValues[i];

            if (i != n - 1) {
                stringToReturn += " ------ ";
            }
        }

        return stringToReturn;
    }


}
