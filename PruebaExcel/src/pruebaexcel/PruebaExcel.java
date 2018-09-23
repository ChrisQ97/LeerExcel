/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author chr97
 */
public class PruebaExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //crearExcel();
     // modificar();
    }
    public static void crearExcel(){ 
        XSSFWorkbook book = new XSSFWorkbook();
        Sheet hoja = book.createSheet("BITACORA");
       
        
        Row row = hoja.createRow(0);
        row.createCell(0).setCellValue("BITACORA");
        Row rowUno = hoja.createRow(1);
        rowUno.createCell(0).setCellValue("Datos");
        
        
        
        
        
        
        
        
        try {
            FileOutputStream fileout = new FileOutputStream("bitacora.xlsx");
            book.write(fileout);
            fileout.close();
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PruebaExcel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("clausula 1");
        } catch (IOException ex) {
            System.out.println("clausula 2");
            Logger.getLogger(PruebaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void leer(){
       
    }
    public static void modificarFinal(String Hora, String Tabla, String Estado){
        
        try {
            FileInputStream file = new FileInputStream(new File("bitacora.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            int filas = sheet.getLastRowNum(); //este es el numero de la transaccion
            System.out.println(filas);
            
            
                 Row row = sheet.createRow(filas+1);
                 
                row.createCell(0).setCellValue((filas+1));//numero de la transaccion
                row.createCell(1).setCellValue(Hora);//hora transaccion
                row.createCell(2).setCellValue(Tabla);//tabla afectada
                row.createCell(3).setCellValue(Estado);//estado de la tabla
                
         
            file.close();
            FileOutputStream output = new FileOutputStream("bitacora.xlsx");
            wb.write(output);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PruebaExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PruebaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
