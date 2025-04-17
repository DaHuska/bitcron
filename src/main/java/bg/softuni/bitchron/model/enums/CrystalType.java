package bg.softuni.bitchron.model.enums;

public enum CrystalType {
    HARDENED_MINERAL("Hardened mineral"),
    ACRYLIC("Acrylic"),
    MINERAL("Mineral"),
    SAPPHIRE("Sapphire");

    private final String crystalType;

    CrystalType(String crystalType) {
        this.crystalType = crystalType;
    }

    public String getCrystalType() {
        return this.crystalType;
    }
}
