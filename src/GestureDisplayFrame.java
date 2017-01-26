
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GestureDisplayFrame extends javax.swing.JFrame {

    private GestureSetupFrame setupFrame;
    private GestureConfig config;
    private Timer timer;
    private ArrayList<File> images;
    private int index = 0;
    
    private ImagePrepThread prepThread;
    
    private int time = 0;

    public GestureDisplayFrame(GestureSetupFrame setupFrame) {
        initComponents();

        this.setupFrame = setupFrame;
        
        prepThread = new ImagePrepThread(new ImagePrepListener() {
            @Override
            public void imagePrepped(ImageIcon img) {
                setImage(img);
            }
        });
        prepThread.start();

        setLocationRelativeTo(null);
    }
    
    private void setImage(ImageIcon icon) {
        displayLabel.setText("");
        displayLabel.setIcon(icon);
    }

    public void startWithConfig(GestureConfig config) {
        if (config == null) {
            throw new NullPointerException("Cannot start with null config");
        }

        this.config = config;
        setAlwaysOnTop(config.alwaysOnTop);

        index = -1;
        try {
            images = GestureSetupFrame.getImagesInFolder(config.sourceFolder);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Source folder does not exist: " + config.sourceFolder, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (images == null || images.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No images in source!", "Error", JOptionPane.ERROR_MESSAGE);
            setVisible(false);
            return;
        }

        if (config.order == GestureConfig.ORDER_ALPHANUMERIC) {
            images.sort(new WindowsExplorerStringComparator());
        } else if (config.order == GestureConfig.ORDER_RANDOM) {
            Collections.shuffle(images);
        }
        nextImage();

        killTimer();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                incrementTime();
            }
        }, 0, 1000);
    }

    private void killTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private synchronized void incrementTime() {
        time++;

        if (config.timeInSeconds - time < 0) {
            nextImage();
        }

        timeLeftLabel.setText("Time Left: " + getTimeString(config.timeInSeconds - time));
    }

    private String getTimeString(int time) {
        String result = "";

        int minutes = 0;
        int seconds;

        while (time >= 60) {
            time -= 60;
            minutes++;
        }
        seconds = time;

        if (minutes > 1) {
            result = minutes + " minutes";
        } else if (minutes == 1) {
            result = "1 Minute";
        }

        result += " " + seconds + " seconds";

        return result;
    }

    private synchronized int getTime() {
        return time;
    }

    private synchronized void setTime(int n) {
        time = n;
    }

    private void nextImage() {
        if (images == null) {
            throw new NullPointerException("Image ArrayList cannot be null");
        }
        if (images.isEmpty()) {
            return;
        }

        setTime(0);

        incrementIndex();

        updateDisplayImage();

        if (config.audioNotification) {
            playNotificationSound(config.volume);
        }
    }

    private void updateDisplayImage() {
        displayLabel.setText("Loading...");
        displayLabel.setIcon(null);
        prepThread.queueImage(images.get(index), displayLabel.getWidth(), displayLabel.getHeight());
    }

    private void incrementIndex() {
        index++;
        if (index >= images.size()) {
            index = 0;
        }
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);

        if (b == false) {
            killTimer();
            config = null;
            images = null;
            index = 0;
            setTime(0);
            
            prepThread.dequeueImage();

            setupFrame.setVisible(true);
        }
    }

    public static ImageIcon scaleImageToFit(ImageIcon img, int width, int height, int scaleType) {
        int imgWidth = img.getIconWidth();
        int imgHeight = img.getIconHeight();

        if (imgHeight <= height && imgWidth <= width) {
            return img;
        }

        int newWidth = imgWidth;
        int newHeight = imgHeight;

        //Get aspect ratios to compare
        double imageAspect = (double) imgHeight / (double) imgWidth;

        //Determine correct scaling size
        if (newWidth > width) {
            newHeight = (int) (width * imageAspect);
            newWidth = width;
        }
        if (newHeight > height) {
            newWidth = (int) (height / imageAspect);
            newHeight = height;
        }

        Image workImage = img.getImage();
        Image newImg;
        newImg = workImage.getScaledInstance(newWidth, newHeight, scaleType);
        return new ImageIcon(newImg);
    }

    public static void playNotificationSound(int volume) {
        try {
            Clip notificationClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("notification.wav"));
            notificationClip.open(ais);
            FloatControl gainControl = (FloatControl) notificationClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-46.0f * (1.0f - volume / 100.0f) + 6.0f);
            notificationClip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPopupMenu = new javax.swing.JPopupMenu();
        showOnDiskMenuItem = new javax.swing.JMenuItem();
        timeLeftLabel = new javax.swing.JLabel();
        displayLabel = new javax.swing.JLabel();
        skipGestureButton = new javax.swing.JButton();

        showOnDiskMenuItem.setText("Show on Disk");
        showOnDiskMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOnDiskMenuItemActionPerformed(evt);
            }
        });
        displayPopupMenu.add(showOnDiskMenuItem);

        setTitle("Gesture");

        timeLeftLabel.setText("Time Left: 10 seconds");

        displayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayLabel.setComponentPopupMenu(displayPopupMenu);

        skipGestureButton.setText("Skip");
        skipGestureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipGestureButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timeLeftLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                .addComponent(skipGestureButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(displayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skipGestureButton)
                    .addComponent(timeLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipGestureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipGestureButtonActionPerformed
        nextImage();
    }//GEN-LAST:event_skipGestureButtonActionPerformed

    private void showOnDiskMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOnDiskMenuItemActionPerformed
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            try {
                Runtime.getRuntime().exec("explorer.exe /select, \"" + images.get(index) + "\"");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "This feature is only supported on Windows", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_showOnDiskMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel displayLabel;
    private javax.swing.JPopupMenu displayPopupMenu;
    private javax.swing.JMenuItem showOnDiskMenuItem;
    private javax.swing.JButton skipGestureButton;
    private javax.swing.JLabel timeLeftLabel;
    // End of variables declaration//GEN-END:variables
}
