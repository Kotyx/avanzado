package com.server.avanzado

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Student (var name:String,var surname:String){
    @Id
    @GeneratedValue
    private val id: Long?=null
    override fun equals(other: Any?): Boolean {
        if(other is Student){
            if(other is Student){
                return other.id==id && id != null
            }else{
                return false
            }
        }

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(id,name,surname)
    }

    override fun toString(): String {
        return "Alumno $name $surname e id = $id"
    }
}