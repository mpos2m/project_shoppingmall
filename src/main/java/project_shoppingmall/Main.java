package project_shoppingmall;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_shoppingmall.ui.DateSearchCustomUI;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDate;
	private DateSearchCustomUI dateFrame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		createFrame();
		initialize();
	}
	private void createFrame() {
		dateFrame = new DateSearchCustomUI();
		dateFrame.setTitle("날짜별 조회");
		
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 6, 10, 0));
		
		btnDate = new JButton("날짜별 조회");
		btnDate.addActionListener(this);
		contentPane.add(btnDate);
		
		JButton btnProduct = new JButton("제품별 조회");
		contentPane.add(btnProduct);
		
		JButton btnDetail = new JButton("상세 조회");
		contentPane.add(btnDetail);
		
		JButton btnUser = new JButton("회원정보 조회");
		contentPane.add(btnUser);
		
		JButton btnCart = new JButton("장바구니목록");
		contentPane.add(btnCart);
		
		JButton btnAdmin = new JButton("관리자 목록");
		contentPane.add(btnAdmin);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDate) {
			actionPerformedBtnDate(arg0);
		}
	}
	protected void actionPerformedBtnDate(ActionEvent arg0) {
		dateFrame.setVisible(true);
	}
}
