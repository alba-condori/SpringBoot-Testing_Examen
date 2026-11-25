package etec.backend.repository

import org.springframework.stereotype.Repository
import etec.backend.model.Cupon

//Este archivo se encarga de buscar y guardar datos (@Repository)

interface CuponRepository {
    fun buscarPorCodigo(codigo: String): Cupon?
}
//Una interfaz es un contrato, dice qué se puede hacer pero no cómo
//Esta dice que quien sea un CuponRepository sabe buscar un cupón por su código

@Repository
class CuponRepositoryEnMemoria : CuponRepository {
    //Es quien cumple el contrato. ": CuponRepository" significa que se implementa esa interfaz

    private val cupones = listOf(
        Cupon("PRIMERA_COMPRA", 0.15),
        Cupon("BLACK_FRIDAY", 0.30, subtotalMinimo = 500.0),
    )
    //Son los cupones guardados

    override fun buscarPorCodigo(codigo: String): Cupon? {
        return cupones.find { it.codigo == codigo }
    }
    //override significa que esta función esta implementando un metodo que ya fue definido... en mi caso en la interface
}