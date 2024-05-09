import javax.swing.*;
import java.awt.*;


class View extends JFrame {
    private JLabel textLabel;
    private int fontSize;
    private JButton resetButton;

    public View(String text) {
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setLayout(null);
        fontSize = 12;
        textLabel = new JLabel(text);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        textLabel.setBounds(250, 90, 200, 200);
        add(textLabel);

        resetButton = new JButton("Reset");
        resetButton.setBounds(190, 300, 200, 50);
        add(resetButton);
    }

    public void updateText(String text) {
        textLabel.setText(text);
    }

    public JButton getResetButton() {
        return resetButton;
    }
    public JLabel getTextLabel() {
        return textLabel;
    }
    public void setFocusable() {
        resetButton.setFocusable(false);
    }
}