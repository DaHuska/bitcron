package bg.softuni.bitchron.model.entity;

import bg.softuni.bitchron.model.enums.CrystalType;
import bg.softuni.bitchron.model.enums.MovementType;
import bg.softuni.bitchron.model.enums.StrapType;
import bg.softuni.bitchron.model.enums.WaterResistanceType;
import bg.softuni.bitchron.model.validation.DateNotInTheFuture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

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
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private MovementType movement;

    @Column
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private CrystalType crystal;

    @Column
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private StrapType strap;

    @Column(name = "chassis_size")
    @NotEmpty
    private Double chassisSize;

    @Column(name = "water_resistance")
    @NotEmpty
    private WaterResistanceType waterResistance;

    @Column
    @NotEmpty
    @DateNotInTheFuture
    private Date created;

    @Column(name = "image_name")
    @NotEmpty
    private String imageName;

    @Column(name = "image_type")
    @NotEmpty
    private String imageType;

    @Column(name = "image_data")
    @NotEmpty
    private byte[] imageData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public MovementType getMovement() {
        return movement;
    }

    public void setMovement(MovementType movement) {
        this.movement = movement;
    }

    public CrystalType getCrystal() {
        return crystal;
    }

    public void setCrystal(CrystalType crystal) {
        this.crystal = crystal;
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

    public WaterResistanceType getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(WaterResistanceType waterResistance) {
        this.waterResistance = waterResistance;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
