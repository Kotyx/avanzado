package com.server.avanzado

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository

@Configuration
class LoadDatabase {
    companion object {
        val logger = LoggerFactory.getLogger(LoadDatabase.javaClass)
    }

    @Bean
    fun initDatabase(studentRepository: StudentRepository):CommandLineRunner {
       return CommandLineRunner{args:Array<String?>? ->
            logger.info("Preloading " + studentRepository.save(Student("Paquito", "Chocolatero")))
            logger.info("Preloading " + studentRepository.save(Student("Joan", "Bernat")))
        }
    }

}