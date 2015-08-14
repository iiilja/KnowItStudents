package ee.knowituniversity.data;

import ee.knowituniversity.exceptions.GradeException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "student", propOrder = {

})
public class Student implements Comparable<Student>{

    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger studentCode;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String lastName;

    @XmlTransient
    private double avg;
    @XmlTransient
    private int courses;
    @XmlTransient
    private int total;
    
    private final NumberFormat format = new DecimalFormat("#0.00");

    public Student() {
    }

    public Student(ee.knowituniversity.generated.Student s) {
        setStudentCode(s.getStudentCode());
        setName(s.getName());
        setLastName(s.getLastName());
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
        if (value == null || value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Can be positive only");
        }
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
        if (grade < 0 || grade > 5) {
            throw new GradeException(grade);
        }
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
