public class Player {
    private Frame last;

    Cache cache = new Cache();
    DrawUI dUi = new DrawUI();

    public void play(byte[] fileBytes){
        // decode
        Frame f = new Frame(fileBytes); // pretend decoding
        last = f;
        // draw UI
        dUi.drawUI(fileBytes.length);
        // cache
        cache.CacheFrame(last);
    }
}