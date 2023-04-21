package prj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import prj.member.MemberWindow;
import prj.movie.MovieWinodw;

public class MainWindow {
	private JFrame frame;
	private JButton btnMember, btnBoard, btnMovie;

	public MainWindow() {
		frame = new JFrame("메인 화면");
		btnMember = new JButton("회원 관리");
		btnBoard = new JButton("게시판 관리");
		btnMovie = new JButton("영화 관리");
	}

	public void startMain() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.add(btnMember);
		frame.add(btnBoard);
		frame.add(btnMovie);

		// Listener연결하기
		btnMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberWindow memberWindow = new MemberWindow();
				memberWindow.startGUI();
			}
		});
		
		btnMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieWinodw movieWindow = new MovieWinodw();
				movieWindow.startGUI();
				
			}
		});

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	public static void main(String args[]) {

		MainWindow main = new MainWindow();
		main.startMain();
	}
}
