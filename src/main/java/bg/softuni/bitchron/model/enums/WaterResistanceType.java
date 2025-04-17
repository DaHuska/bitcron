package bg.softuni.bitchron.model.enums;

public enum WaterResistanceType {
    ATM_3("3 ATM"),
    ATM_5("5 ATM"),
    ATM_10("10 ATM"),
    ATM_20("20 ATM"),
    ATM_50("50 ATM"),
    ATM_100("100 ATM");

    private final String resistance;

    WaterResistanceType(String resistance) {
        this.resistance = resistance;
    }

    public String getResistance() {
        return this.resistance;
    }
}
