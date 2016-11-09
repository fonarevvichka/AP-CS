package com.company;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
	 */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width  the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }
    ////////////////////// methods ///////////////////////////////////////

    /* Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args) {


    }

    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() +
                " height " + getHeight()
                + " width " + getWidth();
        return output;

    }
    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }
    public void grayscale() {
        int red, green, blue, average;
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                red = pixelObj.getRed();
                blue = pixelObj.getBlue();
                green = pixelObj.getGreen();
                average = (red + green + blue) / 3;
                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }
    public void fixUnderWater() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(pixelObj.getRed() * 6);
            }
        }
    }
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
    public void mirrorHorizontalBottomToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topRightPixel = null;
        Pixel bottomLeftPixel = null;
        int maxLength;
        if (pixels.length < pixels[0].length)
            maxLength = pixels.length;
        else
            maxLength = pixels[0].length;

        for (int row = 0; row < maxLength; row++) {
            for (int col = row; col < maxLength; col++) {
                topRightPixel = pixels[row][col];
                bottomLeftPixel = pixels[col][row];
                topRightPixel.setColor(bottomLeftPixel.getColor());

            }
        }
    }
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    /**
     * Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                System.out.println(count++);
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    public void mirrorArms() {
        int mirrorPoint = 190;
        Pixel bottomPixel = null;
        Pixel topPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 157; row < 191; row++) {
            for (int col = 104; col < 170; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint + (mirrorPoint - row)][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
        for (int row = 170; row < 200; row++) {
            for (int col = 239; col < 295; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint + (mirrorPoint - row)][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    public void mirrorGull() {
        Pixel[][] pixels = this.getPixels2D();
        int shiftAmount = 120;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        for (int row = 232; row < 320; row++) {
            for (int col = 230; col < 345; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + shiftAmount];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    /**
     * copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     *
     * @param fromPic  the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic,
                     int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
             fromRow < fromPixels.length &&
                     toRow < toPixels.length;
             fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                 fromCol < fromPixels[0].length &&
                         toCol < toPixels[0].length;
                 fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }
    public void copyV2(Picture fromPic, int startRow, int startCol, int endRow, int endCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
             fromRow < fromPixels.length && toRow < endRow; fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length &&
                    toCol < endCol; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }
    /**
     * Method to create a collage of several pictures
     */
    public void createCollage() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }
    public void myCollage() {
        Picture cat1 = new Picture("robot.jpg");
        Picture stillACat = new Picture("robot.jpg");
        Picture catQuestionMark = new Picture("robot.jpg");

        cat1.grayscale();
        this.copy(cat1, 0, 0);
        cat1.mirrorDiagonal();
        this.copy(cat1, 0, 100);
        cat1.keepOnlyBlue();
        this.copy(cat1, 0, 200);

        stillACat.zeroBlue();
        this.copy(stillACat, 200, 0);
        stillACat.negate();
        this.copy(stillACat, 200, 100);
        stillACat.mirrorHorizontalBottomToTop();
        this.copy(stillACat, 200, 200);

        catQuestionMark.mirrorVertical();
        this.copy(catQuestionMark, 300, 0);
        catQuestionMark.edgeDetection(10);
        this.copy(catQuestionMark, 300, 100);
        catQuestionMark.zeroBlue();
        this.copy(catQuestionMark, 300, 200);
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0;
                 col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                topPixel = pixels[row][col];
                bottomPixel = pixels[row + 1][col];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist ||
                        topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    public void edgeDetection2(int edgeDist) {
        Pixel leftPixel = null, middlePixel = null, rightPixel = null;
        Pixel leftComapre = null, rightCompare = null;
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 1; row < pixels.length - 1; row++) {
            for (int col = 1; col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col - 1];
                middlePixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];

                leftPixel.setRed((leftPixel.getRed() + middlePixel.getRed()) / 2);
                leftPixel.setGreen((leftPixel.getGreen() + middlePixel.getGreen()) / 2);
                leftPixel.setBlue((leftPixel.getBlue() + middlePixel.getBlue()) / 2);

                rightPixel.setRed((rightPixel.getRed() + middlePixel.getRed()) / 2);
                rightPixel.setGreen((rightPixel.getGreen() + middlePixel.getGreen()) / 2);
                rightPixel.setBlue((rightPixel.getBlue() + middlePixel.getBlue()) / 2);

                if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }


} // this } is the end of class Picture, put all new methods before this
