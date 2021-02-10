package com.server.avanzado

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Jokes (var type:String, var setup:String, var punchline:String){
    @Id
    @GeneratedValue
    private val id: Long? = null
    override fun equals(other: Any?): Boolean {
        if(other is Jokes){
            if(other is Jokes){
                return other.id==id && id != null
            }else{
                return false
            }
        }

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(id,type,setup,punchline)
    }

    override fun toString(): String {
        return "$id ,$type: $setup , $punchline"
    }
}