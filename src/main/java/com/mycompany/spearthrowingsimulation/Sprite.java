/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

import static java.lang.Math.PI;

/**
 * Class that stores a collection of symbols representing an object at angles
 * 0 inclusive to 2*PI exclusive.
 * @author konriato
 */
public class Sprite {
    private char[] symbols;
    
    public Sprite(char[] symbols) throws EmptySymbolsArrayException {
        this.symbols = symbols;
        if (symbols.length <= 0) {
            throw new EmptySymbolsArrayException();
        }
    }
    
    char getSymbolByRadians(float angleInRadians) {
        while (angleInRadians < 0) {
            angleInRadians += 2*PI;
        }
        int index = (int) Math.round(angleInRadians/(2*PI) * this.symbols.length);
        return this.symbols[index];
    }
    
    char[] getSymbols() {
        return this.symbols;
    }
    
    void setSymbols(char[] symbols) throws EmptySymbolsArrayException {
        if (symbols.length > 0) {
            this.symbols = symbols;
        }
        else {
            throw new EmptySymbolsArrayException();
        }
    }

    public static class EmptySymbolsArrayException extends Exception {
        public EmptySymbolsArrayException() {
        }
    }
}
