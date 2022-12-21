package classProgramming;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BIG_AmstrongNumber {
	public static void XSSF() throws IOException {

	}

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet 1");
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Storage\\Excel.xlsx");
		int countA = 0;
		List<Long> map = new ArrayList<Long>();
		for (long i = 1; i <= 999999999999999999L; i++) {
			long a = i, count = 0, store = 1, s = 1, fin = 0, S = 0, c = 0, e = 0;
			store = a;
			while (store != 0) {
				store /= 10;
				count++;
			}
			s = a;

			while (s != 0) {
				c = count;
				e = s % 10;
				S = e;
				while (c != 1) {
					S = S * e;
					c--;
				}
				fin = fin + S;
				s /= 10;
			}
			if (i == fin && i > 10) {
				countA++;
				System.out.println("Amstrong number = " + countA + " = " + i);
				map.add(i);
				if (countA == 500) {
					break;
				}

			}
		}
		System.out.println(map.size());

		for (int i = 0; i < map.size(); i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j <= 0; j++) {
				row.createCell(j).setCellValue("Amstrong number");
				row.createCell(j + 1).setCellValue(i);
				row.createCell(j + 2).setCellValue(map.get(i));
			}
		}
		wb.write(file);
		file.close();
		System.out.println("Data Written Sucessful");

	}

}
