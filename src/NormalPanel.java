import javax.swing.*;

public class NormalPanel extends JPanel {

    private double[] alpha = {0.7}; //output elasticity of capital
    private double[] depreciation = {0.04}; //annual depreciation rate
    private double[] n = {0.01}; //annual population growth rate
    private double[] g = {0.02}; //annual labor efficiency growth rate
    private double[] kstar = {2.31108}; //capital stock
    private double[] c = {1.63573}; //consumption
    private double[] i = {0.16178}; //investment
    private double[] s = {0.09}; //saving
    private double[] production = {1.79751}; //total output
    private int[] mode = {1}; //production function, 0 = Linear, 1 = Cobb-Douglas

    private JLabel kstarLabel;
    private JLabel cLabel;
    private JLabel iLabel;
    private JLabel sLabel;
    private JLabel productionLabel;

    public NormalPanel(MainFrame mainFrame) {

        //result output labels
        this.setLayout(null);
        kstarLabel = new JLabel ("The capital stock is " + String.format("%.2f", kstar[0]) + " units of capital per worker.");
        kstarLabel.setBounds(100, 60, 500, 100);
        this.add(kstarLabel);
        cLabel = new JLabel("The level of consumption is " + String.format("%.2f", c[0]) + " units.");
        cLabel.setBounds(100, 80, 500, 100);
        this.add(cLabel);
        iLabel = new JLabel("The level of investment is " + String.format("%.2f", i[0]) + " units.");
        iLabel.setBounds(100, 100, 500, 100);
        this.add(iLabel);
        productionLabel = new JLabel ("The level of output is " + String.format("%.2f", production[0]) + " units.");
        productionLabel.setBounds(100, 120, 500, 100);
        this.add(productionLabel);

        //slider input labels
        JSlider alphaSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 70);
        alphaSlider.setMajorTickSpacing(10);
        alphaSlider.setMinorTickSpacing(1);
        alphaSlider.setPaintTicks(true);
        alphaSlider.setPaintLabels(true);
        alphaSlider.setBounds(300, 300, 250, 40);
        JLabel alphaPercentage = new JLabel(alphaSlider.getValue() + "%");
        alphaSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            alpha[0] = (source.getValue()/100.0);
            alphaPercentage.setText(source.getValue() + "%");
            update();
        });
        JSlider savingsSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 9);
        savingsSlider.setMajorTickSpacing(10);
        savingsSlider.setMinorTickSpacing(1);
        savingsSlider.setPaintTicks(true);
        savingsSlider.setPaintLabels(true);
        savingsSlider.setBounds(300, 350, 250, 40);
        JLabel savingsPercentage = new JLabel(savingsSlider.getValue() + "%");
        savingsSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            s[0] = (source.getValue()/100.0);
            savingsPercentage.setText(source.getValue() + "%");
            update();
        });
        JSlider depreciationSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 4);
        depreciationSlider.setMajorTickSpacing(10);
        depreciationSlider.setMinorTickSpacing(1);
        depreciationSlider.setPaintTicks(true);
        depreciationSlider.setPaintLabels(true);
        depreciationSlider.setBounds(300, 400, 250, 40);
        JLabel depreciationPercentage = new JLabel(depreciationSlider.getValue() + "%");
        depreciationSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            depreciation[0] = (double)(source.getValue()/100.0);
            depreciationPercentage.setText(source.getValue() + "%");
            update();
        });
        JSlider populationSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);
        populationSlider.setMajorTickSpacing(10);
        populationSlider.setMinorTickSpacing(1);
        populationSlider.setPaintTicks(true);
        populationSlider.setPaintLabels(true);
        populationSlider.setBounds(300, 450, 250, 40);
        JLabel populationPercentage = new JLabel(populationSlider.getValue() + "%");
        populationSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            n[0] = (double)(source.getValue()/100.0);
            populationPercentage.setText(source.getValue() + "%");
            update();
        });
        JSlider growthSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 2);
        growthSlider.setMajorTickSpacing(10);
        growthSlider.setMinorTickSpacing(1);
        growthSlider.setPaintTicks(true);
        growthSlider.setPaintLabels(true);
        growthSlider.setBounds(300, 500, 250, 40);
        JLabel growthPercentage = new JLabel(growthSlider.getValue() + "%");
        growthSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            g[0] = (double)(source.getValue()/100.0);
            growthPercentage.setText(source.getValue() + "%");
            update();
        });
        JLabel alphaLabel = new JLabel("<html>Output elasticity of capital % (&alpha)</html>");
        alphaLabel.setBounds(50, 260, 300, 100);
        alphaPercentage.setBounds(570, 260, 100, 100);
        JLabel savingsLabel = new JLabel("Annual savings % (s)");
        savingsLabel.setBounds(50, 310, 300, 100);
        savingsPercentage.setBounds(570, 310, 100, 100);
        JLabel depreciationLabel = new JLabel("<html>Annual depreciation % (&delta)</html>");
        depreciationLabel.setBounds(50, 360, 300, 100);
        depreciationPercentage.setBounds(570, 360, 100, 100);
        JLabel populationLabel = new JLabel("Annual population growth rate % (n)");
        populationLabel.setBounds(50, 410, 300, 100);
        populationPercentage.setBounds(570, 410, 100, 100);
        JLabel growthLabel = new JLabel("Annual labor efficiency growth rate % (g)");
        growthLabel.setBounds(50, 460, 300, 100);
        growthPercentage.setBounds(570, 460, 100, 100);

        //display input and output elements
        this.add(alphaSlider);
        this.add(growthSlider);
        this.add(populationSlider);
        this.add(depreciationSlider);
        this.add(alphaLabel);
        this.add(growthLabel);
        this.add(populationLabel);
        this.add(depreciationLabel);
        this.add(alphaPercentage);
        this.add(growthPercentage);
        this.add(populationPercentage);
        this.add(depreciationPercentage);
        this.add(savingsSlider);
        this.add(savingsPercentage);
        this.add(savingsLabel);

        //choose production function
        JLabel chooseFunction = new JLabel("Choose a production function:");
        chooseFunction.setBounds(100, 300, 200, 500);
        this.add(chooseFunction);
        String[] functions = {"Linear", "Cobb-Douglas" /*,"Leontief"*/};
        JComboBox functionList = new JComboBox(functions);
        functionList.setSelectedIndex(1);
        functionList.setBounds(300, 515, 150, 80);
        this.add(functionList);

        //chosen production function information
        String[] currentFunction = {String.valueOf(functionList.getSelectedItem())};
        JLabel functionDescription = new JLabel("<html>The general form of the Cobb-Douglas production function is K<sup>&alpha</sup>L<sup>(1-&alpha)</sup></html>");
        functionDescription.setBounds(100, 278, 500, 600);
        this.add(functionDescription);
        functionList.addActionListener(e -> {
            update();
            currentFunction[0] = String.valueOf(functionList.getSelectedItem());
            if (currentFunction[0].equals("Linear")) {
                functionDescription.setText("<html>The general form of the Linear production function is &alpha;K + (1-&alpha)L</html>");
                mode[0] = 0;
            } else if (currentFunction[0].equals("Cobb-Douglas")) {
                functionDescription.setText("<html>The general form of the Cobb-Douglas production function is K<sup>&alpha</sup>L<sup>(1-&alpha)</sup></html>");
                mode[0] = 1;
            } /*else {
                functionDescription.setText("The general form of the Leontief production function is MIN(K, L)");
                mode[0] = 2;
            }*/
        });

        //return to home menu
        JButton backButton = new JButton("Return to menu");
        backButton.setBounds(235, 600, 230, 50);
        this.add(backButton);
        backButton.addActionListener(e -> {
            WelcomePanel welcomePanel = new WelcomePanel(mainFrame);
            mainFrame.getContentPane().add(welcomePanel, "Solow Steady State");
            welcomePanel.setVisible(true);
            this.setVisible(false);
            mainFrame.getContentPane().remove(this);
        });
    }

    //update output labels with new slider values
    private void update() {
        if (mode[0] == 0) { //Linear
            double numerator = s[0] * (1 - alpha[0]);
            double denominator = depreciation[0] + n[0] + g[0]-(alpha[0] * s[0]);
            if (Double.compare(numerator, denominator) == 0 || numerator / denominator < 0) {
                kstar[0] = Double.NaN;
                c[0] = Double.NaN;
                i[0] = Double.NaN;
                production[0] = Double.NaN;
            } else {
                kstar[0] = numerator / denominator;
                i[0] = (depreciation[0] + n[0] + g[0]) * kstar[0];
                production[0] = alpha[0] * (kstar[0] - 1) + 1;
                c[0] = production[0] * (1 - s[0]);
            }
        } else if (mode[0] == 1) { //Cobb-Douglas
            kstar[0] = Math.pow(s[0] / (depreciation[0] + n[0] + g[0]), 1 / (1-alpha[0]));
            i[0] = (depreciation[0] + n[0] + g[0]) * kstar[0];
            production[0] = Math.pow(kstar[0], alpha[0]);
            c[0] = production[0] * (1 - s[0]);
        } else {
            //Leontief possible?
        }

        //invalid state edge casing
        if (Double.isNaN(kstar[0])) {
            kstarLabel.setText("The capital stock is undefined.");
        } else {
            kstarLabel.setText("The capital stock is " + String.format("%.2f", kstar[0]) + " units of capital per worker.");
        }
        if (Double.isNaN(c[0])) {
            cLabel.setText("The level of consumption is undefined.");
        } else {
            cLabel.setText("The level of consumption is " + String.format("%.2f", c[0]) + " units.");
        }
        if (Double.isNaN(i[0])) {
            iLabel.setText("The level of investment is undefined.");
        } else {
            iLabel.setText("The level of investment is " + String.format("%.2f", i[0]) + " units.");
        }
        if(Double.isNaN(production[0])) {
            productionLabel.setText("The level of output is undefined.");
        } else {
            productionLabel.setText("The level of output is " + String.format("%.2f", production[0]) + " units.");
        }
    }
}
