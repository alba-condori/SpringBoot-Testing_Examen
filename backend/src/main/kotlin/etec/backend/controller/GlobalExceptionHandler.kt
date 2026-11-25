package etec.backend.controller

import etec.backend.dto.ErrorResponseDto
import etec.backend.exception.PrecondicionInvalidaException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import etec.backend.exception.CuponInvalidoException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(PrecondicionInvalidaException::class)
    fun manejarPrecondicionInvalida(ex: PrecondicionInvalidaException): ResponseEntity<ErrorResponseDto> {
        val cuerpoError = ErrorResponseDto(error = ex.message ?: "Parámetros inválidos")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpoError)
    }

    @ExceptionHandler(CuponInvalidoException::class)
    fun manejarCuponInvalido(ex: CuponInvalidoException): ResponseEntity<ErrorResponseDto> {
        val cuerpoError = ErrorResponseDto(error = ex.message ?: "Cupón inválido")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpoError)
    }
}