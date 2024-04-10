package yurp.model;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;


public class Excel {

	public Excel(HttpServletResponse response,ProductDTO dto) {
		
		System.out.println(dto);
		  try {
			Workbook wb = new XSSFWorkbook();
	        Sheet sheet = wb.createSheet("발주");
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;

	        // Header
	        row = sheet.createRow(rowNum++);
	        cell = row.createCell(0);
	        cell.setCellValue("no");
	        cell = row.createCell(1);
	        cell.setCellValue("브랜드");
	        cell = row.createCell(2);
	        cell.setCellValue("품번");
	        cell = row.createCell(3);
	        cell.setCellValue("컬러");
	        cell = row.createCell(4);
	        cell.setCellValue("사이즈");
	        cell = row.createCell(5);
	        cell.setCellValue("가격");
	        cell = row.createCell(6);
	        cell.setCellValue("제품명");
	        cell = row.createCell(7);
	        cell.setCellValue("요청수량");
	        

	        // Body
	        for (int i=0; i<3; i++) {
	            row = sheet.createRow(rowNum++);
	            cell = row.createCell(0);
	            cell.setCellValue(i);
	            cell = row.createCell(1);
	            cell.setCellValue(i+"_name");
	            cell = row.createCell(2);
	            cell.setCellValue(i+"_title");
	        }

	        // 컨텐츠 타입과 파일명 지정
	        response.setContentType("ms-vnd/excel");
	        response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        // Excel File Output
	      
				wb.write(response.getOutputStream());
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	    
	}
	
}
