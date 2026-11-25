package etec.backend.model

data class Cupon(val codigo: String, val descuento: Double, val subtotalMinimo: Double = 0.0)
// descuento = 0.15 (Double) significa 15%.
// subtotalMinimo = el subtotal debe SUPERAR este valor para aplicar el cupón.