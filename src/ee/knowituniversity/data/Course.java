package ee.knowituniversity.data;

import java.math.BigInteger;

public class Course {

    protected String courseCode;
    protected BigInteger idCourse;
    protected String name;
    protected String lecturer;

    public Course() {
    }
    
    public Course(ee.knowituniversity.generated.Course courseGenerated) {
        this.courseCode = courseGenerated.getCourseCode();
        this.idCourse = courseGenerated.getIdCourse();
        this.name = courseGenerated.getName();
        this.lecturer = courseGenerated.getLecturer();
    }

    
    
    /**
     * Gets the value of the courseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the value of the courseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseCode(String value) {
        this.courseCode = value;
    }

    /**
     * Gets the value of the idCourse property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdCourse() {
        return idCourse;
    }

    /**
     * Sets the value of the idCourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdCourse(BigInteger value) {
        this.idCourse = value;
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
     * Gets the value of the lecturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLecturer() {
        return lecturer;
    }

    /**
     * Sets the value of the lecturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLecturer(String value) {
        this.lecturer = value;
    }

}
