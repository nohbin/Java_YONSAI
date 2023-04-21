package day0414;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonExample extends JFrame implements ActionListener {
    private JButton menuButton;
    private JButton checkoutButton;
    private JButton closeButton;

    public ButtonExample() {
        setTitle("Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 버튼 생성
        menuButton = new JButton("Menu");
        checkoutButton = new JButton("Checkout");
        closeButton = new JButton("Close");

        // 이벤트 리스너 등록
        menuButton.addActionListener(this);
        checkoutButton.addActionListener(this);
        closeButton.addActionListener(this);

        // 버튼 추가
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(menuButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public class MenuPage extends JFrame {
        public MenuPage() {
            setTitle("Menu");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // 메뉴 구현
            JPanel menuPanel = new JPanel();
            menuPanel.add(new JLabel("Menu 1"));
            menuPanel.add(new JLabel("Menu 2"));
            menuPanel.add(new JLabel("Menu 3"));
            add(menuPanel);

            pack();
        }
    }
   
    public static void main(String[] args) {
        new ButtonExample();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

