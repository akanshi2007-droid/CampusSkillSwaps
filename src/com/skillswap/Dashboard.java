package com.skillswap;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Campus Skill Swap");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // ---------- TOP ----------
        JPanel header = new JPanel();
        header.setBackground(new Color(30, 41, 59));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(35, 30, 35, 30));

        JLabel title = new JLabel("CAMPUS SKILL SWAP");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "Learn. Teach. Connect."
        );
        subtitle.setForeground(new Color(203, 213, 225));
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 17));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(10));
        header.add(subtitle);

        // ---------- CENTER ----------
        JPanel content = new JPanel();
        content.setBackground(new Color(245, 247, 250));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(35, 100, 35, 100));

        JLabel heading = new JLabel(
                "Exchange knowledge with your campus community."
        );
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel(
                "Teach what you know. Learn something new. Build connections."
        );
        description.setFont(new Font("SansSerif", Font.PLAIN, 14));
        description.setForeground(new Color(71, 85, 105));
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        content.add(heading);
        content.add(Box.createVerticalStrut(10));
        content.add(description);
        content.add(Box.createVerticalStrut(35));

        // ---------- BUTTONS ----------
        JButton exploreButton = createButton(
                "Explore Skills",
                new Color(51, 65, 85)
        );

        JButton loginButton = createButton(
                "Login",
                new Color(37, 99, 235)
        );

        JButton registerButton = createButton(
                "Register",
                new Color(16, 185, 129)
        );

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        buttonPanel.setBackground(new Color(245, 247, 250));

        buttonPanel.add(exploreButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        content.add(buttonPanel);

        // ---------- FOOTER ----------
        JLabel footer = new JLabel(
                "Campus Skill Swap • Share Skills • Grow Together"
        );
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("SansSerif", Font.PLAIN, 12));
        footer.setForeground(new Color(100, 116, 139));
        footer.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        // ---------- ACTIONS ----------
        loginButton.addActionListener(e -> {
            new Login();
            dispose();
        });

        registerButton.addActionListener(e -> {
            new Register();
            dispose();
        });

        exploreButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Skill exploration will be available soon!",
                    "Explore Skills",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(content, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private JButton createButton(String text, Color background) {

        JButton button = new JButton(text);

        button.setFont(new Font("SansSerif", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(background);

        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(14, 20, 14, 20));

        return button;
    }
}