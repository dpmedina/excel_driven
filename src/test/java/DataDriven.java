import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	// identify correct column (test cases)
	// scan column to find correct row (purchase)
	// pull all data from that row

	@SuppressWarnings("resource")
	public static ArrayList<String> getData(String testCaseName, String sheetName) throws IOException {

		// poi

		// set variables for sheet
		String colHeader1 = "testcases";
		String colHeader2 = "data1";
		String colHeader3 = "data2";

		// set array for results
		ArrayList<String> arrLst = new ArrayList<>();

		// set location of excel workbook
		String project = System.getProperty("user.dir");
		String excel = project + "//src//test//resources//ExcelData.xlsx";
		FileInputStream fis = new FileInputStream(excel);

		// accepts fileInputStream argument
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// find number of sheets
		int totalSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < totalSheets; i++) {
			// find correct sheet
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				// assign sheet
				XSSFSheet sheet = workbook.getSheetAt(i);
				// identify correct column (test cases)
				Iterator<Row> rows = sheet.iterator();// sheet is collection of all rows
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();// row is collection of all cells
				// int to store column index
				int colIndex = 0;
				int col = 0;
				while (cell.hasNext()) {
					Cell cellValue = cell.next();
					// find desired column
					if (cellValue.getStringCellValue().equalsIgnoreCase(colHeader1)) {
						col = colIndex;
					}
					colIndex++;
				}
				// scan column to find correct row (purchase)

				// use previous (rows)
				while (rows.hasNext()) {
					Row row = rows.next();
					// look only in first (selected) column (col) index
					if (row.getCell(col).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// pull all data from that row
						Iterator<Cell> rowCells = row.cellIterator();
						while (rowCells.hasNext()) {
							Cell c = rowCells.next();
							// check cell type (string/int)
							if (c.getCellType() == CellType.STRING) {
								arrLst.add(c.getStringCellValue());
							} else {
								// convert int to text
								String numStr = NumberToTextConverter.toText(c.getNumericCellValue());
								arrLst.add(numStr);
							}

//							String cellValue = rowCells.next().getStringCellValue();
//							arrLst.add(cellValue);
						}
					}
				}
			}
		}
		return arrLst;
	}

}
