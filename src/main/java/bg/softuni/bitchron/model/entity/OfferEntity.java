package bg.softuni.bitchron.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @Column
    @NotBlank
    private String description;

    @Column
    @NotNull
    private Double price;

    @Column
    @NotNull
    private Double discount;

    @OneToOne
    private WatchEntity watch;

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;

        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OfferEntity setPrice(Double price) {
        this.price = price;

        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public OfferEntity setDiscount(Double discount) {
        this.discount = discount;

        return this;
    }

    public WatchEntity getWatch() {
        return watch;
    }

    public OfferEntity setWatch(WatchEntity watch) {
        this.watch = watch;

        return this;
    }
}
