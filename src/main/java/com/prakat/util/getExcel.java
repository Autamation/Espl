package com.prakat.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import java.util.Iterator;
public class getExcel {
	static Logger logger = Logger.getLogger(getExcel.class.getName());

	/*public static void main(String args[]) throws IOException{
		//getExcel.getExcel();
		
	}*/
	/*public static void getExcel ()throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");
         
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
                {"Thinking in bhsbdhbshd", "dsd Eckel", 376},
                {"dnmsnd in bab", "dshjdhs dbsd", 96},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         
        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) {
            workbook.write(outputStream);
        }
		
    }
	*/
	  
        public static void main(String[] args) throws Exception{ 
        	getExcel e = new getExcel();
        	//e.createPieChart();
        	//e.displayChart();
        	fileExist();
        	
        }
        
                /* Read the bar chart data from the excel file */
        public void createBarChart() throws IOException{
        	File f = new File("C:\\Users\\Prakat-L033\\Downloads\\tenon_api_2017-10-25_05_58_33.xls");
                FileInputStream chart_file_input = new FileInputStream(f);
                /* HSSFWorkbook object reads the full Excel document. We will manipulate this object and
                write it back to the disk with the chart */
                XSSFWorkbook  my_workbook = new XSSFWorkbook(chart_file_input);
                /* Read chart data worksheet */
                XSSFSheet my_sheet = my_workbook.getSheetAt(0);
                /* Create Dataset that will take the chart data */
                DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
                /* We have to load bar chart data now */
                /* Begin by iterating over the worksheet*/
                /* Create an Iterator object */
                Iterator<Row> rowIterator = my_sheet.iterator(); 
                /* Loop through worksheet data and populate bar chart dataset */
                String chart_label="a";
                Number chart_data=0;            
                while(rowIterator.hasNext()) {
                        //Read Rows from Excel document
                        Row row = rowIterator.next();  
                        //Read cells in Rows and get chart data
                        Iterator<Cell> cellIterator = row.cellIterator();
                                while(cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next(); 
                                        logger.debug("cell type---"+cell.getCellType());
                                        switch(cell.getCellType()) { 
                                        case Cell.CELL_TYPE_NUMERIC:
                                                chart_data=cell.getNumericCellValue();
                                                logger.debug("chart_data---"+chart_data);
                                                break;
                                        case Cell.CELL_TYPE_STRING:
                                                chart_label=cell.getStringCellValue();
                                                break;
                                        }
                                }
                /* Add data to the data set */          
                /* We don't have grouping in the bar chart, so we put them in fixed group */            
                my_bar_chart_dataset.addValue(chart_data.doubleValue(),"Marks",chart_label);
                }               
                /* Create a logical chart object with the chart data collected */
                JFreeChart BarChartObject=ChartFactory.createBarChart("Subject Vs Marks","Subject","Marks",my_bar_chart_dataset,PlotOrientation.VERTICAL,true,true,false);  
                /* Dimensions of the bar chart */               
                int width=640; /* Width of the chart */
                int height=480; /* Height of the chart */               
                /* We don't want to create an intermediate file. So, we create a byte array output stream 
                and byte array input stream
                And we pass the chart data directly to input stream through this */             
                /* Write chart as PNG to Output Stream */
                ByteArrayOutputStream chart_out = new ByteArrayOutputStream();          
                ChartUtilities.writeChartAsPNG(chart_out,BarChartObject,width,height);
                /* We can now read the byte data from output stream and stamp the chart to Excel worksheet */
                int my_picture_id = my_workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
                /* we close the output stream as we don't need this anymore */
                chart_out.close();
                /* Create the drawing container */
                XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
                /* Create an anchor point */
                ClientAnchor my_anchor = new XSSFClientAnchor();
                /* Define top left corner, and we can resize picture suitable from there */
                my_anchor.setCol1(4);
                my_anchor.setRow1(5);
                /* Invoke createPicture and pass the anchor point and ID */
                XSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
                /* Call resize method, which resizes the image */
                my_picture.resize();
                /* Close the FileInputStream */
                chart_file_input.close();               
                /* Write changes to the workbook */
            	File f2 = new File("C:\\Users\\Prakat-L033\\Downloads\\barChart.xls");

                FileOutputStream out = new FileOutputStream(f2);
                my_workbook.write(out);
                out.close();            
        }

