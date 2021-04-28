package com.r92ad8.practice.demo.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.regex.Pattern;


public class CodeUtil {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir"));//需要统计行数的文件夹路径
        OutputStream outputStream = new FileOutputStream("代码中的中文统计.xls");
        Workbook workbook = new HSSFWorkbook();
        //调用递归方法统计中文
        traverseFiles(file, workbook);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public static void traverseFiles(File file, Workbook workbook) throws IOException {
        if (!file.exists()) {//文件不存在
            return;
        }
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        if (!file.isDirectory()) {//判断是否为文件
            String fileName = file.getName();
            //判断是否是.java文件
            if (fileName.endsWith(".java")) {
                String[] array = fileName.split(".java");
                String sheetName = array[0];
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    sheet = workbook.createSheet(sheetName);
                }
                Row rowHead = sheet.createRow(0);
                rowHead.createCell(0).setCellValue("代码行");
                rowHead.createCell(1).setCellValue("中文内容");
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String string = null;
                int i = 0;
                int rowIndex = 0;
                while ((string = bufferedReader.readLine()) != null) {
                    i++;//读取行数
                    if (pattern.matcher( string).find()) {
                        System.out.println(fileName + ",第" + i + "行内容包含中文" + string);
                        rowIndex++;
                        Row row = sheet.createRow(rowIndex);
                        row.createCell(0).setCellValue(i);
                        row.createCell(1).setCellValue(string);
                    }

                }
            }
        }

        File[] files = file.listFiles();
        //读取文件夹的子文件或子文件夹
        if (files == null || files.length == 0) {
            return;
        }

        for (File childFile : files) {
            //如果是文件夹递归调用方法遍历文件
            traverseFiles(childFile, workbook);
        }
    }
}
