package bg.softuni.bitchron.model.entity;

import bg.softuni.bitchron.model.enums.CrystalType;
import bg.softuni.bitchron.model.enums.MovementType;
import bg.softuni.bitchron.model.enums.StrapType;
import bg.softuni.bitchron.model.enums.WaterResistanceType;
import bg.softuni.bitchron.model.validation.DateNotInTheFuture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "watches")
public class WatchEntity extends BaseEntity {
    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String brand;

    @Column
    @NotBlank
    private String model;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private MovementType movement;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private CrystalType crystal;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private StrapType strap;

    @Column(name = "chassis_size")
    @NotNull
    private Double chassisSize;

    @Column(name = "water_resistance")
    @NotNull
    private WaterResistanceType waterResistance;

    @Column
    @NotNull
    @DateNotInTheFuture
    private Date created;

    @Column(name = "image_name")
    @NotBlank
    private String imageName;

    @Column(name = "image_type")
    @NotBlank
    private String imageType;

    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    @NotEmpty
    private byte[] imageData;

    public String getName() {
        return name;
    }

    public WatchEntity setName(String name) {
        this.name = name;

        return this;
    }

    public String getBrand() {
        return brand;
    }

    public WatchEntity setBrand(String brand) {
        this.brand = brand;

        return this;
    }

    public String getModel() {
        return model;
    }

    public WatchEntity setModel(String model) {
        this.model = model;

        return this;
    }

    public MovementType getMovement() {
        return movement;
    }

    public WatchEntity setMovement(MovementType movement) {
        this.movement = movement;

        return this;
    }

    public CrystalType getCrystal() {
        return crystal;
    }

    public WatchEntity setCrystal(CrystalType crystal) {
        this.crystal = crystal;

        return this;
    }

    public StrapType getStrap() {
        return strap;
    }

    public WatchEntity setStrap(StrapType strap) {
        this.strap = strap;

        return this;
    }

    public Double getChassisSize() {
        return chassisSize;
    }

    public WatchEntity setChassisSize(Double chassisSize) {
        this.chassisSize = chassisSize;

        return this;
    }

    public WaterResistanceType getWaterResistance() {
        return waterResistance;
    }

    public WatchEntity setWaterResistance(WaterResistanceType waterResistance) {
        this.waterResistance = waterResistance;

        return this;
    }

    public Date getCreated() {
        return created;
    }

    public WatchEntity setCreated(Date created) {
        this.created = created;

        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public WatchEntity setImageName(String imageName) {
        this.imageName = imageName;

        return this;
    }

    public String getImageType() {
        return imageType;
    }

    public WatchEntity setImageType(String imageType) {
        this.imageType = imageType;

        return this;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public WatchEntity setImageData(byte[] imageData) {
        this.imageData = imageData;

        return this;
    }
}
