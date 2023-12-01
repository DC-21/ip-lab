import java.awt.*;
import java.awt.event.*;

public class GUICOMPONENTSDEMO extends Frame {
    private TextField textField;
    private Button clickButton;
    private Scrollbar scrollbar;
    private Choice choice;
    private List list;
    private Checkbox checkbox;

    public GUICOMPONENTSDEMO() {
        setLayout(new FlowLayout());

        // Text Field
        textField = new TextField("Type here", 20);
        add(textField);

        // Button
        clickButton = new Button("Click Me");
        add(clickButton);

        // Scrollbar
        scrollbar = new Scrollbar();
        add(scrollbar);

        // Choice
        choice = new Choice();
        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");
        add(choice);

        // List
        list = new List();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        add(list);

        // Checkbox
        checkbox = new Checkbox("Check Me");
        add(checkbox);

        // Event listeners

        // Text Field listener
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Typed: " + textField.getText());
            }
        });

        // Button listener
        clickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });

        // Scrollbar listener for code
        scrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                System.out.println("Scrollbar Value: " + scrollbar.getValue());
            }
        });

        // Choice listener
        choice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Selected: " + choice.getSelectedItem());
            }
        });

        // List listener
        list.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Selected: " + list.getSelectedItem());
            }
        });

        // Checkbox listener
        checkbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Checkbox State: " + checkbox.getState());
            }
        });

        setSize(400, 300);
        setVisible(true);

        // Close the window on click of close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new GUICOMPONENTSDEMO();
    }
}
