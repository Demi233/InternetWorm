/**
 * ExcelImportUtil.java 2017年7月20日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * <summary> <description>
 * 
 * @author hqsun
 * @since 2017年7月20日
 * @see [Class/Method]
 *
 */
public class ExcelImportUtil {
	private MultipartHttpServletRequest multipartRequest;

	private Sheet sheet;

	private String fileName = "";

	private String fileType = "";

	private Integer totalCount;

	public ExcelImportUtil(ServletRequest request, String fileNameParm) throws IOException {
		this.multipartRequest = (MultipartHttpServletRequest) request;
		initFile(fileNameParm);
	}

	private void initFile(String fileNameParm) throws IOException {
		MultipartFile commFile = this.multipartRequest.getFile(fileNameParm);
		String fileName = commFile.getOriginalFilename();
		String fileTpe = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
		this.setFileName(fileName);
		this.setFileType(fileTpe);
		try {
			// 判断是否为2007或者2003
			InputStream inputStream = commFile.getInputStream();
			sheet = WorkbookFactory.create(inputStream).getSheetAt(0);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		this.setTotalCount(sheet.getLastRowNum() - 1 < 0 ? 0 : sheet.getLastRowNum());

	}

	public String getCellValue(int rowIndex, int cellIndex) {
		String cellValue = null;
		Row row = sheet.getRow(rowIndex);
		if (null != row) {
			// 数字格式化
			// DecimalFormat df = new DecimalFormat("#");
			Cell cell = row.getCell(cellIndex);

			if (null != cell) {
				// 以下是判断数据的类型
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC: // 数字
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						cellValue = DateUtil.date2TimeStr(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()),
								DateUtil.SHOW_DATE_PATTERN);
					} else {

						try {
							cellValue = String.valueOf(cell.getStringCellValue());
						} catch (IllegalStateException e) {
							cellValue = String.valueOf(cell.getNumericCellValue());
							BigDecimal db = new BigDecimal(cellValue);
							cellValue = db.toPlainString();
						}
					}
					break;

				case HSSFCell.CELL_TYPE_STRING: // 字符串
					cellValue = cell.getStringCellValue();
					break;

				case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
					cellValue = cell.getBooleanCellValue() + "";
					break;

				case HSSFCell.CELL_TYPE_FORMULA: // 公式
					// cellValue = cell.getCellFormula() + "";

					cellValue = cell.getNumericCellValue() + "";
					BigDecimal db = new BigDecimal(cellValue);
					cellValue = db.toPlainString();
					break;

				case HSSFCell.CELL_TYPE_BLANK: // 空值
					cellValue = "";
					break;

				case HSSFCell.CELL_TYPE_ERROR: // 故障
					cellValue = "ERROR";
					break;

				default:
					cellValue = "UNDEFINED";
					break;
				}
			}
		}

		return cellValue;
	}

	/**
	 * 
	 * @Title: checkTitle
	 * @Description: 校验标题
	 *
	 * @param titleNameArray
	 * @return
	 * @return: boolean
	 * @Author: hqsun
	 * @date: 2016年9月26日 上午10:50:58
	 */
	public boolean checkTitle(String[] titleNameArray) {
		int i = 0;
		for (String titleName : titleNameArray) {
			if (StringUtils.isBlank(titleName) || !titleName.equalsIgnoreCase(getCellValue(0, i++))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 取得导入表格列名对应的索引 <功能详细描述>
	 * 
	 * @param titleNameArray
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public List<Integer> getTitleIndex(String[] titleNameArray) {
		List<Integer> list = new ArrayList<Integer>();
		for (String titleName : titleNameArray) {
			for (int i = 0; i < 20; i++) {
				if (StringUtils.isBlank(titleName) || !titleName.equalsIgnoreCase(getCellValue(0, i))) {
				} else {
					list.add(i);
				}
			}

		}
		return list;
	}

	/**
	 * 
	 * @Title: checkFileType
	 * @Description: 校验文件格式
	 *
	 * @param regx
	 * @return
	 * @return: boolean
	 * @Author: hqsun
	 * @date: 2016年9月26日 上午10:16:43
	 */
	public boolean checkFileType(String regx) {
		if (StringUtils.isNoneBlank(regx) && fileType.matches(regx)) {
			return true;
		}
		return false;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
