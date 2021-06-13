package usermanagement

import org.bson.types.ObjectId

class Product {
    ObjectId id
    String name
    String namespace
    String description
    User user

    static constraints = {
        description nullable: true, blank: true
    }
}
