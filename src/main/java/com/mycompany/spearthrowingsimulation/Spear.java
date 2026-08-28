/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

import static java.lang.Math.atan2;

/**
 *
 * @author pirat
 */
public class Spear extends Body {
    private Sprite sprite;
    
    public Spear() {
        super(1f, 0.0007f, 0.15f);
        char[] symbols = {'-', '/', '|', '\\', '-', '/', '|', '\\'};
        try {
            this.sprite = new Sprite(symbols);
        }
        catch (Sprite.EmptySymbolsArrayException e) {
            this.sprite = null;
            System.out.println(e.toString());
            System.exit(e.hashCode());
        }
    }
    
    public char getSymbol() {
        float angleInRadians = (float) atan2(this.vel.y, this.vel.x);
        return this.sprite.getSymbolByRadians(angleInRadians);
    }
}
