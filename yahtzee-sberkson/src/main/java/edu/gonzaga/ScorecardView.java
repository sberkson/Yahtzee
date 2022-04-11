package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.border.Border;

public class ScorecardView 
{
    JPanel myPanel;
    ArrayList<JTextField> scoreLines;
    ArrayList<JButton> scoreButtons;
    JButton displayScorecardButton;

    Scorecard scorecard;

    void setupPanel()
    {
        myPanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        myPanel.setSize(10, 10);
        myPanel.setBorder(blackline);
    }

    void setupScoreLines()
    {
        scoreLines = new ArrayList<JTextField>();
        for( int i = 0; i < scorecard.getScores().size(); i++ )
        {
            JTextField newLine = new JTextField(10);
            newLine.setText(scorecard.getScores().get(i).toString());
            newLine.setSize(10, 20);
            newLine.setBounds(10, 10, 10, 10);
            newLine.setEditable(false);
            scoreLines.add(newLine);
        }
    }

    void setupScoreButtons()
    {
        scoreButtons = new ArrayList<JButton>();
        for( int i = 0; i < scorecard.getScores().size(); i++ )
        {
            JButton newButton = new JButton("Score");
            Integer index = i;
            newButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Button pressed to score");
                        scorecard.removedCategories.add(Integer.toString(index));
                        scorecard.scoring();
                    }
                }
            );
            scoreButtons.add(newButton);
            myPanel.add(scoreLines.get(i));
            myPanel.add(newButton);
        }
    }

    ScorecardView(Scorecard scorecard)
    {
        this.scorecard = scorecard;
        setupPanel();
        setupScoreLines();
        setupScoreButtons();
    }

    public JPanel getPanel()
    {
        return myPanel;
    }
}
