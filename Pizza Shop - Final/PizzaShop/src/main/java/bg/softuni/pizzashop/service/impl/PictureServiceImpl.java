package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Picture;
import bg.softuni.pizzashop.repository.PictureRepository;
import bg.softuni.pizzashop.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture uploadPicture(MultipartFile file, String name) throws IOException {
        byte[] imageData = file.getBytes();
        Picture picture = new Picture();
        picture.setTitle(name);
        picture.setData(imageData);
        pictureRepository.save(picture);

        return picture;
    }
}
