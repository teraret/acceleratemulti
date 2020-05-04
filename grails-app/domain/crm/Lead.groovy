package crm

import grails.gorm.MultiTenant
import usermanagement.User

class Lead  implements MultiTenant<Lead> {
    Account account
    String tenantId
    String firstName
    String lastName
    Date dob
    String note
    String mobile
    String email
    String country
    String state
    String zip
    Date dateCreated
    Date lastUpdated
    User user

    static constraints = {
    }


}
