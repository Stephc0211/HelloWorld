package com.example.helloworld.homework.bean;

public class Fruit {

    private String FruitName;

    private int FruitImageUrl;

    public Fruit(String fruitName, int fruitImageUrl) {
        FruitName = fruitName;
        FruitImageUrl = fruitImageUrl;
    }

    public String getFruitName() {
        return FruitName;
    }

    public void setFruitName(String fruitName) {
        FruitName = fruitName;
    }

    public int getFruitImageUrl() {
        return FruitImageUrl;
    }

    public void setFruitImageUrl(int fruitImageUrl) {
        FruitImageUrl = fruitImageUrl;
    }
}
