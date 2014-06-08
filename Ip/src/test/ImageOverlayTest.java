package test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Administrator on 14-6-7.
 */
public class ImageOverlayTest {

    public static void main(String[] args) throws Exception {


        File path = new File("IP/web/image");

        // load source images
        BufferedImage image = ImageIO.read(new File(path, "combined.png"));
        BufferedImage overlay = ImageIO.read(new File(path, "e.png"));

        // create the new image, canvas size is the max. of both image sizes
        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);

        // Save as new image
        ImageIO.write(combined, "PNG", new File(path, "combined.png"));
    }
}
