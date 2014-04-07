import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Image_Viewer extends JFrame implements ActionListener {

    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    // image path for icon.
    ImageIcon imagePath = new ImageIcon();
    // Image displayed for user.
    JLabel picture = new JLabel();
    // Button to open file dialog.
    JButton btnOpenPicture = new JButton("Open file");

    Image_Viewer() {
        // Title for gui
        this.setTitle("Picture Viewer");
        // Close operation.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set layout.
        this.setLayout(new BorderLayout());
        // Action listener for when the user presses the button.
        btnOpenPicture.addActionListener(this);
        // add the label to the top panel.
        topPanel.add(picture);
        // adds the button to the bottom panel.
        bottomPanel.add(btnOpenPicture);
        // add top panel to main gui.
        add(topPanel, BorderLayout.CENTER);
        // add bottom panel to main gui.
        add(bottomPanel, BorderLayout.SOUTH);
        // Pack to make things look nice.
        pack();
        // set the visibility to true.
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Create a file chooser.
        JFileChooser fc = new JFileChooser();
        // Create a filter. Might be nice for a user so they won't have to search through files in a folder.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        // set filter.
        fc.setFileFilter(filter);
        //Rather than create an integer and compare in an if statement I decided it would be better to call the open dialog and 
        // based on what it returns to compare that to JFileChoosers approve option.
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // grabs the image path from the user.
            imagePath = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
            // sets the image from the image path into the Jlabel.
            picture.setIcon(imagePath);
            // pack again, so as if the user chooses a large file they will not have to resize the screen.
            pack();
        }
    }

    public static void main(String[] args) {
        // make an image viewer.
        Image_Viewer iv = new Image_Viewer();
    }
}
