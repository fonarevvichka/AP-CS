// Vichka Fonarev
// 12/19/16
// F Block

package com.company;

public class Record implements Comparable <Record> {
    private int frequency = 0;
    private char letter ='A';
    private char associatedLetter = 'A';

    public Record() {
        frequency = this.frequency;
        letter = this.letter;
        associatedLetter = this.letter;
    }
    public Record(int frequency, char letter, char associatedLetter) {
        this.frequency = frequency;
        this.letter = letter;
        this.associatedLetter = associatedLetter;
    }
    public int getFrequency() {
        return frequency;
    }
    public char getLetter() {
        return letter;
    }
    public char getAssociatedLetter() {
        return this.associatedLetter;
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
    public void setAssociatedLetter(char associatedLetter) {
        this.associatedLetter = associatedLetter;
    }
    public boolean equals(Record object) {
        if(object.getFrequency() == this.getFrequency()) {
            if(object.getLetter() == this.getLetter())
                return true;
        }
        return  false;
    }
    public int compareTo(Record object) {
        return object.getFrequency() - this.getFrequency();
    }
}
