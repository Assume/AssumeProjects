package org.assume.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomText extends JFrame {
    private static final long serialVersionUID = 1L;

    private String finalText;
    private JLabel[] labels;
    private String[] labelText;
    private int numLabels; //number of lines of text to show
    private Random random; //random number generator

    private static final char LOWER_BOUNDARY = 32; //lower ascii number boundary
    private static final char UPPER_BOUNDARY = 126; //upper ascii number boundary
    private static final Color BG_COLOR = Color.BLACK; //background colour
    private static final Color FG_COLOR = Color.GREEN; //text colour
    private static final int DELAY = 75; //loop delay

    public RandomText(String text, int numLabels) {
        super("Super Cool Text");
        random = new Random();

        setLayout(new GridLayout(numLabels, 1));
        setResizable(false);
        if (text == null || text.isEmpty()) throw new IllegalArgumentException("Empty String");
        if (numLabels < 2) throw new IllegalArgumentException("Must have at least 2 labels");
        this.numLabels = numLabels;
        finalText = text;
        labels = new JLabel[numLabels];
        labelText = new String[numLabels];
        int textLength = text.length();
        for (int i = 0; i < numLabels; i++) {
            labelText[i] = randomString(textLength);
            labels[i] = new JLabel(labelText[i]);
            labels[i].setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            labels[i].setOpaque(true);
            labels[i].setBackground(BG_COLOR);
            labels[i].setForeground(FG_COLOR);
            add(labels[i]);
        }

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        while (!isFinished()) {
            try {
                Thread.sleep(DELAY);
            } catch (Exception e) {}
        }
    }

    //return a random char between the upper and lower boundaries (both inclusive)
    private char randomChar() {
        return (char) (random.nextInt(UPPER_BOUNDARY - LOWER_BOUNDARY + 1) + LOWER_BOUNDARY);
    }

    //return a random String of the given length using the randomChar() function
    private String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(randomChar());
        }
        return sb.toString();
    }

    //returns true when the bottom line of text is equal to the desired text
    private boolean isFinished() {
        if (finalText.equals(labelText[numLabels - 1])) {
            return true;
        }

        for (int i = 0; i < finalText.length(); i++) {
            char c = labelText[numLabels - 1].charAt(i);
            if (c == finalText.charAt(i)) {
                continue;
            }
            labelText[numLabels - 1] = labelText[numLabels - 1].substring(0, i) + labelText[numLabels - 2].charAt(i) + labelText[numLabels - 1].substring(i + 1);
            labels[numLabels - 1].setText(labelText[numLabels - 1]);
        }

        for (int i = numLabels - 2; i > 0; i--) {
            labelText[i] = labelText[i-1];
            labels[i].setText(labelText[i]);
        }

        labelText[0] = randomString(finalText.length()); //we need a new top line        
        labels[0].setText(labelText[0]);

        return false;
    }

    public static void main(String[] args) {
        new RandomText("Big big booty bitches. Das right, big big booty bitches", 25);
    }
}