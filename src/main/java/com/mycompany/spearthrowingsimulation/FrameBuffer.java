/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

/**
 * Frame-buffer composed of 'lines' separated by newline character.
 * Ends with terminator.
 * 
 * @author pirat
 */
public class FrameBuffer {
    private final int columns;
    private final int lines;
    private final char[] buffer;

    public FrameBuffer(int columns, int lines) {
        this.columns = columns;
        this.lines = lines;
        this.buffer = new char[lines * (columns+1)];
        for (int i = columns; i < this.buffer.length; i += columns+1) {
            this.buffer[i] = '\n';
        }
        this.buffer[this.buffer.length-1] = '\0';
    }
    
    public void draw(int line, int column, char symbol) {
        this.buffer[line*(this.columns+1) + column] = symbol;
    }
    
    public char getSymbol(int line, int column) {
        // TODO: jogar erro se o lugar for out of bounds
        return this.buffer[line*(this.columns+1) + column];
    }
    
    public char[] getFrame(){
        return this.buffer;
    }
    
    public String getFrameAsString() {
        return new String(this.buffer);
    }
    
    public void drawAll(char symbol){
        for (int i = 0; i < this.buffer.length; ++i) {
            if ((i+1) % (this.columns+1) != 0) {
                this.buffer[i] = symbol;
            }
            else {
                this.buffer[i] = '\n';
            }
        }
    }
    
    public void drawLine(char symbol, int line) {
        for (int i = 0; i < this.columns; ++i) {
            this.buffer[line*(columns+1) + i] = symbol;
        }
    }
    
    public void drawColumn(char symbol, int column) {
        for (int i = 0; i < this.lines; ++i) {
            this.buffer[column + i*(this.columns+1)] = symbol;
        }
    }
}
