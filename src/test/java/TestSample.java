import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		String loginRow = "login";
		String purchaseRow = "purchase";
		String addRow = "add profile";
		String deleteRow = "delete profile";
		String sheet1 = "testData1";

		ArrayList<String> rows = new ArrayList<>();
		rows.add(loginRow);
		rows.add(purchaseRow);
		rows.add(addRow);
		rows.add(deleteRow);

		ArrayList<TestcaseObj> allObj = new ArrayList<>();

		System.out.println("tcObj method:");
		for (String row : rows) {
			allObj.add(tcObj(row, sheet1));
		}

		System.out.println("");

		System.out.println("print obj");
		for (Object obj : allObj) {
			System.out.println(obj);
		}

//		System.out.println(allObj.get(0).toString());

	}

	// attempt to create objects from excel
	
	public static TestcaseObj tcObj(String row, String sheet) throws IOException {
		ArrayList<String> data = DataDriven.getData(row, sheet);
		System.out.println(data);
		String testCaseName = data.get(0).toString();
		String data1 = data.get(1);
		String data2 = data.get(2);
		String data3 = data.get(3);
		TestcaseObj testObj = new TestcaseObj(testCaseName, data1, data2, data3);
		return testObj;
	}
}