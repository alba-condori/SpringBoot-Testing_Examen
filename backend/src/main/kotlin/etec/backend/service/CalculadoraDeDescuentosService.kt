package etec.backend.service

import etec.backend.exception.PrecondicionInvalidaException
import org.springframework.stereotype.Service

@Service
class CalculadoraDeDescuentosService {

    fun aplicarDescuentosSegunUsuario(userID: String, monto: Double): Double {
        // La implementación real de la regla de negocio se probará en el test de integración.
        if (monto <= 0) {
            throw PrecondicionInvalidaException("El monto debe ser mayor a cero") //"PrecondicionInvalidaException" es "MontoMenorACeroException"
        }
        return monto * 0.75
    }
}