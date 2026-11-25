package etec.backend.controller

import etec.backend.dto.DescuentoResponseDto
import etec.backend.service.ProcesadorDeComprasService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/compras")
class ComprasController(
    private val procesadorService: ProcesadorDeComprasService
) {
    @GetMapping("/calcular-descuento")
    fun calcularDescuento(
        @RequestParam("subtotal") subtotal: Double,
        @RequestParam("cupon", required = false) cupon: String?
    ): ResponseEntity<DescuentoResponseDto> {
        val montoFinal = procesadorService.calcularMontoFinal(subtotal, cupon)
        return ResponseEntity.ok(DescuentoResponseDto(montoFinal = montoFinal))
    }
}