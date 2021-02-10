package com.server.avanzado

import org.springframework.web.bind.annotation.*

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

}