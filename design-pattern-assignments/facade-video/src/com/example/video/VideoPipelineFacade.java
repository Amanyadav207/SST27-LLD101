package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filters;
    private final Encoder encoder;
    private final SharpenAdapter sharpener;

    public VideoPipelineFacade() {
        
        this.decoder = new Decoder();
        this.filters = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpener = new SharpenAdapter(new LegacySharpen());
    }

    public VideoPipelineFacade(Decoder d, FilterEngine f, Encoder e, SharpenAdapter s) {
        this.decoder = d;
        this.filters = f;
        this.encoder = e;
        this.sharpener = s;
    }


    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        
        Frame[] frames = decoder.decode(src);

        if (gray) {
            frames = filters.grayscale(frames);
        }
        if (scale != null) {
            if (scale <= 0) throw new IllegalArgumentException("scale must be > 0");
            frames = filters.scale(frames, scale);
        }
        if (sharpenStrength != null) {
            frames = sharpener.apply(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}
