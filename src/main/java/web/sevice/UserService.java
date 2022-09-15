package web.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;
@Service
public class UserService {
    private final UserDao userDaoImpl;

    @Autowired
    public UserService(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public List<User> index() {
        return userDaoImpl.index();
    }

    public User show(int id){
        return userDaoImpl.show(id);
    }

    @Transactional
    public void save(User user){ userDaoImpl.save(user); }

    @Transactional
    public void update (User user){
        userDaoImpl.update(user);
    }

    @Transactional
    public void delete(int id){
        userDaoImpl.delete(id);
    }
}
