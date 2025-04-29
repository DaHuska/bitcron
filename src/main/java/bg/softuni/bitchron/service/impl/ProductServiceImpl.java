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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<WatchEntity> getAllWatches() {
        List<WatchEntity> watches = productRepository.findAll();

        return Collections.unmodifiableList(watches);
    }

    @Override
    public Optional<WatchEntity> getWatchById(Long id) {
        return productRepository.findById(id);
    }

    private static WatchEntity mapWatchEntity(WatchDTO watchDTO, MultipartFile image, ModelMapper modelMapper) throws IOException {
        return modelMapper
                .map(watchDTO, WatchEntity.class)
                .setImageName(image.getOriginalFilename())
                .setImageType(image.getContentType())
                .setImageData(image.getBytes())
                .setCreated(new Date());
    }

    private static OfferEntity mapOfferEntity(OfferRegisterDTO offer, WatchEntity watch, ModelMapper modelMapper) {
        return modelMapper
                .map(offer, OfferEntity.class)
                .setWatch(watch);
    }
}
