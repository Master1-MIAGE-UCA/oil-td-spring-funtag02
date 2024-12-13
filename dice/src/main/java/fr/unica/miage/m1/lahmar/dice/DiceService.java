package fr.unica.miage.m1.lahmar.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class DiceService {

    @Autowired
    private DiceRepository diceRepository;

    public int rollDice() {
        Face faceObtenue = Dice.throwDice();
        int valeurObtenue = faceObtenue.getValue();
        saveRollToRepository(valeurObtenue);
        return valeurObtenue;
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

    /*
    public DiceRollog saveDiceRollog(int diceCount, List<Integer> dices) {
        DiceRollog diceRollog = new DiceRollog();
        diceRollog.setDiceCount(diceCount);
        diceRollog.setDices(dices);
        diceRollog.setTimestamp(LocalDateTime.now());

        return diceRepository.save(diceRollog);
    }

     */

    public void saveRollToRepository(int result) {

        DiceRollog diceRollog = new DiceRollog();

        // jsp pourquoi ça marche pas
        List<Integer> newDicesList = new ArrayList<>(diceRollog.getDices());
        newDicesList.add(result);
        diceRollog.setDices(newDicesList);

        diceRollog.setDiceCount(diceRollog.getDiceCount() + 1);
        diceRollog.setTimestamp(LocalDateTime.now());
        diceRepository.save(diceRollog);
    }

    public String getAllLogsFromDiceRollog(DiceRollog diceRollog) {
        StringBuilder logDetails = new StringBuilder();
        logDetails.append("ID: ").append(diceRollog.getId()).append("\n");
        logDetails.append("Dice Count: ").append(diceRollog.getDiceCount()).append("\n");
        logDetails.append("Dices: ").append(diceRollog.getDices().toString()).append("\n");
        logDetails.append("Timestamp: ").append(diceRollog.getTimestamp()).append("\n");
        return logDetails.toString();
    }

    public List<DiceRollog> getAllDiceRollogs() {
        return diceRepository.findAll();
    }

    public String getAllDiceLogs() {
        List<DiceRollog> diceRollogs = getAllDiceRollogs();
        StringBuilder allLogs = new StringBuilder();

        for (DiceRollog diceRollog : diceRollogs) {
            allLogs.append(getAllLogsFromDiceRollog(diceRollog)).append("\n");
        }

        return allLogs.toString();
    }

}
