package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;

public class String2ImageTest {

    public static void gen(String text, int fontSize) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(fontSize * text.length(), fontSize, BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        g.setPaint(Color.black);
        g.drawString(text, 0, fontSize - 10);
        g.dispose();
        ImageIO.write(bufferedImage, "png", new File("Ip/web/image/new.png"));
    }

    private static void setAlpha(ByteArrayOutputStream os) {
        /**
         * 增加测试项
         * 读取图片，绘制成半透明
         */
        try {
            ImageIcon imageIcon = new ImageIcon(os.toByteArray());
            BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
            g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
            //循环每一个像素点，改变像素点的Alpha值
            int alpha = 100;
            for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
                for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
                    int rgb = bufferedImage.getRGB(j2, j1);
                    rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff);
                    bufferedImage.setRGB(j2, j1, rgb);
                }
            }
            g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
            ImageIO.write(bufferedImage, "png", new File("IP/web/image/test.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ByteArrayOutputStream getOutputStream(String filePath){

        File file = new File(filePath);
        FileInputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            out.write(buffer);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(in!=null) in.close();
            } catch (Exception e2) {
            }

        }
        return out;
    }

    public static void main(String[] args) throws IOException, ParseException {
        gen("test...test...test", 50);
//        setAlpha(getOutputStream("IP/web/image/new.png"));
    }
}

