package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int boost;

    public SpeedBoost(Character wrapped, int boost) {
        super(wrapped);
        this.boost = boost;
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + boost;
    }

    @Override
    public void move() {
        System.out.println("Moving at boosted speed " + getSpeed() + " with sprite " + getSprite());
    }
}
