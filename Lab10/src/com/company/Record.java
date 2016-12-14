package com.company;

/**
 * Created by lhscompsci on 12/14/16.
 */
public class Record {
    private int frequency = 0;
    private char letter ='A';

    public Record() {
        frequency = this.frequency;
        letter = this.letter;
    }
    public Record(int frequency, char letter) {
        this.frequency = frequency;
        this.letter = letter;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getLetter() {
        return letter;
    }

    public void incrementFrequency() {
        this.frequency++;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

}
