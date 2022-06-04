package company.service;

import company.entity.User.AuthUser;
import company.entity.Basket;
import company.entity.User.Role;
import company.entity.User.User;
import company.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
//
//    @PersistenceContext
//    private EntityManager em;
//    @Autowired
    private final UserRepository userRepository;
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AuthUser( userRepository.findByUsername(username));
    }
    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setBasket(new Basket());
        user.setUserPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8-tDK7mhqc6rpu2D6_D0DlajCjll91k0HdA&usqp=CAU");
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

//    public List<User> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }

}
