import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Cars {
	private YearMonth yearMonth;
	private Integer sales;

	public Cars(String yearMonth, String sales) {
		this.yearMonth = YearMonth.parse(yearMonth, DateTimeFormatter.ofPattern("MMM-yy"));
		this.sales = Integer.parseInt(sales);
	}

	public YearMonth getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(YearMonth yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Cars [yearMonth=" + yearMonth + ", sales=" + sales + "]";
	}

}
