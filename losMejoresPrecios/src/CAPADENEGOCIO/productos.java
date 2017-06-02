/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAPADENEGOCIO;

/**
 *
 * @author DAVID
 */
public class productos {
    private int idProducto;
    private String descripcion;
    private int idCategoria;
    private float preciocompra;
    private float precioventa;
    private int existencia;
    private String garantia;
    private String accion;

    public productos(){
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(float preciocompra) {
        this.preciocompra = preciocompra;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    
    
}
