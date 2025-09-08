package com.example.video;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade pipeline = new VideoPipelineFacade();

        Path in  = Path.of("in.mp4");
        Path out = Path.of("out.mp4");

        // Example run: grayscale + scale(0.5) + sharpen(3)
        Path result = pipeline.process(in, out, /*gray=*/true, /*scale=*/0.5, /*sharpenStrength=*/3);

        System.out.println("Wrote " + result);
    }
}
