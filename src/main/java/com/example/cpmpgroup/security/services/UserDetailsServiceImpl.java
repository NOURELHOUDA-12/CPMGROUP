package com.example.cpmpgroup.security.services;



import com.example.cpmpgroup.dao.exception.ResourceNotFoundException;
import com.example.cpmpgroup.dao.models.Role;
import com.example.cpmpgroup.dao.models.User;
import com.example.cpmpgroup.dao.repository.OrganisationRepository;
import com.example.cpmpgroup.dao.repository.RoleRepository;
import com.example.cpmpgroup.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  OrganisationRepository organRepo;
  @Autowired
  RoleRepository roleRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
        //.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
  // save user
  public User premierFois(Long organId, User user) {
    log.info("saving user  {}to the data base ", user.getUsername());
    return organRepo.findById(organId).map(organisation -> {

      user.setOrganisation(organisation);


      // user.setRoles(roles);
      return userRepository.save(user);
    }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));

  }


  public User saveUser(Long organId, Long roleId, User user) {
    MultipartFile file = null;
    log.info("saving user  {}to the data base ", user.getUsername());
    return organRepo.findById(organId).map(organisation -> {
      return roleRepository.findById(roleId).map(role -> {
        Role rolee = roleRepository.getById(roleId);
        user.setOrganisation(organisation);
         user.getRoles().add(rolee);

        // user.setRoles(roles);
        return userRepository.save(user);
      }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }).orElseThrow(() -> new ResourceNotFoundException("roleId  " + roleId + " not found"));
  }


}
