/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.knowituniversity.exceptions;

/**
 *
 * @author ilja
 */
public class GradeException extends IllegalArgumentException{

    public GradeException(int grade) {
        
        super("Grade may be contain values from 0 to 5. The given value is " + grade);
    }
    
}
