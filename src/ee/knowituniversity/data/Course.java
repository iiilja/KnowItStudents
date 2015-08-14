package ee.knowituniversity.data;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "course", propOrder = {

})
public class Course {

    @XmlElement(required = true)
    protected String courseCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idCourse;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String lecturer;

    public Course() {
    }
    
    public Course(ee.knowituniversity.generated.Course courseGenerated) {
        setCourseCode(courseGenerated.getCourseCode());
        setIdCourse(courseGenerated.getIdCourse());
        setName(courseGenerated.getName());
        setLecturer(courseGenerated.getLecturer());
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
        if (value == null || value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Can be positive only");
        }
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
