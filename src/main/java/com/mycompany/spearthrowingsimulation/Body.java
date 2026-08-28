/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

/**
 *
 * @author pirat
 */
public class Body {
    public final Vec2 pos;
    public final Vec2 vel;
    private float mass;
    private float area;
    private float dragCoefficient;

    public Body(float mass, float area, float dragCoefficient) {
        this.pos = new Vec2(0,0);
        this.vel = new Vec2(0,0);
        this.mass = mass;
        this.area = area;
        this.dragCoefficient = dragCoefficient;
    }
    
    private void updatePos(float deltaTime) {
        this.pos.x += this.vel.x * deltaTime;
        this.pos.y += this.vel.y * deltaTime;
    }
    
    private void updateVel(Vec2[] forces, float deltaTime) {
        for (Vec2 force : forces) {
            this.vel.x += force.x * deltaTime;
            this.vel.y += force.y * deltaTime;
        }
    }
    
    public void updateVelAndPos(Vec2[] forces, float deltaTime) {
        this.updatePos(deltaTime);
        this.updateVel(forces, deltaTime);
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getDragCoefficient() {
        return dragCoefficient;
    }

    public void setDragCoefficient(float dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }
}
