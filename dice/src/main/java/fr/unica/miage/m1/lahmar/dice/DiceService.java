package fr.unica.miage.m1.lahmar.dice;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DiceService {

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
