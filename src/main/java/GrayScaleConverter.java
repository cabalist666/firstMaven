import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class GrayScaleConverter {
    public static ImageResource makeGray(ImageResource inImage){
        // 先做一張空白的image
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // 迴圈找每一個pixel位置。
        for (Pixel pixel: outImage.pixels()) {
            // 找對應的的位置
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getBlue() + inPixel.getGreen()+ inPixel.getRed())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }

    public static void SelectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.draw();
        }
    }

    public static void main(String[] args) {
        /* 畫出單張的圖片
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
        */
        SelectAndConvert();

    }
}
