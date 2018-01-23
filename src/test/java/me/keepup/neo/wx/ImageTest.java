package me.keepup.neo.wx;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.util.Files.newFile;

public class ImageTest {

    public static void main(String[] args) throws IOException{
        BufferedImage bufferedImage =  ImageIO.read(newFile("images/watermark.png"));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Thumbnails.of("").watermark(bufferedImage).toOutputStream(os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
    }
}