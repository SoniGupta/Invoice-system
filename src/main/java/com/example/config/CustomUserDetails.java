package com.example.config;

import com.example.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * Created by soni on 28/4/16.
 */
public class CustomUserDetails extends UserEntity implements UserDetails {
    private static final long serialVersionUID = 1L;
    private List<String> userRoles;

    public CustomUserDetails(UserEntity userEntity, List<String> userRoles) {
        super(userEntity);
        this.userRoles = userRoles;

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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

