//package com.example.teacherspringwebapp.security;
//
//import com.example.teacherspringwebapp.entity.TeacherEntity;
//import com.example.teacherspringwebapp.repository.TeacherRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TeacherLoginService implements UserDetailsService {
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TeacherEntity teacher = teacherRepository.findByUsername(username);
//
//        if (teacher != null) {
//            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
//
//            builder.disabled(false);
//            builder.password(teacher.getPassword());
//
//            String[] authoritiesArr = new String[]{ "USER", "ROLE_USER"};
//            builder.authorities(authoritiesArr);
//
//            final UserDetails userDetails = builder.build();
//
//            return userDetails;
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
//
//    }
//}
