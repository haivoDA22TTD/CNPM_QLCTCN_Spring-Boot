package spring.boot.quan_ly_chi_tieu_ca_nhan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.boot.quan_ly_chi_tieu_ca_nhan.config.UserDetailsImpl;
import spring.boot.quan_ly_chi_tieu_ca_nhan.model.User;
import spring.boot.quan_ly_chi_tieu_ca_nhan.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
 @Autowired
    private UserRepository userRepository;

   @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy user: " + username));
    return new UserDetailsImpl(user);
}

}
