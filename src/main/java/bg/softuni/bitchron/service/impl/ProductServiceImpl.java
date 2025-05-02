package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.model.dto.OfferRegisterDTO;
import bg.softuni.bitchron.model.dto.WatchDTO;
import bg.softuni.bitchron.model.entity.OfferEntity;
import bg.softuni.bitchron.model.entity.WatchEntity;
import bg.softuni.bitchron.repository.OfferRepository;
import bg.softuni.bitchron.repository.ProductRepository;
import bg.softuni.bitchron.service.ProductService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, OfferRepository offerRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferEntity> getAllOffers() {
        List<OfferEntity> offers = offerRepository.findAll();

        return Collections.unmodifiableList(offers);
    }

    @Override
    public List<WatchEntity> getAllWatches() {
        List<WatchEntity> watches = productRepository.findAll();

        return Collections.unmodifiableList(watches);
    }

    @Override
    public Optional<WatchEntity> getWatchById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void addProduct(WatchDTO watchDTO, MultipartFile image) throws IOException {
        WatchEntity mappedEntity = mapWatchEntity(watchDTO, image, modelMapper);

        productRepository.save(mappedEntity);
    }

    @Override
    @Transactional
    public void createOffer(OfferRegisterDTO offerRegisterDTO, WatchEntity watch) {
        OfferEntity offer = mapOfferEntity(offerRegisterDTO, watch, modelMapper);

        offerRepository.saveAndFlush(offer);
    }

    private static WatchEntity mapWatchEntity(WatchDTO watchDTO, MultipartFile image, ModelMapper modelMapper) throws IOException {
        return modelMapper
                .map(watchDTO, WatchEntity.class)
                .setImageName(image.getOriginalFilename())
                .setImageType(image.getContentType())
                .setImageData(Base64.getEncoder().encodeToString(image.getBytes()))
                .setCreated(new Date());
    }

    private static OfferEntity mapOfferEntity(OfferRegisterDTO offer, WatchEntity watch, ModelMapper modelMapper) {
        return modelMapper
                .map(offer, OfferEntity.class)
                .setWatch(watch);
    }
}
