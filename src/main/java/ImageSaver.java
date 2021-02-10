
import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import GrayScaleConverter.GrayScaleConverter;
import java.io.File;

public class ImageSaver {
    public static void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fileName = image.getFileName();
            String newName = "copy-" + fileName;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }

    public static void ConvertAndSaveGrayImage(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            ImageResource afterConvert = GrayScaleConverter.makeGray(image);
            String fileName = image.getFileName();
            String newName = "copy-" + fileName;
            afterConvert.setFileName(newName);
            afterConvert.draw();
            afterConvert.save();
        }
    }


    public static void main(String[] args) {
        doSave();
    }
}
