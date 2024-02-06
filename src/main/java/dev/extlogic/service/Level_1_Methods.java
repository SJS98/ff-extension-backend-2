package dev.extlogic.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Level_1_Methods {

    /**
     * @param sheet           current sheet which is getting converted into automation
     * @param descColumnIndex column index of the description in the given sheet
     * @param descRowIndex    row index of the description in the given sheet
     * @return description given in the manual test case
     */

    public String getDescription(Sheet sheet, int descColumnIndex, int descRowIndex) {
        Row row = sheet.getRow(descRowIndex);
        Cell cell = row.getCell(descColumnIndex);
        return cell.toString();
    }

    /**
     * @param sheet     current sheet which is getting converted into automation
     * @param stepIndex current step which is getting converted into automation
     * @return
     */
    public String getDescription(Sheet sheet, int stepIndex) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                boolean isDesc = cell.toString().toLowerCase().contains("description");
                if (cell.getCellType() != CellType.BLANK && isDesc) {
                    int colIndex = cell.getColumnIndex();
                    int rowIndex = row.getRowNum();
                    return sheet.getRow(rowIndex + stepIndex).getCell(colIndex).toString();
                }
            }
        }
        return null;
    }

    public String getStep(Sheet sheet, int stepIndex) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                boolean isDesc = cell.toString().toLowerCase().contains("step");
                if (cell.getCellType() != CellType.BLANK && isDesc) {
                    int colIndex = cell.getColumnIndex();
                    int rowIndex = row.getRowNum();
                    return sheet.getRow(rowIndex + stepIndex).getCell(colIndex).toString();
                }
            }
        }
        return null;
    }

    public String getData(Sheet sheet, int stepIndex) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                boolean isDesc = cell.toString().toLowerCase().contains("data");
                if (cell.getCellType() != CellType.BLANK && isDesc) {
                    int colIndex = cell.getColumnIndex();
                    int rowIndex = row.getRowNum();
                    return sheet.getRow(rowIndex + stepIndex).getCell(colIndex).toString();
                }
            }
        }
        return null;
    }
}