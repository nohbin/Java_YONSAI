package day0413;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieTicketBooking extends JFrame implements ActionListener {

    // 컴포넌트 정의
    private JTextField movieTitleTextField;
    private JButton checkButton;
    private JTextArea statusTextArea;
    private JPanel moviePanel;

    // 예매 현황
    private String[] movieTitles = {"어벤져스", "스파이더맨", "라라랜드", "겨울왕국2"};
    private boolean[][] bookingStatus = {
        {true, true, false, false, true},
        {true, true, true, false, true},
        {true, false, false, true, false},
        {false, true, true, true, false}
    };

    // 생성자
    public MovieTicketBooking() {
        super("영화 예매");

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 상단 패널 - 영화 제목 입력
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("영화 제목: "));
        movieTitleTextField = new JTextField(10);
        topPanel.add(movieTitleTextField);
        checkButton = new JButton("예매 확인");
        checkButton.addActionListener(this);
        topPanel.add(checkButton);
        add(topPanel, BorderLayout.NORTH);

        // 좌측 패널 - 영화 제목 출력
        moviePanel = new JPanel();
        moviePanel.setLayout(new GridLayout(movieTitles.length, 1));
        for (String title : movieTitles) {
            JLabel label = new JLabel(title);
            label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            moviePanel.add(label);
        }
        add(moviePanel, BorderLayout.WEST);

        // 중앙 패널 - 예매 현황 출력
        statusTextArea = new JTextArea(10, 20);
        statusTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // 프레임 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setVisible(true);
    }

    // ActionListener 메소드
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            // 영화 제목 검색
            String movieTitle = movieTitleTextField.getText();
            int movieIndex = -1;
            for (int i = 0; i < movieTitles.length; i++) {
                if (movieTitles[i].equals(movieTitle)) {
                    movieIndex = i;
                    break;
                }
            }

            // 예매 현황 출력
            if (movieIndex == -1) {
                JOptionPane.showMessageDialog(this, "해당하는 영화가 없습니다.");
            } else {
                String status = "";
                for (int i = 0; i < bookingStatus[movieIndex].length; i++) {
                    status += (bookingStatus[movieIndex][i] ? "예매" : "비매") + "\t";
                }
                statusTextArea.setText(status);
            }
        }
    }

    // 메인 메소드
    public static void main(String[] args) {
        new MovieTicketBooking();
    }
}

 

