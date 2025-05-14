package exam.project.backend.backend_project_exam.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import exam.project.backend.backend_project_exam.models.Role;
import exam.project.backend.backend_project_exam.models.User;

public class DatabaseUserDetails implements UserDetails{

    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        
        this.authorities = new HashSet<GrantedAuthority>();

        for( Role role : user.getRoles() ) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
    }

    

    public Integer getId() {
        return this.id;
    }


    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return this.password;
    }


    public Set<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
