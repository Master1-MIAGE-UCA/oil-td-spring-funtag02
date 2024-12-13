package fr.unica.miage.m1.lahmar.dice;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class Dice {
    public static Face throwDice() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(6);

        return Face.values()[randomIndex];
    }

    /*
    public static void main(String[] args) {
        Face result = throwDice();
        System.out.println("You rolled : " + result + " (Value : " + result.getValue() + ")");
    }
    */
}