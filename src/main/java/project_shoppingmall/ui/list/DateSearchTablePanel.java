package project_shoppingmall.ui.list;

import javax.swing.SwingConstants;

import project_shoppingmall.dto.DateSearch;
import project_shoppingmall.service.DateSearchService;

@SuppressWarnings("serial")
public class DateSearchTablePanel extends AbstractCustomTablePanel<DateSearch> {

	public DateSearchTablePanel() {

	}

	private DateSearchService service;

	@Override
	public void initList() {
		list = service.showDateSearch();
	}

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 100, 100, 100, 100, 100, 100);
	}

	@Override
	public Object[] toArray(DateSearch t) {
		return new Object[] {
				t.getSell_date().getSell_date(),
				t.getUser_no().getUser_id(),
				t.getUser_name().getUser_id(),
				t.getUser_phone().getUser_id(),
				t.getP_code().getP_name(),
				t.getSellqty().getOrderat(),
				t.getOrderat().getOrderat()
		};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {
				"날짜","회원번호","회원명", "휴대전화", "제품코드","주문수량", "판매액"};
	}
	
	public void setService(DateSearchService service) {
		this.service=service;
	}
}
