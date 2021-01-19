import javax.swing.*;

public class WelcomePanel extends JPanel {

    public WelcomePanel(MainFrame mainFrame) {
        this.setLayout(null);

        JLabel welcomeLabel = new JLabel("<html><center>This program will detail the US economy's <br>steady state using the Solow model</center</html>");
        welcomeLabel.setBounds(220, -60, 500, 500);
        this.add(welcomeLabel);
        /*JLabel introLabel = new JLabel("What do you want to calculate?");
        introLabel.setBounds(245, -40, 500, 500);
        this.add(introLabel);*/

        JButton normalButton = new JButton("Steady State");
        normalButton.setBounds(235, 250, 230, 50);
        this.add(normalButton);
        normalButton.addActionListener(e -> {
            NormalPanel normalPanel = new NormalPanel(mainFrame);
            mainFrame.getContentPane().add(normalPanel, "Steady State");
            normalPanel.setVisible(true);
            this.setVisible(false);
            mainFrame.getContentPane().remove(this);
        });

        JButton goldenButton = new JButton("Golden Rule");
        goldenButton.setBounds(235, 325, 230, 50);//240,210
        this.add(goldenButton);
        goldenButton.addActionListener(e -> {
            GoldenPanel goldenPanel = new GoldenPanel(mainFrame);
            mainFrame.getContentPane().add(goldenPanel, "Golden Rule");
            goldenPanel.setVisible(true);
            this.setVisible(false);
            mainFrame.getContentPane().remove(this);
        });

        /*JButton priceButton = new JButton("Calculate margin call price");
        priceButton.setBounds(235, 400, 230, 50);//245,200
        this.add(priceButton);
        priceButton.addActionListener(e -> {
            PricePanel pricePanel = new PricePanel(mainFrame);
            mainFrame.getContentPane().add(pricePanel, "Margin Call Price Calculator");
            pricePanel.setVisible(true);
            this.setVisible(false);
            mainFrame.getContentPane().remove(this);
        });*/

        /*JButton returnButton = new JButton("Calculate return on investment");
        returnButton.setBounds(235, 475, 230, 50);
        this.add(returnButton);
        returnButton.addActionListener(e -> {
            ReturnPanel returnPanel = new ReturnPanel(mainFrame);
            mainFrame.getContentPane().add(returnPanel, "Return on Investment Calculator");
            returnPanel.setVisible(true);
            this.setVisible(false);
            mainFrame.getContentPane().remove(this);
        });*/
    }
}
