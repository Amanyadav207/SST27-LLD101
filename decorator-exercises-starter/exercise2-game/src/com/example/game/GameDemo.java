package com.example.game;

public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        // a) Base + SpeedBoost + DamageBoost
        System.out.println("\n--- Buffed (Speed + Damage) ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();

        // b) Add GoldenAura
        System.out.println("\n--- With GoldenAura ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();

        // c) Remove GoldenAura by recomposing
        System.out.println("\n--- Without Aura (recomposed) ---");
        Character withoutAura = buffed; // just reuse original chain
        withoutAura.move();
        withoutAura.attack();
    }
}
