import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		FileOperations fo = new FileOperations();
		List<Cars> model3 = fo.readFile("model3.csv");
		List<Cars> modelS = fo.readFile("modelS.csv");
		List<Cars> modelX = fo.readFile("modelX.csv");

		carReport("Model 3",model3);
		carReport("Model S",modelS);
		carReport("Model X",modelX);
		
	}

	private static void carReport(String models, List<Cars> carModel) {
		
		System.out.println(models + " Yearly Sales Report");
		
		//group by the year
		Map<Integer, List<Cars>> carMap = carModel.stream()
												  .collect(Collectors.groupingBy(y -> y.getYearMonth().getYear()));
	
		//get sales amounts with summing
		Map<Integer, Integer> totalledSales = carMap.entrySet()  
											   .stream()
											   .collect(Collectors.toMap(k -> k.getKey() , v -> v.getValue()
													   											 .stream()
													   											 .collect(Collectors.summingInt(t -> t.getSales())) ));
		//print the result
		totalledSales.forEach((year,totalSales) -> System.out.println(year + " -> " +  totalSales));

		
		//compare the sales and find max and min values
		Optional<Cars> max = carModel.stream().max((Cars car1 ,Cars car2) -> car1.getSales().compareTo(car2.getSales()));
		Optional<Cars> min = carModel.stream().min((Cars car1 ,Cars car2) -> car1.getSales().compareTo(car2.getSales()));
		
		//print the result
		String totalMaxYearPrice = max.map(sales -> "The best month for " + models + " was: " + sales.getYearMonth()).orElse("There is no information.");
		String totalMinYearPrice = min.map(sales -> "The worst month for " + models + " was: " + sales.getYearMonth()).orElse("There is no information.");
		
		System.out.println(totalMaxYearPrice);
		System.out.println(totalMinYearPrice);
		System.out.println(" ");
		
	}

	
}
