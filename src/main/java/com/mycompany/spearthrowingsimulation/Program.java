/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author pirat
 */
public class Program {
    private Simulation simulation;
    private Renderer renderer;
    private int framerate;
    private Scanner scanner;
    private ProgramGUI gui;

    public Program(int framerate) {
        this.framerate = framerate;
        this.simulation = new Simulation(new Vec2(0, -9.81f), 1.225f);
        this.renderer = new Renderer(150, 20, 15);
        this.scanner = new Scanner(System.in);
        this.gui = null;
    }
    
    public void inputInitialAngle() {
        System.out.print("Input initial angle: ");
        this.simulation.setSpearAngle(this.scanner.nextFloat());
    }
    
    public void inputInitialVelocity() {
        System.out.print("Input initial velocity: ");
        this.simulation.setSpearVelocity(this.scanner.nextFloat());
    }
    
    private void updateSimulation(float deltaTime) {
        this.simulation.update(deltaTime);
    }
    
    private void render() {
        float x = this.simulation.getSpearPosX();
        float y = this.simulation.getSpearPosY();
        char symbol = this.simulation.getSpearSymbol();
        this.renderer.render(x, y, symbol);
    }
    
    public void createFrame(int frameWidth, int frameHeight) {
        this.gui = new ProgramGUI();
        this.gui.setVisible(true);
    }
    
    public void displayRender() {
        //if (this.gui == null) return;
        
        this.render();
        char[] frameOutput = this.renderer.getFrame();
        System.out.print(frameOutput);
    }
}
