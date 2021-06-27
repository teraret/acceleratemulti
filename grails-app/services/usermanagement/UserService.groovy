package usermanagement

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

interface IUserService{
    User get(Serializable id)

    void delete(Serializable id)

    User save(User user)
}

@Transactional
@Service(User)
abstract class UserService implements IUserService {

    List<User> list(params){

        return User.createCriteria().list( max:params.max, offset:params.offset){
            eq('enabled',true)
            if(params.mobile){
                and {
                    like('mobile',"%"+params.mobile+"%")
                }
            }

            if(params.email){
                and {
                    like('email',"%"+params.email+"%")
                }
            }
            if(params.username){
                and {
                    like('username',"%"+params.username+"%")
                }
            }

        }
    }

    List<User> saveAll(List<User> users ){
        users.each{ user ->
            User.save(user)
        }
        return users
    }

}
