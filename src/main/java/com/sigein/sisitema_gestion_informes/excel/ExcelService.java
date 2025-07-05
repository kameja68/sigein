package com.sigein.sisitema_gestion_informes.excel;

import com.sigein.sisitema_gestion_informes.cdp.Cdp;
import com.sigein.sisitema_gestion_informes.contratista.model.Contratista;
import com.sigein.sisitema_gestion_informes.contrato.model.Contrato;
import com.sigein.sisitema_gestion_informes.crp.model.Crp;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

    public byte[] generarExcel(Contratista contratista, Contrato contrato, Crp crp) throws IOException {
        // Carga el archivo original desde recursos
        File file = new ClassPathResource("FTO CERTIFICADO DE SUPERVISION  (nuevo dic) (1).xlsm").getFile();
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Asume que es la primera hoja

        // Ejemplo: insertar datos en celdas específicas
        sheet.getRow(7).getCell(8).setCellValue(contratista.getNombre1()); /*ok*/      // A6 (fila 5, celda 1)
        sheet.getRow(7).getCell(21).setCellValue(contratista.getIdentificacion()); /*ok*/      // A7
        sheet.getRow(19).getCell(14).setCellValue(contrato.getNumeroPagos());          // A8
        sheet.getRow(11).getCell(6).setCellValue(contrato.getObjeto());          // A9
        sheet.getRow(5).getCell(34).setCellValue(contrato.getFechaInicio());     // A10
        sheet.getRow(9).getCell(1).setCellValue(contrato.getFechaFin());       // A11
        sheet.getRow(51).getCell(25).setCellValue(crp.getCodigoCrp());              // A12
        sheet.getRow(51).getCell(29).setCellValue(crp.getValorCrp());               // A13
        sheet.getRow(51).getCell(34).setCellValue(crp.getFechaCrp());
        // Guardar en memoria como array de bytes
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        workbook.close();
        fis.close();
        return bos.toByteArray();
    }
}
