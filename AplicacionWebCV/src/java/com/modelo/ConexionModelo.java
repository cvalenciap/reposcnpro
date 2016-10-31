
package com.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConexionModelo {
    private static ConexionModelo conexion;
    private EntityManagerFactory fabricaConexion;
    
    private ConexionModelo(){
        fabricaConexion = Persistence.createEntityManagerFactory("AplicacionWebCVPU");
    }
    
    public static ConexionModelo getConexion(){
        if(conexion == null){
            conexion = new ConexionModelo();
        }
        return conexion;
    }

    public EntityManagerFactory getFabricaConexion() {
        return fabricaConexion;
    }
}
