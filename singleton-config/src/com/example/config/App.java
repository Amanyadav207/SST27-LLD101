package com.example.config;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        String path = args.length > 0 ? args[0] : "app.properties";
        AppSettings.getInstance().loadFromFile(Path.of(path)); // not thread-safe, re-loadable
        System.out.println("app.name=" + AppSettings.getInstance().get("app.name"));
        System.out.println("instance=" + System.identityHashCode(AppSettings.getInstance()));

        // Singleton check: hash codes should be the same
        int hash1 = System.identityHashCode(AppSettings.getInstance());

        int hash2 = System.identityHashCode(AppSettings.getInstance());
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println("Singleton test: " + (hash1 == hash2 ? "PASS" : "FAIL"));
    }
}
