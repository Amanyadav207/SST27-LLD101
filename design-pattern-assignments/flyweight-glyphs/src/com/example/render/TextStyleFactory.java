package com.example.render;

import java.util.HashMap;
import java.util.Map;
public class TextStyleFactory {
    private static final HashMap<String,TextStyle>cache = new HashMap<>();
    
    public static TextStyle getStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "N");
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    } 
    
}
