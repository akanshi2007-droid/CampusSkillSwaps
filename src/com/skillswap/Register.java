package com.skillswap;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField departmentField;
    private JTextField yearField;

    public Register() {

        setTitle("Campus Skill Swap - Register");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Create Your Account");
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel subtitle = new JLabel("Join the Campus Skill Swap community");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        departmentField = new JTextField();
        yearField = new JTextField();

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Dashboard");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(title, gbc);

        gbc.gridy++;
        mainPanel.add(subtitle, gbc);

        gbc.gridwidth = 1;

        gbc.gridy++;
        mainPanel.add(new JLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Department:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(departmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(new JLabel("Year:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        mainPanel.add(registerButton, gbc);

        gbc.gridy++;
        mainPanel.add(backButton, gbc);

        registerButton.addActionListener(e -> registerUser());

        backButton.addActionListener(e -> {
            new Dashboard();
            dispose();
        });

        add(mainPanel);

        setVisible(true);
    }

    private void registerUser() {

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String department = departmentField.getText().trim();
        String yearText = yearField.getText().trim();

        if (name.isEmpty() || email.isEmpty() ||
                password.isEmpty() || department.isEmpty() ||
                yearText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int year;

        try {
            year = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Year must be a number.",
                    "Invalid Year",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String sql = """
                INSERT INTO users
                (name, email, password, department, year)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, department);
            statement.setInt(5, year);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Registration successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                new Login();
                dispose();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Registration failed.\n" + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }
}