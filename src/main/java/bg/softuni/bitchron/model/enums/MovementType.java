package bg.softuni.bitchron.model.enums;

public enum MovementType {
    QUARTZ("Quartz"),
    AUTOMATIC("Automatic"),
    SOLAR("Solar"),
    MECHANICAL("Mechanical"),
    MANUAL("Manual"),
    KINETIC("Kinetic"),
    CHRONOGRAPH("Chronograph"),
    HYBRID("Hybrid");

    private final String movement;

    MovementType(String movement) {
        this.movement = movement;
    }

    public String getMovement() {
        return this.movement;
    }
}
