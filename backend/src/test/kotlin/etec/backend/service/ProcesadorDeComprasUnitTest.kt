package etec.backend.service

import etec.backend.model.Cupon
import etec.backend.repository.CuponRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class ProcesadorDeComprasUnitTest : BehaviorSpec({

    val cuponRepository = mockk<CuponRepository>()
    val procesador = ProcesadorDeComprasService(cuponRepository)

    Given("un servicio de procesamiento de compras") {

        When("se intenta procesar una orden con un monto total de 0.0") {
            Then("debe lanzar PrecondicionInvalidaException con el mensaje esperado") {
                val excepcion = shouldThrow<???> {
                    procesador.calcularMontoFinal(subtotal = ???, codigoCupon = null)
                }
                excepcion.message shouldBe "???"
            }
        }
    }

    Given("un carrito con un subtotal de 600.0 y el cupón BLACK_FRIDAY") {
        every { cuponRepository.buscarPorCodigo("BLACK_FRIDAY") } returns
                Cupon("BLACK_FRIDAY", 0.30, subtotalMinimo = 500.0)

        When("se calcula el monto final de la compra") {
            val resultado = procesador.calcularMontoFinal(subtotal = ???, codigoCupon = "???")

            Then("se aplica el 30% de descuento y el total es 420.0") {
                resultado shouldBe ???
            }
        }
    }
})