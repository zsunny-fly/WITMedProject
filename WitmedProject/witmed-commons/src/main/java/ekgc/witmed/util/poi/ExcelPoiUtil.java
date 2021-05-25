package ekgc.witmed.util.poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *  使用 POI 读写 Excel 文件内容
 */
public class ExcelPoiUtil {
		/*
			POI 提供 HSSF，XSSF，SXSSF三种方式操作 Excel
			HSSF -- 扩展名 xls 一个sheet最大行数65535，最大列数256
				HSSFWorkbook、HSSFSheet、HSSFRow、HSSFCell
			XSSF -- 扩展名 xlsx  一个sheet最大行数1048576，最大列数16384
				XSSFWorkbook、XSSFSheet、XSSFRow、XSSFCell
			SXSSF -- 扩展名 xlsx, 在 XSSF 基础上，POI3.8版本开始提供支持低内存占用
				SXSSFWorkbook、Sheet、Row、Cell
		 */

	// 读 Excel 文件
	public boolean readFromExcel(String fileName) {
		try {
			// 加载指定文件，并创建一个 Excel 工作簿对象
			XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(fileName));
			// 读取Excel文件中第一个sheet标签页
			XSSFSheet sheet = excel.getSheetAt(0);
			// 遍历sheet标签，获得每一行数据。
			// 方法一：foreach 循环
//			for(Row row: sheet) {
//				// 遍历行，获得每个单元格对象
//				for(Cell cell: row){
//					System.out.println(cell.getStringCellValue());
//				}
//			}
			// 方法二：使用普通for循环，利用 行，列 的下标
			for(int i = 0; i < sheet.getLastRowNum(); i++) {
				// 根据行号，获取行数据
				XSSFRow row = sheet.getRow(i);
				// 获取当前行的最后一个单元格,遍历
				for(int j = 0; j < row.getLastCellNum(); j++) {
					// 根据列数，获取当前单元格
					XSSFCell cell = row.getCell(j);
					// 根据单元格的类型输出
					// 字符类型
					System.out.println(cell.getStringCellValue());
//					// 数字类型
//					System.out.println(cell.getNumericCellValue());
//					// 日期类型
//					System.out.println(cell.getDateCellValue());
				}
			}
			return true;
		}catch (Exception e){
			e.printStackTrace();
			// 若抛出异常，则读文件失败
			return false;
		}
	}

	// 写 Excel
	public boolean writeToExcel(String destName) {
		// 在内存中创建一个Excel工作簿对象
		XSSFWorkbook excel = new XSSFWorkbook();
		// 创建一个sheet对象，名字叫 tempsheet
		XSSFSheet  sheet = excel.createSheet("tempsheet");
		// 在sheet中创建行对象
		XSSFRow row01 = sheet.createRow(0);
		// 在行中创建单元格对象，并添加数据
		row01.createCell(0).setCellValue("姓名");
		row01.createCell(1).setCellValue("地址");
		row01.createCell(2).setCellValue("年龄");
		// 创建第三行
		XSSFRow row03 = sheet.createRow(2);
		row03.createCell(0).setCellValue("xiaoming");
//		row03.createCell(1).setCellValue("北京");
		row03.createCell(2).setCellValue("18");

		try {
			// 创建输出流对象，通过输出流将内存中的Excel文件写入到磁盘
			FileOutputStream out = new FileOutputStream(destName);
			// Excel工作簿对象写出到输出流
			excel.write(out);
			// 将out流中的数据写入磁盘
			out.flush();
			excel.close();
			return true;
		}catch (Exception e ) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		ExcelPoiUtil excelPoiUtil = new ExcelPoiUtil();
		System.out.println(excelPoiUtil.readFromExcel("f:\\poi-source.xlsx"));
		System.out.println(excelPoiUtil.writeToExcel("f:\\poi-dest.xlsx"));
	}
}
