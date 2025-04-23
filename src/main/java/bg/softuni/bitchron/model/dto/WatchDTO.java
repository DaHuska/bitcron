package bg.softuni.bitchron.model.dto;

import bg.softuni.bitchron.model.enums.CrystalType;
import bg.softuni.bitchron.model.enums.MovementType;
import bg.softuni.bitchron.model.enums.StrapType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WatchDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private MovementType movement;

    @NotNull
    private CrystalType crystal;

    @NotNull
    private StrapType strap;

    @NotNull
    private Double chassisSize;

    @NotNull
    private Integer stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CrystalType getCrystal() {
        return crystal;
    }

    public void setCrystal(CrystalType crystal) {
        this.crystal = crystal;
    }

    public MovementType getMovement() {
        return movement;
    }

    public void setMovement(MovementType movement) {
        this.movement = movement;
    }

    public StrapType getStrap() {
        return strap;
    }

    public void setStrap(StrapType strap) {
        this.strap = strap;
    }

    public Double getChassisSize() {
        return chassisSize;
    }

    public void setChassisSize(Double chassisSize) {
        this.chassisSize = chassisSize;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
