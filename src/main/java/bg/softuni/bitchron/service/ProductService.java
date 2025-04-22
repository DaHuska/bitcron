package bg.softuni.bitchron.service;

import bg.softuni.bitchron.model.dto.WatchDTO;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    void addProduct(WatchDTO watchDTO, MultipartFile image) throws IOException;
}
