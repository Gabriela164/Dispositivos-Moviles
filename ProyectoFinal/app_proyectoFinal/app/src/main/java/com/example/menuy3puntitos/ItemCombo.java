package com.example.menuy3puntitos;

public class ItemCombo {
    private final String title;
    private final String description;
    private final int imageResource;

    public ItemCombo(String title, String description, int imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}

