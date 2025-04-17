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
    private MovementType mechanism;

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
}
