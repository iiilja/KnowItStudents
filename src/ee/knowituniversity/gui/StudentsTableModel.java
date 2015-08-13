package ee.knowituniversity.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import ee.knowituniversity.data.Student;
import java.util.Collections;

public class StudentsTableModel extends AbstractTableModel{
    private List<Student> students;

    public StudentsTableModel(List<Student> students) {
        this.students = students;
        if (students != null) {
            Collections.sort(students);
        }
    }
    
    

    @Override
    public int getRowCount() {
        return students != null ? students.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student opilane = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return opilane.getStudentCode();
            case 1:
                return opilane.getName();
            case 2:
                return opilane.getLastName();
            case 3:
                return opilane.getAvgAsString();
        }
        return "";
    }
    
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Eesnimi";
            case 2:
                return "Perenimi";
            case 3:
                return "KHK";
        }
        return "";
    }
    
    public void updateAll(List<Student> opilased){
        this.students = opilased;
        fireTableDataChanged();
    }

    @Override
    public void fireTableDataChanged() {
        if (students != null) {
            Collections.sort(students);
        }
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    void add(Student opilane) {
        students.add(opilane);
        fireTableDataChanged();
    }

    Student get(int selectedRow) {
        try {
            return students.get(selectedRow);
        } catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    void remove(Student opilane) {
        students.remove(opilane);
        fireTableDataChanged();
    }
    
}
