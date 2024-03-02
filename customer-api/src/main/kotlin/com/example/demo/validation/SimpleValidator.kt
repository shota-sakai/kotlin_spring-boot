package com.example.demo.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import com.example.demo.validation.Simple
import org.springframework.beans.BeanWrapperImpl
 
class SimpleValidator : ConstraintValidator<Simple, Any> {
    lateinit var value1Name: String
    lateinit var value2Name: String

    override fun initialize(constraintAnnotation: Simple) {
        value1Name = constraintAnnotation.value1
        value2Name = constraintAnnotation.value2
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        if(value == null) return true
        val beanWrapper = BeanWrapperImpl(value)

        val value1 = beanWrapper.getPropertyValue(value1Name) as String?
        val value2 = beanWrapper.getPropertyValue(value2Name) as String?

        if (value1 == "" && value2 == "") {
            return true
        }
        
        return false;
    }
}