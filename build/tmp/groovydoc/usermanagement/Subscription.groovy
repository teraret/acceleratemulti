package usermanagement

import org.bson.types.ObjectId

class Subscription {
    ObjectId id
    Organisation organisation
    Plan plan
    Date dateCreated
    Date lastUpdated
    static embedded = ['organisation']
    static constraints = {
    }
}
