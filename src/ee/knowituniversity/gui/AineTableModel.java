package ee.knowituniversity.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import ee.knowituniversity.data.Course;

class AineTableModel extends AbstractTableModel{
    private final List<Course> ained;

    public AineTableModel(List<Course> ained) {
        this.ained = ained;
    }

    @Override
    public int getRowCount() {
        return ained.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course aine = ained.get(rowIndex);
        switch(columnIndex){
            case 0:
                return aine.getIdCourse();
            case 1:
                return aine.getCourseCode();
            case 2:
                return aine.getName();
            case 3:
                return aine.getLecturer();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Id";
            case 1:
                return "Kood";
            case 2:
                return "Nimi";
            case 3:
                return "Oppejoud";
        }
        return super.getColumnName(column);
    }
    
    

    void add(Course aine) {
        ained.add(aine);
        fireTableDataChanged();
    }

    Course get(int selectedRow) {
        try {
            return ained.get(selectedRow);
        } catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    void remove(Course aine) {
//        ained.remove(aine);
        fireTableDataChanged();
    }
    
}
