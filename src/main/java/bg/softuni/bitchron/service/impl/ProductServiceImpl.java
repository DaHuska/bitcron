package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.model.dto.WatchDTO;
import bg.softuni.bitchron.model.entity.WatchEntity;
import bg.softuni.bitchron.repository.ProductRepository;
import bg.softuni.bitchron.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        WatchEntity mappedEntity = modelMapper.map(watchDTO, WatchEntity.class);

        String originalFilename = image.getOriginalFilename();
        String contentType = image.getContentType();
        byte[] bytes = image.getBytes();
    }
}
