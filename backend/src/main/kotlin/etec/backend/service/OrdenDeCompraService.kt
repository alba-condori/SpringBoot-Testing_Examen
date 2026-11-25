package etec.backend.service

import etec.backend.model.Item

class OrdenDeCompra() {
    val items = mutableListOf<Item>()
    fun agregarItem(item: Item) {
        this.items.add(item)
    }

    fun calcularTotal(): Int {
        return this.items.sumOf { it.precio }
    }

}
