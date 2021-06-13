package usermanagement

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    List<User> list(params){

        return User.createCriteria().list( max:params.max, offset:params.offset){

            if(params.mobile){
                like('mobile',"%"+params.mobile+"%")
            }

            if(params.email){
                like('email',"%"+params.email+"%")

            }
            if(params.username){
                like('username',"%"+params.username+"%")

            }

//            and {
//                if(params.enabled == 1){
//                    eq('enabled',false)
//                }

//            }


//
//
//
//            if(typeof params.mobileVerified == "boolean"){
//                eq('mobileVerified',Boolean.parseBoolean(params.mobileVerified))
//            }
//
//            if(typeof params.accountExpired == "boolean"){
//                eq('accountExpired',Boolean.parseBoolean(params.accountExpired))
//            }
//
//            if(typeof params.accountLocked == "boolean"){
//                eq('accountLocked',Boolean.parseBoolean(params.accountLocked))
//            }
//
//            if(typeof params.passwordExpired == "boolean"){
//                eq('passwordExpired',Boolean.parseBoolean(params.passwordExpired))
//            }

        }
    }

    List<User> saveAll(List<User> users ){
        users.each{ user ->
            User.save(user)
        }
        return users
    }

    User save(User user){
        return User.save(user)
    }

    void delete(Serializable id){
        User.delete(id)
    }

}
