package tranminhduc.project.com.demo.uploadfile.uploadFileController;


import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class ImageUploadController {

    private static String imageDirectory = System.getProperty("user.dir") + "/image";
    @RequestMapping(value = "/image", produces = {MediaType.IMAGE_PNG_VALUE, "application/json"})
    public ResponseEntity<?> uploadFile(@RequestParam("imageFile")MultipartFile multipartFile,  @RequestParam("imageName") String name){
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory,
                name.concat(".").concat(FilenameUtils.getExtension(multipartFile.getOriginalFilename())));
        try {
            Files.write(fileNamePath, multipartFile.getBytes());
            return new ResponseEntity<>(name, HttpStatus.CREATED);
        } catch (IOException e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }


    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
