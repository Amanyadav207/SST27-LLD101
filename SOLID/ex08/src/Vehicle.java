public interface Vehicle {
}

interface EnginePowered {
    void startEngine();
}

interface PedalPowered {
    void pedal(int effort);
}

interface Rechargeable {
    void recharge(int kWh);
}