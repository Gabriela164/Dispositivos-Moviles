package com.example.menuy3puntitos;

public class ItemPedido {
    private final String title;
    private final String precio;
    private final String date;

    public ItemPedido(String title, String precio, String date) {
        this.title = title;
        this.precio = precio;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDate() {
        return date;
    }
}

