package com.server.avanzado

import org.springframework.web.bind.annotation.*
import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import javax.crypto.BadPaddingException

@RestController
class JokesController (private val studentRepository: StudentRepository){
    @GetMapping("/jokes")
    fun getAllStudents():List<Jokes>{
        return studentRepository.findAll()
    }

    @PostMapping("/jokes")
    fun insertStudent(@RequestBody student:Jokes){
        studentRepository.save(student)
    }

    @GetMapping("/joke/{id}")
    fun getStudent(@PathVariable id : Long): Jokes{
        return studentRepository.findById(id).get()
        /*student.let{
            return student as Student
        }*/
    }

    @DeleteMapping("/jokes/{id}")
    fun deleteStudent(@PathVariable id : Long){
        studentRepository.deleteById(id)
    }

    @GetMapping("/jokes/{punchline}")
    fun getcifrado(@PathVariable punchline : String):String{

        val clave="de";

        var llaveUtf8 = clave.toByteArray(Charsets.UTF_8)
        val sha = MessageDigest.getInstance("SHA-1")
        llaveUtf8 = sha.digest(llaveUtf8)
        llaveUtf8 = llaveUtf8.copyOf(16)
        val llavedefinitiva= SecretKeySpec(llaveUtf8, "AES")

        println("Voy a descifrar")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, llavedefinitiva);
        val textcifrado = Base64.getEncoder().encodeToString(cipher.doFinal(punchline.toByteArray(Charsets.UTF_8)))
        return "He obtenido $textcifrado"
    }

}