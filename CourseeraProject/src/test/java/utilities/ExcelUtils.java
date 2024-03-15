package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style; 
	public static XSSFFont font;
	
	public static void writeToExcel(String xlfile,String xlsheet,int rownum,List<String>arr)throws IOException
	{	
		fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\"+xlfile+".xlsx");
		wb=new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(xlsheet)==-1)
			ws=wb.createSheet(xlsheet);
		else
			ws=wb.getSheet(xlsheet);

		row=ws.createRow(rownum);
		
		int colnum=0;
		for(String s:arr) {
			cell=row.createCell(colnum);
			cell.setCellValue(s);
			colnum++;
		}
		int count=ws.getLastRowNum();
		for(int i=0;i<count;i++)
			ws.autoSizeColumn(i);
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
				
	}
	
	public static void setStyle(int rownum,int colnum) throws IOException
	{
		
		
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		
		
		style=wb.createCellStyle();
		font = wb.createFont();
		font.setColor(HSSFColorPredefined.WHITE.getIndex());
        
		style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		style.setFont(font);
		
		cell.setCellStyle(style);		
		
	}

	public static void writeToExcel(String string, String xlsheet, List<String> arr) {
		try {
			fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		
		wb=new XSSFWorkbook(fi);
		if(wb.getSheetIndex(xlsheet)==-1)
			ws=wb.createSheet(xlsheet);
		else
			ws=wb.getSheet(xlsheet);
		//setStyle(0,0);
		int colnum=0;
		int r=1;
		for(String s:arr) {
			row=ws.createRow(r);
			cell=row.createCell(colnum);
			cell.setCellValue(s);
			r++;
		}
		for(int i=0;i<r;i++)
			ws.autoSizeColumn(i);
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
		} catch (Exception e) {}
			
	}
	
	
	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
			
			List<HashMap<String, String>> mydata = new ArrayList<>();
			
			try {
				 fi = new FileInputStream(filepath);
				 wb = new XSSFWorkbook(fi);
				XSSFSheet sheet = wb.getSheet(sheetName);
				Row HeaderRow = sheet.getRow(0);
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
					{
					Row currentRow = sheet.getRow(i);
					HashMap<String, String> currentHash = new HashMap<String, String>();
					for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) 
						{
						Cell currentCell = currentRow.getCell(j);
						switch (currentCell.getCellType()) 
							{
								case STRING:
									currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
									break;
								default:
									break;		
								
							}
						}
					mydata.add(currentHash);
					}
				fi.close();
				} catch (Exception e) {
				e.printStackTrace();
			}
			return mydata;
		}


}
