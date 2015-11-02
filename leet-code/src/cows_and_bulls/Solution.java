package cows_and_bulls;

import java.util.HashMap;

// Mastermind-like game. Given a secret and a guess, returns the number
// of characters correctly guessed, and number of characters that are part of secret
// but not in the guessed place
public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> mapSecret = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapGuess = new HashMap<>();
        int correct = 0;
        char s, g;
        
        for (int i = 0; i < secret.length(); i++) {
            s = secret.charAt(i);
            g = guess.charAt(i);
            if(s == g) {
                correct++;
            } else {
                if(mapSecret.containsKey(s)) {
                    mapSecret.put(s, mapSecret.get(s) + 1);
                } else {
                    mapSecret.put(s, 1);
                }
                if(mapGuess.containsKey(g)) {
                    mapGuess.put(g, mapGuess.get(g) + 1);
                } else {
                    mapGuess.put(g, 1);
                }
            }
        }
        int outOfPlace = 0;
        int countSecret, countGuess;
        for (Character key : mapSecret.keySet()) {
            countSecret = mapSecret.get(key);
            if(mapGuess.containsKey(key)) {
                countGuess = mapGuess.get(key);
                outOfPlace += Math.min(countSecret, countGuess);
            }
        }
        return String.format("%dA%dB", correct, outOfPlace);
    }
}