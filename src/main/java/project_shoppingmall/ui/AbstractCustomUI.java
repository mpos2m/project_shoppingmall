package project_shoppingmall.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_shoppingmall.ui.list.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public abstract class AbstractCustomUI<T> extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDate;
	private JButton btnProduct;
	private JButton btnDetail;
	private JButton btnUser;
	private JButton btnCart;
	private JButton btnAdmin;
	
	protected AbstractCustomTablePanel<T> pList;

	
	public AbstractCustomUI() {
		setService();
		initialize();
		tableLoadData();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.NORTH);
		
		btnDate = new JButton("날짜별조회");
		btnDate.addActionListener(this);
		pBtns.add(btnDate);
		
		btnProduct = new JButton("제품별조회");
		pBtns.add(btnProduct);
		
		btnDetail = new JButton("상세조회");
		pBtns.add(btnDetail);
		
		btnUser = new JButton("회원정보조회");
		pBtns.add(btnUser);
		
		btnCart = new JButton("장바구니목록");
		pBtns.add(btnCart);
		
		btnAdmin = new JButton("관리자목록");
		pBtns.add(btnAdmin);
		
		pList = createTablePanel();
		contentPane.add(pList);
	}
	

	protected abstract void setService();
	protected abstract void tableLoadData();
	protected abstract AbstractCustomTablePanel<T> createTablePanel();
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDate) {
			actionPerformedBtnDate(arg0);
		}
	}
	protected void actionPerformedBtnDate(ActionEvent arg0) {
		DateSearchCustomUI frame = new DateSearchCustomUI();
		frame.setVisible(true);
	}
}
