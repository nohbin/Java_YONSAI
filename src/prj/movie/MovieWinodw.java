package prj.movie;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import prj.member.BaseWindow;

public class MovieWinodw extends BaseWindow {
	public MovieWinodw() {
		System.out.println("생성자 호출");

		frame = new JFrame("영화관리");
		lId = new JLabel("아이디", Label.RIGHT);
		lName = new JLabel("이름", Label.RIGHT);
		lGenre = new JLabel("장르", Label.RIGHT);
		lRuntime = new JLabel("상영시간", Label.RIGHT);
		lAge = new JLabel("나이등급", Label.RIGHT);

		lId.setHorizontalAlignment(JLabel.CENTER);
		lName.setHorizontalAlignment(JLabel.CENTER);
		lGenre.setHorizontalAlignment(JLabel.CENTER);
		lRuntime.setHorizontalAlignment(JLabel.CENTER);
		lAge.setHorizontalAlignment(JLabel.CENTER);

		tId = new JTextField();
		tName = new JTextField();
		tGenre = new JTextField();
		tRuntime = new JTextField();
		tAge = new JTextField();

		btnSearch = new JButton("조회");
		btnInsert = new JButton("등록");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");

	}

	// 회원 관리 화면을 구성한다.
	public void startGUI() {
		part1 = new JPanel();
		part1.setLayout(new GridLayout(1, 0));
		part1.add(lId);
		part1.add(tId);

		part2 = new JPanel();
		part2.setLayout(new GridLayout(1, 0));
		part2.add(lName);
		part2.add(tName);

		part3 = new JPanel();
		part3.setLayout(new GridLayout(1, 0));
		part3.add(lGenre);
		part3.add(tGenre);

		part4 = new JPanel();
		part4.setLayout(new GridLayout(1, 0));
		part4.add(lRuntime);
		part4.add(tRuntime);

		part5 = new JPanel();
		part5.setLayout(new GridLayout(1, 0));
		part5.add(lAge);
		part5.add(tAge);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(0, 1));
		p1.add(part1);
		p1.add(part2);
		p1.add(part3);
		p1.add(part4);
		p1.add(part5);

		p2 = new JPanel();

		p2.add(btnSearch);
		p2.add(btnInsert);
		p2.add(btnUpdate);
		p2.add(btnDelete);

		guiList = new List(2, false);
		guiList.setBackground(Color.green);
		// Listener를 등록한다.
		btnSearch.addActionListener(new MovieHandler());
		btnInsert.addActionListener(new MovieHandler());
		btnUpdate.addActionListener(new MovieHandler());
		btnDelete.addActionListener(new MovieHandler());

		init2();// 프로그램 실행 시 DB와 연동해서 데이터를 조회한다.

		frame.add(p1, "North");
		frame.add(guiList, "Center");
		frame.add(p2, "South");

		frame.setSize(500, 500);
		frame.setVisible(true);

	}

	public class MovieHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSearch) {
				init2();
			} else if (e.getSource() == btnInsert) {

				// 사용자가 입력한 회원 정보를 가지고 온다.
				MovieVo mem = new MovieVo();
				String id = tId.getText();
				String name = tName.getText();
				String genre = tGenre.getText();
				int runtime = Integer.parseInt(tRuntime.getText());
				int age = Integer.parseInt(tAge.getText());

				mem.setId(id);
				mem.setName(name);
				mem.setGenre(genre);
				mem.setRuntime(runtime);
				mem.setAge(age);
				// 회원저정보를 추가한다.
				movieController.insertMember(mem);
				// 회원 정보를 추가한 후 데이터를 조회한다.
				init2();
			} else if (e.getSource() == btnUpdate) {
				System.out.println("수정 버튼 클릭");
				MovieVo mem = new MovieVo();
				String id = tId.getText();
				String name = tName.getText();
				String genre = tGenre.getText();
				int runtime = Integer.parseInt(tRuntime.getText());
				int age = Integer.parseInt(tAge.getText());
				
				mem.setId(id);
				mem.setName(name);
				mem.setGenre(genre);
				mem.setRuntime(runtime);
				mem.setAge(age);
				
				movieController.updateMember(mem);
				init2();
			} else if (e.getSource() == btnDelete) {
				MovieVo mem = new MovieVo();
				String id = tId.getText();
				mem.setId(id);
				movieController.deleteMember(mem);
				init2();
			}

		}

	}

}
