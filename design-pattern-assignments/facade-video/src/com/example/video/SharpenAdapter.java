package com.example.video;

import java.util.HashMap;
import java.util.Map;


public class SharpenAdapter {
    private final LegacySharpen legacy;
   
    private static final Map<String, Frame[]> STORE = new HashMap<>();
    private static int SEQ = 1;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = legacy;
    }

    public Frame[] apply(Frame[] frames, int strength) {
        
        String inHandle = toHandle(frames);
        String outHandle = legacy.applySharpen(inHandle, strength);

        
        STORE.put(outHandle, frames);

        return fromHandle(outHandle);
    }

    private String toHandle(Frame[] frames) {
        String h = "H" + (SEQ++);
        STORE.put(h, frames);
        return h;
    }

    private Frame[] fromHandle(String handle) {
        return STORE.getOrDefault(handle, new Frame[0]);
    }
}
