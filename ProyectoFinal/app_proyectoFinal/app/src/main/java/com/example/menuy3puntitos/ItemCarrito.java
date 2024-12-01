package com.example.menuy3puntitos;

public class ItemCarrito {
    private final String title;
    private final String precio;

    public ItemCarrito(String title, String precio) {
        this.title = title;
        this.precio = precio;
    }

    public String getTitle() {
        return title;
    }

    public String getPrecio() {
        return precio;
    }
}

