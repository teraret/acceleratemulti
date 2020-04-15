package usermanagement

import grails.plugin.springsecurity.SpringSecurityService
import org.grails.datastore.mapping.multitenancy.AllTenantsResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.security.core.userdetails.UserDetails

class CustomTenentResolver implements AllTenantsResolver{
    @Lazy
    @Autowired
    SpringSecurityService springSecurityService

    @Override
    Iterable<Serializable> resolveTenantIds() {
        return DetachedCriteria(Organisation).distinct("website").list()
    }

    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {
        final String tenantId = organisation()
        if(tenantId){
            return tenantId
        }
        throw new TenantNotFoundException("unable to retrive tenent")
    }

    String organisation(){

        if (springSecurityService.principal == null){
            return null
        }

        if (springSecurityService.principal instanceof  String){
            return springSecurityService.principal
        }

        if (springSecurityService.principal instanceof UserDetails){

           return User.findByUsername(((UserDetails)springSecurityService.principal).username).organisation.website

            //return ((UserDetails)springSecurityService.principal).username
        }

        null
    }
}