        public void createPieChart() throws IOException{
        	
            FileInputStream chart_file_input = new FileInputStream(new File("C:\\Users\\Prakat-L033\\Downloads\\tenon_api_2017-10-25.xls"));
            /* Read chart data from XLSX Workbook */
            XSSFWorkbook my_workbook = new XSSFWorkbook(chart_file_input);
            /* Read worksheet that has pie chart input data information */
            XSSFSheet my_sheet = my_workbook.getSheetAt(0);
            /* Create JFreeChart object that will hold the Pie Chart Data */
            DefaultPieDataset my_pie_chart_data = new DefaultPieDataset();
            /* We have to get the input data into DefaultPieDataset object */
            /* So, we iterate over the rows and cells */
            /* Create an Iterator object */
            Iterator<Row> rowIterator = my_sheet.iterator(); 
            /* Loop through worksheet data and populate Pie Chart Dataset */
            String chart_label="a";
            Number chart_data=0;            
            while(rowIterator.hasNext()) {
                    //Read Rows from Excel document
                    Row row = rowIterator.next();  
                    //Read cells in Rows and get chart data
                    Iterator<Cell> cellIterator = row.cellIterator();
                            while(cellIterator.hasNext()) {
                                    Cell cell = cellIterator.next(); 
                                    switch(cell.getCellType()) { 
                                    case Cell.CELL_TYPE_NUMERIC:
                                            chart_data=cell.getNumericCellValue();
                                            break;
                                    case Cell.CELL_TYPE_STRING:
                                            chart_label=cell.getStringCellValue();
                                            break;
                                    }
                            }
            /* Add data to the data set */          
            my_pie_chart_data.setValue(chart_label,chart_data);
            }               
            /* Create a logical chart object with the chart data collected */
            JFreeChart myPieChart = ChartFactory.createPieChart("Excel Pie Chart Java Example",my_pie_chart_data,true,true,false);
            /* Specify the height and width of the Pie Chart */
            int width = 640; /* Width of the chart */
            int height=480; /* Height of the chart */
            float quality=1; /* Quality factor */
            /* We don't want to create an intermediate file. So, we create a byte array output stream 
            and byte array input stream
            And we pass the chart data directly to input stream through this */             
            /* Write chart as JPG to Output Stream */
            ByteArrayOutputStream chart_out = new ByteArrayOutputStream();          
            ChartUtilities.writeChartAsJPEG(chart_out,quality,myPieChart,width,height);
            /* We now read from the output stream and frame the input chart data */
            /* We don't need InputStream, as it is required only to convert the output chart to byte array */
            /* We can directly use toByteArray() method to get the data in bytes */
            /* Add picture to workbook */
            int my_picture_id = my_workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);                
            /* Close the output stream */
            chart_out.close();
            /* Create the drawing container */
            XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
            /* Create an anchor point */
            ClientAnchor my_anchor = new XSSFClientAnchor();
            /* Define top left corner, and we can resize picture suitable from there */
            my_anchor.setCol1(14);
            my_anchor.setRow1(378000);
            /* Invoke createPicture and pass the anchor point and ID */
            XSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
            /* Call resize method, which resizes the image */
            my_picture.resize();
            /* Close the FileInputStream */
            chart_file_input.close();               
            /* Write Pie Chart back to the XLSX file */
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Prakat-L033\\Downloads\\tenon_api_chart.xlsx"));
            my_workbook.write(out);
            out.close();            
    }
        
        
        public void displayChart() throws IOException{
        	
        	

            FileInputStream chart_file_input = new FileInputStream(new File("C:\\Users\\Prakat-L033\\Downloads\\tenon_api_2017-10-25.xls"));
            /* Read chart data from XLSX Workbook */
            XSSFWorkbook my_workbook = new XSSFWorkbook(chart_file_input);
            /* Read worksheet that has pie chart input data information */
            XSSFSheet my_sheet = my_workbook.getSheetAt(0);
            /* Create JFreeChart object that will hold the Pie Chart Data */
     //       DefaultPieDataset my_pie_chart_data = new DefaultPieDataset();
            
            
            
       	 DefaultPieDataset dataset = new DefaultPieDataset( );             
         dataset.setValue( "Total no of success criterion" , new Double( 74 ) );             
         dataset.setValue( "No of failed Criteria" , new Double( 9 ) );             
         dataset.setValue( "No of passed Criterion" , new Double( 65 ) );             

         JFreeChart myPieChart = ChartFactory.createPieChart3D( 
            "Report details" ,  // chart title                   
            dataset ,         // data 
            true ,            // include legend                   
            true, 
            false);
           
            int width = 640; /* Width of the chart */
            int height=480; /* Height of the chart */
            float quality=1; /* Quality factor */
            final PiePlot3D plot = ( PiePlot3D ) myPieChart.getPlot( );             
            plot.setStartAngle( 270 );             
            plot.setForegroundAlpha( 0.60f );             
            plot.setInteriorGap( 0.02 );             
                                    

           // writeBufferedImageAsJPEG(out, pieChart3D);
            ByteArrayOutputStream chart_out = new ByteArrayOutputStream();          
            ChartUtilities.writeChartAsJPEG(chart_out,quality,myPieChart,width,height);
          
            int my_picture_id = my_workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);                
            /* Close the output stream */
            chart_out.close();
            /* Create the drawing container */
            XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
            /* Create an anchor point */
            ClientAnchor my_anchor = new XSSFClientAnchor();
            /* Define top left corner, and we can resize picture suitable from there */
            my_anchor.setCol1(14);
            my_anchor.setRow1(378000);
            /* Invoke createPicture and pass the anchor point and ID */
            XSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
            /* Call resize method, which resizes the image */
            my_picture.resize();
            /* Close the FileInputStream */
            chart_file_input.close();               
            /* Write Pie Chart back to the XLSX file */
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Prakat-L033\\Downloads\\tenongy_chart.xlsx"));
            my_workbook.write(out);
            out.close(); 

          }
        
	public static void fileExist() throws IOException {

		String imageFile = ("myPieChart.png");
		FileOutputStream excelFile = new FileOutputStream(new File(imageFile));
		excelFile.write("ggjg".toString().getBytes());
		FileDescriptor s = excelFile.getFD();
		System.out.println(s);
		
		 
        File dir = new File("WebContent/data"+File.separator+"myPieChart.png");
        dir.getParentFile().mkdirs(); 

        dir.createNewFile();
        System.out.println(dir.getAbsolutePath()); //check the path with System.out
      //  File imageFile1 = File.createTempFile("myPieChart", ".png",dir); 

      //  File subjectFile = File.createTempFile("subjects", ".json",dir); 
//System.out.println(imageFile1.getAbsolutePath());
        
	}
}


