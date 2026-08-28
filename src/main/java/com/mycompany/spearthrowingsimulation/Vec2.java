/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

/**
 *
 * @author pirat
 */
public class Vec2 {
    public float x;
    public float y;
    
    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Vec2() {
        this.x = this.y = 0;
    }
    
    public void copy(Vec2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    public Vec2 add(Vec2 v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }
    
    public Vec2 sub(Vec2 v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }
    
    public Vec2 mult(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }
    
    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public void normalize() {
        float len = this.length();
        this.x /= len;
        this.y /= len;
    }
}
