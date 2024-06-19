
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class LockerApplication extends JFrame {

        private JLabel titleLabel, enterPasswordLabel;
        private JTextField passwordField;
        private JButton[] numberButtons;
        private JButton clearButton, enterButton;

        private String password;
        private boolean passwordSet = false;

        public LockerApplication() {
            setTitle("Locker Application");
            setSize(300, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);

            titleLabel = new JLabel("Locker Application");
            titleLabel.setBounds(90, 10, 120, 20);
            add(titleLabel);

            enterPasswordLabel = new JLabel("Enter Password:");
            enterPasswordLabel.setBounds(20, 40, 120, 20);
            add(enterPasswordLabel);

            passwordField = new JTextField();
            passwordField.setBounds(150, 40, 120, 20);
            passwordField.setEditable(false); // to disable direct input
            add(passwordField);

            numberButtons = new JButton[9];
            for (int i = 0; i < 9; i++) {
                final int digit = i + 1;
                numberButtons[i] = new JButton(String.valueOf(digit));
                numberButtons[i].setBounds(20 + (i % 3) * 60, 80 + (i / 3) * 50, 50, 40);
                numberButtons[i].addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        passwordField.setText(passwordField.getText() + digit);
                    }
                });
                add(numberButtons[i]);
            }

            clearButton = new JButton("Clear");
            clearButton.setBounds(20, 230, 100, 40);
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passwordField.setText("");
                }
            });
            add(clearButton);

            enterButton = new JButton("Enter");
            enterButton.setBounds(170, 230, 100, 40);
            enterButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String passcode = passwordField.getText();
                    if (!passwordSet) {
                        password = passcode;
                        passwordSet = true;
                        JOptionPane.showMessageDialog(null, "Password Set Successfully!");
                    } else {
                        if (passcode.equals(password)) {
                            JOptionPane.showMessageDialog(null, "Correct Password");
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Password");
                        }
                    }
                    passwordField.setText("");
                }
            });
            add(enterButton);

            setVisible(true);
        }

        public static void main(String[] args) {
            new LockerApplication();
        }
    }

