package exam.project.backend.backend_project_exam.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import exam.project.backend.backend_project_exam.models.User;
import exam.project.backend.backend_project_exam.repositories.UserRepository;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userAttempt = userRepository.findByUsername(username);

        if(userAttempt.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new DatabaseUserDetails(userAttempt.get());
    }

    
}
