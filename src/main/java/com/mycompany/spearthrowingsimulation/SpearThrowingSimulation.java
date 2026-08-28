/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.spearthrowingsimulation;

/**
 *
 * @author konriato
 */
public class SpearThrowingSimulation {

    public static void main(String[] args) {
        Program program = new Program(30);
        //program.createFrame(1280, 720);
        program.inputInitialAngle();
        program.inputInitialVelocity();
        program.displayRender();
    }
}
