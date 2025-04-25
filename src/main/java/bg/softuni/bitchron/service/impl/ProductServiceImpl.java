package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.model.dto.WatchDTO;
import bg.softuni.bitchron.model.entity.WatchEntity;
import bg.softuni.bitchron.repository.ProductRepository;
import bg.softuni.bitchron.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(WatchDTO watchDTO, MultipartFile image) throws IOException {
        WatchEntity mappedEntity = mapEntity(watchDTO, image, modelMapper);

        productRepository.save(mappedEntity);
    }

    private static WatchEntity mapEntity(WatchDTO watchDTO, MultipartFile image, ModelMapper modelMapper) throws IOException {
        return modelMapper
                .map(watchDTO, WatchEntity.class)
                .setImageName(image.getOriginalFilename())
                .setImageType(image.getContentType())
                .setImageData(image.getBytes())
                .setCreated(new Date());
    }
}
