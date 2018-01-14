package learningSpring.SpringBoot.services;

import learningSpring.SpringBoot.entities.UserRole;
import learningSpring.SpringBoot.entities.Users;
import learningSpring.SpringBoot.forms.UserForm;
import learningSpring.SpringBoot.repositories.RoleRepo;
import learningSpring.SpringBoot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo role;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUserToDB(UserForm registrationForm){
        String email = registrationForm.getEmail();
        String password = bCryptPasswordEncoder.encode(registrationForm.getPassword());
        userRepo.saveAndFlush(new Users(email, password));
        role.saveAndFlush(new UserRole(userRepo.findOneByMail(email).getId(), "ROLE_user"));
    }
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepo.findOneByMail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

}
