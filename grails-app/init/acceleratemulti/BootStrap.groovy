package acceleratemulti

import usermanagement.Organisation
import usermanagement.Role
import usermanagement.User
import usermanagement.UserRole

class BootStrap {

    def init = { servletContext ->


        Organisation teraret = new Organisation(name: "Teraret Managed Cloud Private Limited",website:"teraret.com").save()
        Organisation qualifica = new Organisation(name: "Qualifica Group",website:"qualificagroup.it").save()

        User admin = new User(organisation: teraret,username: "babuamuda@gmail.com",password:"B@vana20").save()
        User qualificaadmin = new User(organisation: qualifica,username: "audit@qualificagroup.it",password:"test@123").save()

        User customer = new User(organisation: teraret,username: "liricsdash2014@gmail.com",password:"lirics@123").save()
        User account = new User(organisation: teraret,username: "akshitharajappa10@gmail.com",password:"akshitha@123").save()
        Role adminrole = new Role(authority: "ROLE_ADMIN").save()
        Role companyrole =new Role(authority: "ROLE_COMPANY").save()
        Role contactrole =new Role(authority: "ROLE_CONTACT").save()
        Role customerrole = new Role(authority: "ROLE_CUSTOMER").save()
        Role accountrole = new Role(authority: "ROLE_ACCOUNT").save()

        UserRole.create(admin,adminrole)
        UserRole.create(qualificaadmin,companyrole)
        UserRole.create(customer,customerrole)
        UserRole.create(account,accountrole)



    }
    def destroy = {
    }
}
