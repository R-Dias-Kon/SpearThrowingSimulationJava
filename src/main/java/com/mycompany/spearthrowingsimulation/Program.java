/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spearthrowingsimulation;

import static java.lang.Math.toRadians;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author pirat
 */
public class Program {
    private Simulation simulation;
    private Renderer renderer;
    private float framerate;
    private Scanner scanner;
    private ProgramGUI gui;

    public Program(int framerate) {
        this.framerate = framerate;
        this.simulation = new Simulation(new Vec2(0, -9.81f), 2f);
        this.renderer = new Renderer(100, 24, 25);
        this.scanner = new Scanner(System.in);
        this.gui = null;
    }
    
    public void inputInitialAngle() {
        System.out.print("Input initial angle: ");
        this.simulation.setSpearAngle((float) toRadians(this.scanner.nextFloat()));
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
    
    private void createFrame(int frameWidth, int frameHeight) {
        this.gui = new ProgramGUI();
        this.gui.setVisible(true);
    }
    
    private void displayRender() {
        //if (this.gui == null) return;
        
        this.render();
        String frameOutput = this.renderer.getFrameAsString();
        
        this.gui.outputTextArea.setText(frameOutput);
        
        //System.out.print(frameOutput);
    }
    
    public void updateHUD() {
        this.gui.xPositionLabel.setText(String.valueOf(this.simulation.getSpearPosX()));
        System.out.println(this.simulation.getSpearPosX());
        this.gui.yPositionLabel.setText(String.valueOf(this.simulation.getSpearPosY()));
    }
    
    public void simulate() throws InterruptedException {
        
        this.createFrame(1280, 720);
        
        long frames = 0;
        float deltaTime = 0;
        while (this.simulation.getSpearPosY() > 0 || frames < 10) {
            long startTime = System.currentTimeMillis();
            
            // logica por frame --------------
            this.updateSimulation(deltaTime);
            this.displayRender();
            this.updateHUD();
            
            // -------------------------------
            
            while (System.currentTimeMillis() - startTime < 1/this.framerate * 1000) {
                Thread.sleep(1);
            }
            deltaTime = 1/this.framerate;
            ++frames;
        }
    } 
}
