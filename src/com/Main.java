package com;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file=new File("smile.jpg");
        BufferedImage image= ImageIO.read(file);
        BufferedImage imageFiltered=new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
        AffineTransform aT=AffineTransform.getQuadrantRotateInstance(3,image.getWidth()/2,image.getHeight()/2);
        BufferedImageOp op=new AffineTransformOp(aT,AffineTransformOp.TYPE_BILINEAR);
        op.filter(image,imageFiltered);
        ImageIO.write(imageFiltered,"png",new File("smile.png"));
    }
}
