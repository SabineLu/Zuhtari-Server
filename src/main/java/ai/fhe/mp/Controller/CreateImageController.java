package ai.fhe.mp.Controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Class to create Images on RunTime for Users when needed, if it does
 * not have the image on the peristant storage yet
 * Created by Sabine Lueck on 27/08/2016.
 */
public class CreateImageController
{
    //TODO: Get Variables on specific variables to make the picture on
    //TODO: Load File Informtation Data from DB
    //TODO: Make DB Table with Data of Layer Picture Infos
    //Create New Picture with given Layer Picture Data
    public void MakePicture() throws IOException, URISyntaxException {
        String path  = System.getenv("OPENSHIFT_DATA_DIR"); // base path of the images

        // load source images
        URL resource =  this.getClass().getResource("/Pictures/Stage1/S1B.png");
        BufferedImage image = ImageIO.read(new File(resource.toURI()));

        resource =  this.getClass().getResource("/Pictures/Stage1/S1EAN.png");

        BufferedImage overlay = ImageIO.read(new File(resource.toURI()));

        // create the new image, canvas size is the max. of both image sizes
        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);

        // Save as new image
        ImageIO.write(combined, "PNG", new File(path, "combinedTest.png"));
    }

    //TODO: Get Picture Function with specific name
    //Get Image from persistant Data Folder of the Server
    public Image GetImage(String _Name)
    {
        if (CheckIfImageExist(_Name))
        {

        }
        return null;
    }

    //TODO: Check if Picture Exist
    //Check if Image Exist on the Persistant Data Folder
    public boolean CheckIfImageExist(String _Name)
    {
        return true;
    }
}
