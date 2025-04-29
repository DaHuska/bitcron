package bg.softuni.bitchron.service;

import bg.softuni.bitchron.model.dto.OfferRegisterDTO;
import bg.softuni.bitchron.model.dto.WatchDTO;
import bg.softuni.bitchron.model.entity.OfferEntity;
import bg.softuni.bitchron.model.entity.WatchEntity;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(WatchDTO watchDTO, MultipartFile image) throws IOException;
    void createOffer(OfferRegisterDTO offerRegisterDTO, WatchEntity watch);
    List<OfferEntity> getAllOffers();
    List<WatchEntity> getAllWatches();
    Optional<WatchEntity> getWatchById(Long id);
}
