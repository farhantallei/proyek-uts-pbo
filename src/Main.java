import gui.LoginFrame;

import javax.swing.*;

/**
 * Main class untuk menjalankan program
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}
