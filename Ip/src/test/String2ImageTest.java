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

    //
    public static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }

    public static String TextToPic(String text, int width, int height,
                                   int fontSize) {
        try {
            String filepath = "D:/"
                    + getDate() + ".png";

// String
// filepath="/www/newaudi_cms/app/UserFiles/Image/texttopic/image"+getDate()+".png";

            File file = new File(filepath);

// Font font = new Font("甲骨文", 36, fontSize);

            System.out.println("topic=" + text);
            Font font = new Font("汉仪双线简体", Font.BOLD, fontSize);
// Font font = new Font("新宋体", Font.BOLD, fontSize);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2 = (Graphics2D) bi.getGraphics();

            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setFont(font);
            g2.setPaint(Color.black);

            paintString(g2, text, 2, 42, fontSize);
            g2.dispose();
            ImageIO.write(bi, "png", file);
            return "image" + getDate() + ".png";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

        return formatter.format(new Date());
    }

    private static void paintString(Graphics2D g2d, String str, int x, int y,
                                    float fontSize) {
        FontMetrics metrics = g2d.getFontMetrics();
        for (char ca : str.toCharArray()) {
            int px = metrics.stringWidth("" + ca);
//            g2d.drawString(""+ca, x+(fontSize–px)/2, y);
            g2d.drawString(""+ca, x+(fontSize-px)/2, y);
            x += fontSize;
        }
    }

    public static Date parsePlainDate(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        return sdf.parse(source, new ParsePosition(0));
    }

    public static void main(String[] args) throws IOException, ParseException {
// pressText("我是文字", "d:\\1.bmp", "黑体", 36, Color.white, 80, 0, 0,
// 0.3f);
        TextToPic("我是文字", 500, 100, 50);
//
        System.out.print(parsePlainDate(getDate()));
    }

}