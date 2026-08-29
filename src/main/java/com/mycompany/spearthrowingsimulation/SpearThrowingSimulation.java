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
        Program program = new Program( 60 );
        program.inputInitialAngle();
        program.inputInitialVelocity();
        try {
            program.simulate();
        }
        catch (Exception e) {
            System.out.println("execucao interrompida");
            e.printStackTrace();
        }
    }
}
