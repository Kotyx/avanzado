package com.server.avanzado

import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Jokes,Long>