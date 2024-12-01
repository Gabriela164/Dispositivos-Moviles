package com.example.menuy3puntitos;

public class PromoItem {
    private final String title;
    private final String description;
    private final String descuento;
    private final int imageResource;

    public PromoItem(String title, String description, String descuento, int imageResource) {
        this.title = title;
        this.description = description;
        this.descuento = descuento;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDescuento() {
        return descuento;
    }

    public int getImageResource() {
        return imageResource;
    }
}

