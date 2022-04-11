package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class YahtzeeGUI {
    static GraphicsConfiguration gc;
    JFrame mainWindow;

    Hand hand;
    Scorecard scorecard;
    HandView handView;
    ScorecardView scorecardView;

    void setupMainWindow() {
        mainWindow = new JFrame(gc);
        mainWindow.setTitle("Yahtzee");
        mainWindow.setSize(600, 400);
        mainWindow.setLocation(200,200);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void startGUI() {
        mainWindow.setVisible(true);
    }

    void setupHand(Integer numDice, Integer numSides, Integer numRolls) {
        hand = new Hand(numDice, numSides);
    }

    void setupHandView() {
        handView = new HandView(hand);
    }

    void setupScorecard() {
        scorecard = new Scorecard(hand);
    }

    void setupScorecardView() {
        scorecardView = new ScorecardView(scorecard);
    }

    public YahtzeeGUI(Game game) {
        Integer numDice = game.getNumDice();
        Integer numSides = game.getNumSides();
        Integer numRolls = game.getNumRolls();


        setupHand(numDice, numSides, numRolls);
        setupHandView();
        setupScorecard();
        setupScorecardView();
        setupMainWindow();

        DieView dv = new DieView();
        dv.setDieToView(hand.getDieAt(0));

        Die die = hand.getDieAt(0);
        die.roll();
        JPanel handPanel = handView.getPanel();
        JPanel scorecardPanel = scorecardView.getPanel();
        handPanel.setLayout(new FlowLayout());
        scorecardPanel.setLayout(new BoxLayout(scorecardPanel, BoxLayout.PAGE_AXIS));
        mainWindow.add(handPanel);
        handPanel.setLocation(500, 50);
        scorecardPanel.setLocation(0, 0);
        scorecardPanel.setBounds(500, 250, 50, 50);
        mainWindow.add(scorecardPanel);
        startGUI();
    }
}