package net.PLACGames;
import javax.swing.*;
import javax.xml.transform.sax.SAXSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static Integer mynumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein!");
    static JTextField textField = new JTextField();

    public static void main(String[] args) {
        openUI();
        //nextRound();
    }

    public static void openUI() {
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);


        text.setBounds(50, 50 , 350, 30);


        textField.setBounds(50, 100, 200, 30);




        JButton button = new JButton("Raten!");
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFromTextfield = textField.getText();
                Integer number = Integer.parseInt(textFromTextfield);
                guess(number);
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }



    public static void nextRound() {
        tries++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe eine Zahl ein:");
        Integer number = scanner.nextInt();
        guess(number);
    }

    public static void guess(Integer number) {
        if(number == mynumber) {
            System.out.println("HGW richtige Antwort!");
            System.out.println("Du hast " + tries + " Versuche gebraucht!");

            text.setText("HGW richtige Antwort mit " + tries + " Versuchen.");


        } else {
            tries++;
           if(number < mynumber) {
               text.setText("Falsch geraten! Deine Zahl ist zu klein.");
               System.out.println("Deine Zahl ist zu klein!");
           } else {
                   text.setText("Falsch geraten! Deine Zahl ist zu gross.");
               }
           textField.setText("");
           }
        //nextRound();
        }
    }



