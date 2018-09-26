# LeerExcel
 public void modificarFallida(){
            
           
       try {
            FileInputStream file = new FileInputStream(new File("bitacora.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow filla = sheet.getRow(fila);
            if(filla == null){
                filla = sheet.createRow(fila);
            }
            XSSFCell celda = filla.createCell(3);
            if(celda == null){
                celda = filla.createCell(3);
            }
            celda.setCellValue("Fallida");
            file.close();
            FileOutputStream output = new FileOutputStream("bitacora.xlsx");
            output.close();
            
            
            
       } catch (IOException ex) {
           Logger.getLogger(CrearExcel.class.getName()).log(Level.SEVERE, null, ex);
       }
            
            
    }
