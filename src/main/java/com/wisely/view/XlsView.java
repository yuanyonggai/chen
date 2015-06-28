package com.wisely.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.wisely.domain.DemoObj;

public class XlsView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DemoObj demoObj = (DemoObj) model.get("demoObj");

		Sheet sheet = workbook.createSheet("sheet1");
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		Row row = null;
		Cell cell = null;
		int rowCount = 0;
		int colCount = 0;

		// 创建头部
		row = sheet.createRow(rowCount++);

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("ID");

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("NAME");

		// 创建数据
		row = sheet.createRow(rowCount++);
		colCount = 0;
		row.createCell(colCount++).setCellValue(demoObj.getId());
		row.createCell(colCount++).setCellValue(demoObj.getName());
		for (int i = 0; i < 3; i++)
			sheet.autoSizeColumn(i, true);

	}

}