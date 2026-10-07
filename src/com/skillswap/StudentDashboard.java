package com.skillswap;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {

    public StudentDashboard(int userId, String name) {

        setTitle("Campus Skill Swap - Student Dashboard");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Welcome, " + name + "!");
        title.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel subtitle = new JLabel(
                "Find students, share your skills and start swapping."
        );

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(title);
        top.add(subtitle);

        JPanel cards = new JPanel(new GridLayout(1, 3, 20, 20));

        JButton offerSkill = new JButton("Offer a Skill");
        JButton findSkill = new JButton("Find a Skill");
        JButton requests = new JButton("Swap Requests");

        cards.add(offerSkill);
        cards.add(findSkill);
        cards.add(requests);

        JButton logout = new JButton("Logout");

        logout.addActionListener(e -> {
            new Dashboard();
            dispose();
        });

        panel.add(top, BorderLayout.NORTH);
        panel.add(cards, BorderLayout.CENTER);
        panel.add(logout, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
}