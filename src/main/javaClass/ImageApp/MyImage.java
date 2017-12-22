package javaClass.ImageApp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyImage {

    public  MyImage(){

    }

    public void GetGrayImage(){
         try{
            BufferedImage image = ImageIO.read(new File("tg.jpg"));

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int pixel = image.getRGB(j, i);
                    int alpha = (pixel & 0xFF000000) >>> 24;
                    int red = (pixel & 0x00FF0000) >>> 16;
                    int green = (pixel & 0x0000FF00) >>> 8;
                    int blue = (pixel & 0x000000FF);

                    int mean = (red + green + blue) / 3;
                    int newPixel = (alpha << 24) + (mean << 16) + (mean << 8) + mean;

                    image.setRGB(j, i, newPixel);
                }
            }

            ImageIO.write(image, "jpg", new File("tg_gray.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GetNegativImage(){
        try{
            BufferedImage image = ImageIO.read(new File("tg.jpg"));

            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int pixel = image.getRGB(j, i);
                    int alpha = (pixel & 0xFF000000) >>> 24;
                    int red = (pixel & 0x00FF0000) >>> 16;
                    int green = (pixel & 0x0000FF00) >>> 8;
                    int blue = (pixel & 0x000000FF);

                    red = 255 - red;
                    green = 255 - green;
                    blue = 255 - blue;

                    int newPixel = (alpha << 24) + (red << 16) + (green << 8) + blue;

                    image.setRGB(j, i, newPixel);
                }
            }

            ImageIO.write(image, "jpg", new File("tg_negativ.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GetBlurImage(){
        try {
            BufferedImage bi = ImageIO.read(new File("tg.jpg"));

            int width = bi.getWidth();
            int height = bi.getHeight();

            for (int i = 1; i < width - 1; i++){
                for (int j = 1; j < height - 1; j++){

                    int leftPix = bi.getRGB(i, j - 1);
                    int rightPix = bi.getRGB(i, j + 1);
                    int topPix = bi.getRGB(i - 1, j);
                    int downPix = bi.getRGB(i + 1, j);
                    int centrPix = bi.getRGB(i, j);

                    int alpha = (centrPix & 0xFF000000) >>> 24;
                    int meanRed = (((leftPix & 0x00FF0000) >>> 16) + ((rightPix & 0x00FF0000) >>> 16) + ((topPix & 0x00FF0000) >>> 16) +
                            + ((downPix & 0x00FF0000) >>> 16) + (2 * (centrPix & 0x00FF0000) >>> 16)) / 6;
                    int meanGreen = (((leftPix & 0x0000FF00) >>> 8) + ((rightPix & 0x0000FF00) >>> 8) + ((topPix & 0x0000FF00) >>> 8) +
                            + ((downPix & 0x0000FF00) >>> 8) + (2 * (centrPix & 0x0000FF00) >>> 8)) / 6;
                    int meanBlue = ((leftPix & 0x000000FF) + (rightPix & 0x000000FF) + (topPix & 0x000000FF) +
                            + (downPix & 0x000000FF) + 2 * (centrPix & 0x000000FF)) / 6;

                    int newPix = (alpha << 24) + (meanRed << 16) + (meanGreen << 8) + meanBlue;

                    bi.setRGB(i, j, newPix);
                }
            }

            ImageIO.write(bi, "jpg", new File("tg_blur.jpg"));
        }
        catch (IOException e){

        }
    }
}
