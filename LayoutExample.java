import javax.swing.*;
import java.awt.*;

public class LayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 3; i++) {
            flowPanel.add(new JButton("Button " + i));
        }

        // BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);

        // GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(2, 3));
        for (int i = 4; i <= 9; i++) {
            gridPanel.add(new JButton("Button " + i));
        }

        // GridBagLayout
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 10; i <= 12; i++) {
            gbc.gridx = i - 10;
            gbc.gridy = 0;
            gridBagPanel.add(new JButton("Button " + i), gbc);
        }

        // CardLayout
        JPanel cardPanel = new JPanel(new CardLayout());
        for (int i = 13; i <= 15; i++) {
            cardPanel.add(new JButton("Card " + i), "Card " + i);
        }

        // Display the panels using a BoxLayout
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);

        frame.add(flowPanel);
        frame.add(borderPanel);
        frame.add(gridPanel);
        frame.add(gridBagPanel);
        frame.add(cardPanel);

        frame.pack();
        frame.setVisible(true);
    }
}
