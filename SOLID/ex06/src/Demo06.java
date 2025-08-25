public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        aviary.release(new BirdWithWings());
    }
}

class BirdWithWings extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flap!");
    }
}
