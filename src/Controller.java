import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controller implements KeyListener {
    private Model model;
    private View view;
    private String targetText;
    private StringBuilder currentInput;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.targetText = model.getRandomWord();
        this.currentInput = new StringBuilder();
        updateView();
        view.setFocusable(true);
        view.requestFocusInWindow();
        view.addKeyListener(this);
        view.getResetButton().addActionListener(e -> {
            targetText = model.getRandomWord();
            currentInput.setLength(0);
            updateView();
        });
    }


    private void updateView() {
        StringBuilder styledText = new StringBuilder();
        String labelText = "<html>" + styledText.toString() + "</html>";
        for (int i = 0; i < targetText.length(); i++) {
            char ch = targetText.charAt(i);
            if (i < currentInput.length() && currentInput.charAt(i) == ch) {
                // Правильно введенная буква становится большой и красной
                Font currentFont = view.getTextLabel().getFont();
                Font newFont = new Font(currentFont.getName(), Font.BOLD, currentFont.getSize());
                view.getTextLabel().setFont(newFont);
                view.updateText(styledText.toString());
                styledText.append(Character.toUpperCase(ch));
            } else {
                // Остальные буквы остаются как есть
                Font currentFont = view.getTextLabel().getFont();
                Font newFont = new Font(currentFont.getName(), Font.PLAIN, currentFont.getSize());
                view.getTextLabel().setFont(newFont);
                view.getTextLabel().setForeground(Color.BLACK);
                styledText.append(ch);
            }
        }
        view.updateText(styledText.toString());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char typedChar = e.getKeyChar();
        char expectedChar = targetText.charAt(currentInput.length());
        if (typedChar == expectedChar) {
            currentInput.append(typedChar);
            if (currentInput.length() == targetText.length()) {
                targetText = model.getRandomWord();
                currentInput.setLength(0);
            }
        }
        view.setFocusable();
        updateView();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}