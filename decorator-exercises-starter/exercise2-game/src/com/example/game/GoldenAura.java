package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character wrapped) {
        super(wrapped);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + 2; // small buff
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 5; // small buff
    }

    @Override
    public String getSprite() {
        return "golden_" + super.getSprite();
    }

    @Override
    public void move() {
        System.out.println("✨ Golden aura surrounds you ✨");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("✨ Golden aura empowers your attack ✨");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}
