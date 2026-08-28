/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

/**
 *
 * @author konriato
 */
public class Sprite {
    private char[] symbols;
    
    char getSymbolByRadians(float angle) {
        
    }
    
    char[] getSymbols() {
        return this.symbols;
    }
    
    void setSymbols(char[] symbols) throws EmptySymbolArrayException {
        if (symbols.length > 0) {
            this.symbols = symbols;
        }
        else {
            throw new EmptySymbolArrayException();
        }
    }

    private static class EmptySymbolArrayException extends Exception {

        public EmptySymbolArrayException() {
        }
    }
}
