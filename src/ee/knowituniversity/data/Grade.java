package ee.knowituniversity.data;

import ee.knowituniversity.exceptions.GradeException;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grade", propOrder = {

})
public class Grade {

    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idGrade;
    protected int gradeValue;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idCourse;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger studentCode;
    
    public Grade(){
        
    }

    public Grade(ee.knowituniversity.generated.Grade grade) {
        setIdCourse(grade.getIdCourse());
        setIdGrade(grade.getIdGrade());
        setGradeValue(grade.getGradeValue());
        setStudentCode(grade.getStudentCode());
    }
    
    

    public BigInteger getIdGrade() {
        return idGrade;
    }

    /**
     * Sets the value of the idGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdGrade(BigInteger value) { 
        this.idGrade = value;
    }

    /**
     * Gets the value of the gradeValue property.
     * 
     */
    public int getGradeValue() {
        return gradeValue;
    }

    /**
     * Sets the value of the gradeValue property.
     * 
     */
    public void setGradeValue(int value) {
        if (value < 0 || value > 5) {
            throw new GradeException(value);
        }
        this.gradeValue = value;
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

}
