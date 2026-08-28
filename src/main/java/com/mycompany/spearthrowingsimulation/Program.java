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
    private JFrame frame;
    private JLabel renderOutputLabel;

    public Program(int framerate) {
        this.framerate = framerate;
        this.simulation = new Simulation(new Vec2(0, -9.81f), 1.225f);
        this.renderer = new Renderer(200, 40, 10);
        this.scanner = new Scanner(System.in);
        this.frame = null;
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
        this.frame = new JFrame();
        this.frame.setSize(frameWidth, frameHeight);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.renderOutputLabel = new JLabel();
        this.frame.add(this.renderOutputLabel);
    }
    
    public void displayRender() {
        if (this.frame == null) return;
        
        this.render();
        String frameOutput = this.renderer.getFrameAsString();
        this.renderOutputLabel.setText(frameOutput);
        this.frame.update(this.frame.getGraphics());
    }
}
