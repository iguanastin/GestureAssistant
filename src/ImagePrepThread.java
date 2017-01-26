
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImagePrepThread extends Thread {

    private boolean running = true;

    private File imagePath;
    private int width = 0;
    private int height = 0;

    private ImagePrepListener callback;

    public ImagePrepThread(ImagePrepListener listener) {
        callback = listener;
    }

    @Override
    public void run() {
        while (isRunning()) {
            synchronized (this) {
                if (imagePath == null) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }

                try {
                    callback.imagePrepped(GestureDisplayFrame.scaleImageToFit(new ImageIcon(ImageIO.read(imagePath)), width, height, Image.SCALE_SMOOTH));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                dequeueImage();
            }
        }
    }

    public synchronized void queueImage(File file, int width, int height) {
        imagePath = file;
        this.width = width;
        this.height = height;
        
        notify();
    }

    public synchronized boolean isImageQueued() {
        return imagePath != null;
    }

    public synchronized void dequeueImage() {
        imagePath = null;
        width = 0;
        height = 0;
    }

    @Override
    public synchronized void start() {
        super.start();

        running = true;
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public synchronized void stopRunning() {
        running = false;
    }

}
