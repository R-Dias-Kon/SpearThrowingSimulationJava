/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

/**
 * Renderer that writes to a frame-buffer.
 * 
 * The rendered frame will have this layout:
 *  . . . . . -skySymbol 
 *  . . . / . -spearSymbol
 *  " " " " " -floorSymbol
 *  *     *   -floorMarkingsSymbol
 *            -emptySymbol
 *  (The final frame will not actually have the last empty line)
 * 
 * @author pirat
 */
public class Renderer {
    private final int columns;
    private final int lines;
    private final FrameBuffer framebuffer;
    private int floorMarkingsGap;
    
    private char skySymbol;
    private char floorSymbol;
    private char floorMarkingsSymbol;
    private char emptySymbol; // not truly blank, please...

    public Renderer(int columns, int lines, int floorMarkingsGap) {
        this.columns = columns;
        this.lines = lines;
        this.framebuffer = new FrameBuffer(columns, lines);
        this.floorMarkingsGap = floorMarkingsGap;
        
        this.skySymbol = ':';
        this.floorSymbol = '"';
        this.floorMarkingsSymbol = '*';
        this.emptySymbol = '.';
    }

    public void setSkySymbol(char skySymbol) {
        this.skySymbol = skySymbol;
    }

    public void setFloorSymbol(char floorSymbol) {
        this.floorSymbol = floorSymbol;
    }

    public void setFloorMarkingsSymbol(char floorMarkingsSymbol) {
        this.floorMarkingsSymbol = floorMarkingsSymbol;
    }

    public void setEmptySymbol(char emptySymbol) {
        this.emptySymbol = emptySymbol;
    }

    public int getColumns() {
        return columns;
    }

    public int getLines() {
        return lines;
    }

    public void setFloorMarkingsGap(int floorMarkingsGap) {
        this.floorMarkingsGap = floorMarkingsGap;
    }
    
    private void renderBackground() {
        this.framebuffer.drawAll(this.skySymbol);
        this.framebuffer.drawLine(this.emptySymbol, this.lines-1);
//        int pixels = this.columns * this.lines;
//        for (int i = 0; i < pixels; ++i) {
//            char symbol = this.skySymbol;
//            if (i/this.columns == this.lines-1) {
//                symbol = this.emptySymbol;
//            }
//            this.framebuffer.writeSymbol(i/this.columns, i%this.columns, symbol);
//        }
    }
    
    private void renderFloor(float y) {
        if (y <= this.lines - 2) {
            this.framebuffer.drawLine(this.floorSymbol, this.lines-2);
        }
//        
//        if (y > this.lines - 2) { return; }
//        for (int i = 0; i < this.columns; ++i) {
//            this.framebuffer.writeSymbol(lines, columns, skySymbol);
//            this.framebuffer[this.lines - 3][i] = this.floorSymbol;
//        }
    }
    
    private void renderSpear(float localX, float localY, char symbol) {
        if (localX > this.columns - 1 || localX < 0) return;
        if (localY > this.lines - 1 || localY < 0) return;
        this.framebuffer.draw(Math.round(localY), Math.round(localX), symbol);
        //this.framebuffer[(int) localY][(int) localX] = symbol;
    }
    
    private void renderFloorMarkings(float x) {
        int offset = ((int) x) % this.floorMarkingsGap;
        int i = offset;
        while (i < this.columns - 1) {
            this.framebuffer.draw(this.lines - 1, i, this.floorMarkingsSymbol);
            i += this.floorMarkingsGap;
        }
    }
    
    public void render(float spearX, float spearY, char spearSymbol) {
        this.renderBackground();
        
        this.renderFloor(spearY);
        
        float localSpearX = Math.round(spearX) % this.columns;
        float localSpearY = Math.round(spearY) % this.lines;
        this.renderSpear(localSpearX, localSpearY, spearSymbol);
        
        this.renderFloorMarkings(spearX);
    }
    
    public char[] getFrame() {
        return this.framebuffer.getFrame();
    }
    
    public String getFrameAsString() {
        return this.framebuffer.getFrameAsString();
    }
}
