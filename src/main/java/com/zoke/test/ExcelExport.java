package com.zoke.test;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

public class ExcelExport {

    public static void main(String[] args){

    }

    public String exportExcel() throws IOException {

        // 在内存中创建Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 创建工作簿
        HSSFSheet sheet = hssfWorkbook.createSheet("区域数据");
        // 创建第1行,即表头
        HSSFRow titleRow = sheet.createRow(0);
        // 创建列
        titleRow.createCell(0).setCellValue("省");
        titleRow.createCell(1).setCellValue("市");
        titleRow.createCell(2).setCellValue("区");
        titleRow.createCell(3).setCellValue("邮编");
        titleRow.createCell(4).setCellValue("简码");
        titleRow.createCell(5).setCellValue("城市编码");

        // 查询所有分区
        List<Area> list = areaService.findAll();

        // 遍历从数据库查找出来的所有分区的集合
        for (Area area : list) {
            // 创建数据行
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            //向数据行里面写入数据
            dataRow.createCell(0).setCellValue(area.getProvince());
            dataRow.createCell(1).setCellValue(area.getCity());
            dataRow.createCell(2).setCellValue(area.getDistrict());
            dataRow.createCell(3).setCellValue(area.getPostcode());
            dataRow.createCell(4).setCellValue(area.getShortcode());
            dataRow.createCell(5).setCellValue(area.getCitycode());
        }
        // 获取响应对象
        HttpServletResponse response = ServletActionContext.getResponse();
        // 获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 定义文件名
        String fileName = "区域数据.xls";
        // 从请求头中获取客户端类型

        String agent = ServletActionContext.getRequest().getHeader("User-Agent");
        // 使用FileUtils工具类根据浏览器类型对文件名进行重新编码,避免乱码
        fileName = FileUtils.encodeDownloadFilename(fileName, agent);
        // 指定以附件的形式处理文件
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        // 指定文件的MIME类型(也就是指定文件的格式)
        response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));
        // 写出文件
        hssfWorkbook.write(outputStream);
        // 释放资源
        hssfWorkbook.close();
        return null;
    }

}
