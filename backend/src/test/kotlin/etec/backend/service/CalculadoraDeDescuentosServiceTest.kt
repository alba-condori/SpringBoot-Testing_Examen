package etec.backend.service

import etec.backend.exception.PrecondicionInvalidaException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculadoraDeDescuentosServiceTest : BehaviorSpec({

    // 1. Instanciamos el servicio real (como es un test unitario, no necesitamos Spring activo)
    val calculadora = CalculadoraDeDescuentosService()

    Given("la calculadora de descuentos") {

        When("se intenta aplicar un descuento a un monto negativo (-50.0)") {

            Then("debe lanzar la excepción PrecondicionInvalidaException") {
                // 2. Kotest ejecuta este bloque esperando que OCURRA UN ERROR de tipo MontoMenorACeroException
                val excepcion = shouldThrow<PrecondicionInvalidaException> {
                    calculadora.aplicarDescuentosSegunUsuario(userID = "123", monto = -50.0)
                }
                // 3. Si el error fue lanzado, lo atrapa en la variable 'excepcion' y valida su mensaje
                excepcion.message shouldBe "El monto debe ser mayor a cero"
            }
        }
    }
})