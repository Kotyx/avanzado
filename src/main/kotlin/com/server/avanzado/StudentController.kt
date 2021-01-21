package com.server.avanzado

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController (private val studentRepository: StudentRepository){
    @GetMapping("/students")
    fun getAllStudents():List<Student>{
        return studentRepository.findAll()
    }

    @PostMapping("/students")
    fun insertStudent(@RequestBody student:Student){
        studentRepository.save(student)
    }
}