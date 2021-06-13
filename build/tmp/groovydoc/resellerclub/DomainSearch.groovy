package resellerclub

class DomainSearch {
    Entity entity
    Orders orders

    DomainSearch() {
    }

    Entity getEntity() {
        return entity
    }

    void setEntity(Entity entity) {
        this.entity = entity
    }

    Orders getOrders() {
        return orders
    }

    void setOrders(Orders orders) {
        this.orders = orders
    }
}
