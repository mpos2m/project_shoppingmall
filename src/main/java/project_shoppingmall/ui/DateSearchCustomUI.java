package project_shoppingmall.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project_shoppingmall.dto.DateSearch;
import project_shoppingmall.service.DateSearchService;
import project_shoppingmall.ui.list.AbstractCustomTablePanel;
import project_shoppingmall.ui.list.DateSearchTablePanel;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DateSearchCustomUI extends AbstractCustomUI<DateSearch> {
	private DateSearchService service;
	private JLabel lblTotalQty;
	private JLabel lblTotalAt;
	private int sum = 0;
	
	
	
	public DateSearchCustomUI() {
		setTitle("날짜별 조회");
		
		JPanel pSouth = new JPanel();
		pList.add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pTotalQty = new JPanel();
		pSouth.add(pTotalQty);
		
		JLabel lblQty = new JLabel("총 주문수량 : ");
		pTotalQty.add(lblQty);
		
		lblTotalQty = new JLabel(sum + "개");
		pTotalQty.add(lblTotalQty);
		
		JPanel pTotalAt = new JPanel();
		pSouth.add(pTotalAt);
		
		JLabel lblAt = new JLabel("총 판매액 : ");
		pTotalAt.add(lblAt);
		
		lblTotalAt = new JLabel("0원");
		pTotalAt.add(lblTotalAt);
		
		JPanel pNorth = new JPanel();
		pList.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 5, 10, 0));
		
		JLabel lblNewLabel = new JLabel("날짜별조회");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser((Date) null);
		pNorth.add(dateChooser);
		
		JButton btnNewButton = new JButton("검색");
		pNorth.add(btnNewButton);
	}
	
	@Override
	protected void setService() {
		service = new DateSearchService();
	}

	@Override
	protected void tableLoadData() {
		((DateSearchTablePanel) pList).setService(service);
		pList.loadData();
	}

	@Override
	protected AbstractCustomTablePanel<DateSearch> createTablePanel() {
		return new DateSearchTablePanel();
	}

	

}
