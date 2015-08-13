package ee.knowituniversity.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import ee.knowituniversity.data.Grade;

public class GradeTableModel extends AbstractTableModel{

    private List<Grade> grades;

    public GradeTableModel(List<Grade> hinded) {
        this.grades = hinded;
    }

    @Override
    public int getRowCount() {
        return grades.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grade grade = grades.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return grade.getIdGrade();
            case 1:
                return grade.getIdCourse();
            case 2:
                return grade.getStudentCode();
            case 3:
                return grade.getGradeValue();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Aine Id";
            case 2:
                return "Tudengi Kood";
            case 3:
                return "Hinne";
        }
        return "";
    }
    
    

    void add(Grade grade) {
        grades.add(grade);
        fireTableDataChanged();
    }

    Grade get(int selectedRow) {
        try {
            return grades.get(selectedRow);
        } catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    void remove(Grade hinne) {
        grades.remove(hinne);
        fireTableDataChanged();
    }
}
