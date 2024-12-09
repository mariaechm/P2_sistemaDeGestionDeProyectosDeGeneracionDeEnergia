/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models.enumerator;

/**
 *
 * @author maria-chuico
 */

public enum TipoProyecto {
    SOLAR("SOLAR"), EOLICO("EOLICO"), HIDROELECTRICO("HIDROELECTRICO"), TERMOELECTRICO("TERMOELECTRICO");
    private String name;

    //Constructor
    TipoProyecto(String name) {
        this.name = name;
    }
    
    //Getter
    public String getName() {
        return name;
    }
}
