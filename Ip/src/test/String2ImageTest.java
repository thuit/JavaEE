package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class String2ImageTest {

    public static void gen(String text, int fontSize) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(fontSize*text.length(), fontSize, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        g.setPaint(Color.black);
        g.drawString(text, 0, fontSize-10);
        g.dispose();
        ImageIO.write(bufferedImage, "png", new File("Ip/web/image/new.png"));
    }

    public static void main(String[] args) throws IOException, ParseException {
        gen("abcdefghijklmnopqrstuvwxyz", 50);
    }
}

