package com.example.turismocolombia.Model;

import android.location.Location;
import android.media.Image;
import android.widget.ImageView;

public class LugarT {

    private String sitios_turisticos;
    private String descripci_n;
    private String ubicacion;
    private String localizacion;
    private String imagen;
    private String icono;

    public LugarT( String sitios_turisticos,
             String descripci_n,
             String ubicacion,
             String localizacion,
             String imagen,
             String icono){
        super();
        this.sitios_turisticos=sitios_turisticos;
        this.descripci_n=descripci_n;
        this.ubicacion=ubicacion;
        this.localizacion=localizacion;
        this.imagen=imagen;
        this.icono=icono;
    }

    public String getSitios_turisticos() {
        return sitios_turisticos;
    }

    public void setSitios_turisticos(String sitios_turisticos) {
        this.sitios_turisticos = sitios_turisticos;
    }

    public String getDescripci_n() {
        return descripci_n;
    }

    public void setDescripci_n(String descripci_n) {
        this.descripci_n = descripci_n;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
