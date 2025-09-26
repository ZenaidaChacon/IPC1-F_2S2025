/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zenai
 */
public class Dispositivo{
    private String marca;
    private String procesador;
    private int ramGB;

    public Dispositivo(String marca, String procesador, int ramGB) {
        this.marca = marca;
        this.procesador = procesador;
        this.ramGB = ramGB;
    }

    public String getMarca() {
        return marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    
    
    @Override
    public String toString() {
        return marca + " | " + procesador + " | " + ramGB + " GB RAM";
    }
}