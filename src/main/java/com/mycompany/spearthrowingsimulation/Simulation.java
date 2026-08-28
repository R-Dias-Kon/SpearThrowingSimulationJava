/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

/**
 *
 * @author pirat
 */
public class Simulation {
    private final Spear spear;
    private final Vec2 gravity;
    private float airDensity;

    public Simulation(Vec2 gravity, float airDensity) {
        this.spear = new Spear();
        this.gravity = gravity;
        this.airDensity = airDensity;
    }
    
    public Vec2 getDragForce(Body body) {
        float speed = body.vel.length();
        float k = 1/2 * this.airDensity * body.getDragCoefficient() * body.getArea() * speed;
        return new Vec2(-k * body.vel.x, -k * body.vel.y);
    }
    
    public void update(float deltaTime) {
        Vec2[] forces = {this.gravity, this.getDragForce(spear)};
        this.spear.updateVelAndPos(forces, deltaTime);
    }
    
    public float getSpearPosX() {
        return this.spear.pos.x;
    }
    
    public float getSpearPosY() {
        return this.spear.pos.y;
    }
    
    public char getSpearSymbol() {
        return this.spear.getSymbol();
    }
    
    public void setSpearVelocity(float velocity) {
        this.spear.vel.normalize();
        this.spear.vel.mult(velocity);
    }
    
    public void setSpearAngle(float angleInRadians) {
        float velocity = this.spear.vel.length();
        this.spear.vel.x = (float) Math.cos(angleInRadians);
        this.spear.vel.y = (float) Math.sin(angleInRadians);
        this.spear.vel.mult(velocity);
    }
}
