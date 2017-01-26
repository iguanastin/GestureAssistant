
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class GestureSetupFrame extends javax.swing.JFrame {

    private GestureDisplayFrame gestureDisplay;

    public GestureSetupFrame() {
        initComponents();

        gestureDisplay = new GestureDisplayFrame(this);
        gestureDisplay.setVisible(false);
        
        Border etched = BorderFactory.createEtchedBorder();
        sourcePanel.setBorder(BorderFactory.createTitledBorder(etched, "References:"));
        timingPanel.setBorder(BorderFactory.createTitledBorder(etched, "Time per Gesture:"));
        otherPanel.setBorder(BorderFactory.createTitledBorder(etched, "Other:"));
        audioPanel.setBorder(BorderFactory.createTitledBorder(etched, "Audio:"));
    }

    public static ArrayList<File> getImagesInFolder(File folder) throws FileNotFoundException {
        if (!folder.exists()) {
            throw new FileNotFoundException(folder.getAbsolutePath());
        }

        ArrayList<File> images = new ArrayList();

        for (File file : folder.listFiles()) {
            if (file.isFile() && (file.getName().toLowerCase().endsWith(".png") || file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".gif") || file.getName().toLowerCase().endsWith(".jpeg"))) {
                images.add(file);
            }
        }

        return images;
    }

    public static ArrayList<File> getImagesInFolder(String folder) throws FileNotFoundException {
        return getImagesInFolder(new File(folder));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        startButton = new javax.swing.JButton();
        timingPanel = new javax.swing.JPanel();
        minutesSpinner = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        secondsSpinner = new javax.swing.JSpinner();
        sourcePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sourceFolderBrowseButton = new javax.swing.JButton();
        imagesFoundLabel = new javax.swing.JLabel();
        sourceFolderTextField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        otherPanel = new javax.swing.JPanel();
        orderComboBox = new javax.swing.JComboBox();
        alwaysOnTopCheckbox = new javax.swing.JCheckBox();
        audioPanel = new javax.swing.JPanel();
        audioNotificationCheckbox = new javax.swing.JCheckBox();
        volumeSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gesture Setup");
        setResizable(false);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        timingPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        timingPanel.setName(""); // NOI18N

        minutesSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 0, 120, 1));

        jLabel7.setText("minutes");

        jLabel6.setText("seconds");

        secondsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        javax.swing.GroupLayout timingPanelLayout = new javax.swing.GroupLayout(timingPanel);
        timingPanel.setLayout(timingPanelLayout);
        timingPanelLayout.setHorizontalGroup(
            timingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(secondsSpinner)
                    .addComponent(minutesSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(timingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(timingPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        timingPanelLayout.setVerticalGroup(
            timingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minutesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(timingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sourcePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Source Folder:");
        jLabel1.setToolTipText("Folder containing all images to be used");

        sourceFolderBrowseButton.setText("Browse");
        sourceFolderBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceFolderBrowseButtonActionPerformed(evt);
            }
        });

        imagesFoundLabel.setText("Images Found: 0");

        javax.swing.GroupLayout sourcePanelLayout = new javax.swing.GroupLayout(sourcePanel);
        sourcePanel.setLayout(sourcePanelLayout);
        sourcePanelLayout.setHorizontalGroup(
            sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sourcePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sourceFolderTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sourceFolderBrowseButton))
                    .addGroup(sourcePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(imagesFoundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        sourcePanelLayout.setVerticalGroup(
            sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sourceFolderTextField)
                        .addComponent(sourceFolderBrowseButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagesFoundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        otherPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        orderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Random", "By Name" }));

        alwaysOnTopCheckbox.setText("Always On Top");

        javax.swing.GroupLayout otherPanelLayout = new javax.swing.GroupLayout(otherPanel);
        otherPanel.setLayout(otherPanelLayout);
        otherPanelLayout.setHorizontalGroup(
            otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(otherPanelLayout.createSequentialGroup()
                        .addComponent(alwaysOnTopCheckbox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(orderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        otherPanelLayout.setVerticalGroup(
            otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alwaysOnTopCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        audioPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        audioNotificationCheckbox.setText("Audio Notification");
        audioNotificationCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audioNotificationCheckboxActionPerformed(evt);
            }
        });

        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setToolTipText("Volume");
        volumeSlider.setValue(80);
        volumeSlider.setEnabled(false);
        volumeSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                volumeSliderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout audioPanelLayout = new javax.swing.GroupLayout(audioPanel);
        audioPanel.setLayout(audioPanelLayout);
        audioPanelLayout.setHorizontalGroup(
            audioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(audioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(audioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(audioPanelLayout.createSequentialGroup()
                        .addComponent(audioNotificationCheckbox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(volumeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addContainerGap())
        );
        audioPanelLayout.setVerticalGroup(
            audioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(audioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(audioNotificationCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(otherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(audioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sourcePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(otherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(audioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sourceFolderBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceFolderBrowseButtonActionPerformed
        JFileChooser fileChooser;
        if (sourceFolderTextField.getText() != null && !sourceFolderTextField.getText().isEmpty() && !sourceFolderTextField.getText().equals("C:\\")) {
            fileChooser = new JFileChooser(sourceFolderTextField.getText());
        } else {
            fileChooser = new JFileChooser();
        }
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = fileChooser.getSelectedFile();
            sourceFolderTextField.setText(file.getAbsolutePath());

            try {
                imagesFoundLabel.setText("Images Found: " + getImagesInFolder(file).size());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Folder does not exist", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sourceFolderBrowseButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (acceptableInput()) {
            setVisible(false);
            gestureDisplay.setVisible(true);
            gestureDisplay.startWithConfig(buildConfig());
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void audioNotificationCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audioNotificationCheckboxActionPerformed
        volumeSlider.setEnabled(audioNotificationCheckbox.isSelected());
        
        if (audioNotificationCheckbox.isSelected()) {
            GestureDisplayFrame.playNotificationSound(volumeSlider.getValue());
        }
    }//GEN-LAST:event_audioNotificationCheckboxActionPerformed

    private void volumeSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeSliderMouseReleased
        if (audioNotificationCheckbox.isSelected()) {
            GestureDisplayFrame.playNotificationSound(volumeSlider.getValue());
        }
    }//GEN-LAST:event_volumeSliderMouseReleased

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private boolean acceptableInput() {
        File file = new File(sourceFolderTextField.getText());
        
        if (!file.exists() || !file.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Source folder must exist and be a directory", "ERROR", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        return true;
    }
    
    private GestureConfig buildConfig() {
        GestureConfig config = new GestureConfig();
        config.alwaysOnTop = alwaysOnTopCheckbox.isSelected();
        config.audioNotification = audioNotificationCheckbox.isSelected();
        config.sourceFolder = sourceFolderTextField.getText();
        config.volume = volumeSlider.getValue();

        switch ((String) orderComboBox.getSelectedItem()) {
            case "By Name":
                config.order = GestureConfig.ORDER_ALPHANUMERIC;
                break;
            case "Random":
                config.order = GestureConfig.ORDER_RANDOM;
                break;
        }

        config.timeInSeconds = (int) secondsSpinner.getValue() + (int) minutesSpinner.getValue() * 60;

        return config;
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestureSetupFrame frame = new GestureSetupFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox alwaysOnTopCheckbox;
    private javax.swing.JCheckBox audioNotificationCheckbox;
    private javax.swing.JPanel audioPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel imagesFoundLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner minutesSpinner;
    private javax.swing.JComboBox orderComboBox;
    private javax.swing.JPanel otherPanel;
    private javax.swing.JSpinner secondsSpinner;
    private javax.swing.JButton sourceFolderBrowseButton;
    private javax.swing.JTextField sourceFolderTextField;
    private javax.swing.JPanel sourcePanel;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel timingPanel;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
