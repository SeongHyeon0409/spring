package hello.upload.domain;
import lombok.Data;
import java.util.List;
import hello.upload.domain.*;

@Data
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}