package ee.knowituniversity.data;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;



public class Student implements Comparable<Student>{

    protected BigInteger studentCode;
    protected String name;
    protected String lastName;

    private double avg;
    private int courses;
    private int total;
    
    private NumberFormat format = new DecimalFormat("#0.00");

    Student(ee.knowituniversity.generated.Student s) {
        this.studentCode = s.getStudentCode();
        this.name = s.getName();
        this.lastName = s.getLastName();
    }

    /**
     * Gets the value of the studentCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStudentCode() {
        return studentCode;
    }

    /**
     * Sets the value of the studentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStudentCode(BigInteger value) {
        this.studentCode = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    public double getAvg() {
        updateAvg();
        return avg;
}

    public void updateAvg() {
        this.avg = courses != 0 ? ((double) total / (double) courses) : 0;
    }
    

    public int getCourses() {
        return courses;
    }

    public int getTotal() {
        return total;
    }

    public void addCourses(int courses) {
        this.courses += courses;
        updateAvg();
    }
    
    public void addGrade(int grade){
        total += grade;
        updateAvg();
    }
    
    @Override
    public int compareTo(Student student) {
        if (getAvg() == student.getAvg()) {
            return (lastName + name ).compareTo(student.lastName +  student.name);
        } else return Double.compare(avg, student.avg);
    }

    public String getAvgAsString() {
        return format.format(getAvg());
    }
}
