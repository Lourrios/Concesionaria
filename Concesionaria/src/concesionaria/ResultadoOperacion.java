/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionaria;

import java.io.Serializable;

/**
 *
 * @author Lourdes
 */
public class ResultadoOperacion implements Serializable{

    private EstadoOperacion estado;
    private String mensajeError;

    public ResultadoOperacion() {
    }

    public ResultadoOperacion(EstadoOperacion estado, String mensajeError) {
        this.estado = estado;
        this.mensajeError = mensajeError;
    }

    public EstadoOperacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperacion estado) {
        this.estado = estado;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public String toString() {
        return "ResultadoOperacion" + "estado=" + estado + ", mensajeError=" + mensajeError ;
    }


}
