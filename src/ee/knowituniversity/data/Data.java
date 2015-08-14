package ee.knowituniversity.data;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coursesList",
    "gradesList",
    "studentsList"
})
@XmlRootElement(name = "allData")
public class Data {

    protected List<Course> coursesList;
    protected List<Grade> gradesList;
    protected List<Student> studentsList;
    
    @XmlTransient
    private Double average; 
    
    public Data(){
        
    }

    public Data(ee.knowituniversity.generated.AllData data) {
        coursesList = new ArrayList<Course>();
        gradesList = new ArrayList<Grade>();
        studentsList = new ArrayList<Student>();
        transformCoursesList(data.getCoursesList());
        transformGradesList(data.getGradesList());
        transformStudentsList(data.getStudentsList());
    }
    
    public List<Course> getCoursesList() {
        if (coursesList == null) {
            coursesList = new ArrayList<Course>();
        }
        return this.coursesList;
    }

    public List<Grade> getGradesList() {
        if (gradesList == null) {
            gradesList = new ArrayList<Grade>();
        }
        return this.gradesList;
    }

    public List<Student> getStudentsList() {
        if (studentsList == null) {
            studentsList = new ArrayList<Student>();
        }
        return this.studentsList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public void setGradesList(List<Grade> gradesList) {
        this.gradesList = gradesList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
    
    private void transformCoursesList(List<ee.knowituniversity.generated.Course> coursesList) {
        for (ee.knowituniversity.generated.Course course : coursesList) {
            this.coursesList.add(new Course(course));
        }
    }

    private void transformGradesList(List<ee.knowituniversity.generated.Grade> gradesList) {
        for (ee.knowituniversity.generated.Grade grade : gradesList) {
            this.gradesList.add(new Grade(grade));
        }
    }

    private void transformStudentsList(List<ee.knowituniversity.generated.Student> studentsList) {
        for (ee.knowituniversity.generated.Student studentsList1 : studentsList) {
            this.studentsList.add(new Student(studentsList1));
        }
    }
    
    public void generateAverageGrade(){
        int coursesInt = 0;
        int gradeInt = 0;
        if (average == null) {
            for (Grade grade : gradesList) {
                Student student = findStudentByStudentCode(grade.getStudentCode());
                if (student != null) {
                    student.addGrade(grade.getGradeValue());
                    student.addCourses(1);
                    coursesInt ++;
                    gradeInt += grade.getGradeValue();
                } else {
                    // DO nothing with this grade
                }
            }
        } else {
            for (Student student : studentsList) {
                coursesInt += student.getCourses();
                gradeInt += student.getTotal();
            }
        }
        average = coursesInt != 0 ? ((double) gradeInt / (double) coursesInt) : 0;
    }

    public Double getAverage() {
        return average;
    }
    
    private Student findStudentByStudentCode(BigInteger studentCode){
        if (studentCode == null) {
            return null;
        }
        for (Student student : studentsList) {
            if (student.getStudentCode().equals(studentCode)) {
                return student;
            }
        }
        return null;
   }

}
