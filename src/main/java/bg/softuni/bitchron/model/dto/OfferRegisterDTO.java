package bg.softuni.bitchron.model.dto;

import bg.softuni.bitchron.model.entity.WatchEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OfferRegisterDTO {
    @NotNull
    private String watch;

    @NotBlank
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Double discount;

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
