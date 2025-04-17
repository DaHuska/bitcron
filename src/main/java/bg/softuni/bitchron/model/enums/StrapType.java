package bg.softuni.bitchron.model.enums;

public enum StrapType {
    STAINLESS_STEEL("Stainless steel"),
    LEATHER("Leather"),
    CERAMIC("Ceramic"),
    CORK("Cork"),
    MESH("Mesh"),
    NYLON("Nylon"),
    POLYCARBONATE("Polycarbonate"),
    RUBBER("Rubber"),
    TITANIUM("Titanium");

    private final String strap;

    StrapType(String strap) {
        this.strap = strap;
    }

    public String getStrap() {
        return this.strap;
    }
}
