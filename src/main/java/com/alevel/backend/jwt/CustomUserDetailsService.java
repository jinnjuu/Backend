package com.alevel.backend.jwt;

import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   private final UserRepository userRepository;

   public CustomUserDetailsService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public CustomUserDetails loadUserByUsername(final String email) {
      return userRepository.findByEmail(email)
         .map(user -> createUser(email, user))
         .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다."));
   }

   private CustomUserDetails createUser(String email, User user) {
      if (!user.isStatus()) {
         throw new RuntimeException(email + " -> 활성화되어 있지 않습니다.");
      }

      List<GrantedAuthority> grantedAuthorities = userRepository.findByEmail(email).stream()
              .map(authority -> new SimpleGrantedAuthority(authority.getAuthorities().toString()))
              .collect(Collectors.toList());

      return new CustomUserDetails(
              user,
              grantedAuthorities);
   }
}
