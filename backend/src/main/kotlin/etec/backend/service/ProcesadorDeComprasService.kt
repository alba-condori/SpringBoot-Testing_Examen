package etec.backend.service

import org.springframework.stereotype.Service
import etec.backend.exception.PrecondicionInvalidaException
import etec.backend.exception.CuponInvalidoException
import etec.backend.repository.CuponRepository

@Service
class ProcesadorDeComprasService(
    private val cuponRepository: CuponRepository
) {
    fun calcularMontoFinal(subtotal: Double, codigoCupon: String?): Double {
        if (subtotal <= 0) {
            throw PrecondicionInvalidaException("El monto total de la compra debe ser mayor a cero")
        }
        if (codigoCupon == null) {
            return subtotal
        }
        val cupon = cuponRepository.buscarPorCodigo(codigoCupon)
            ?: throw CuponInvalidoException("El cupón proporcionado no existe")

        if (subtotal <= cupon.subtotalMinimo) {
            return subtotal
        }
        return subtotal - subtotal * cupon.descuento
    }
}