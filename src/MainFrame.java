import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame("Solow Steady State");
                    frame.setSize(700, 700);
                    frame.setResizable(false);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public MainFrame(String frameTitle) {
        super(frameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        WelcomePanel welcomePanel = new WelcomePanel(this);
        contentPane.add(welcomePanel, "Welcome screen");
    }
}