package com.example.cpmpgroup.security.services;


import com.example.cpmpgroup.dao.exception.ResourceNotFoundException;
import com.example.cpmpgroup.dao.models.ERole;
import com.example.cpmpgroup.dao.models.Role;
import com.example.cpmpgroup.dao.models.User;
import com.example.cpmpgroup.dao.repository.OrganisationRepository;
import com.example.cpmpgroup.dao.repository.RoleRepository;
import com.example.cpmpgroup.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganisationRepository organRepo;



    public User find(String username) {

        return userRepository.findByUsername(username);
    }


    public void Delete(Long id) {
        userRepository.deleteById(id);
    }

    public void DeleteAll() {
        userRepository.deleteAll();
    }

    // delete oll user of one organisation

    public void DeleteAllOrg_User(Long idOrg) {

        // get  all organisaton users by id_org
        List<User> liste = userRepository.findByOrganisationId(idOrg);
        for(User u :liste){
            Long  id=u.getId();
            Delete(id);
        }

        // delete all users




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



    public Role saveRole(Role role) {
        log.info("saving role {}  to the data base ", role.getName());
        return roleRepository.save(role);
    }



    public void addRoleToUser(String username, ERole roleName) {
        log.info("adding role {} to  user {}  ", roleName, username);
       User  u = userRepository.findByUsername(username);
        Role r = roleRepository.findByName(roleName);

        log.info("step one ");
        u.getRoles().add(r);
    }



    public User getUserByUsername(String username) {
        log.info("getting user {} from the the data base ", username);
        return userRepository.findByUsername(username);
    }


    public List<User> getUsers() {
        log.info("getting all users from the data base ");
        return userRepository.findAll();
    }


    /*public User fetchUserByEmail(String email){

        return   userRepository.findByEmail(email);
    }
    */

    public User fetchUserByUserNameandPassword(String name, String password) {

        return userRepository.findByUsernameAndPassword(name, password);
    }


    public User fetchUserByEmail(String tempMail) {
        return userRepository.findByEmail(tempMail);
    }


    // get user by id organisation ::

    public List<User> findUser(Long id) {

        return userRepository.findByOrganisationId(id);
    }


    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    //Simple user



    public User premierFois(Long organId, User user) {
        log.info("saving user  {}to the data base ", user.getUsername());
        return organRepo.findById(organId).map(organisation -> {

            user.setOrganisation(organisation);


            // user.setRoles(roles);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));

    }

/*
    public List<User> trouverEmployer(Long idOrg) {

        List<User> liste = userRepository.findByOrganisationId(idOrg);
        List<User> listfinale = new ArrayList<>();
        for (User u : liste) {
            Role rolesUser;
            Long iduser = u.getId();
            rolesUser = roleRepository.findRoleByUsersId(iduser);
            if(rolesUser.getId()==7){

                listfinale.add(u);

            }

        }

        return listfinale;
    }


 */
/*
    public User addRole(@PathVariable String username, String role) {
        User u = userRepository.findByUsername(username);
        Role r = roleRepository.findByName(role);
        if ((u != null ) && (r != null)  ) {

            u.getRoles().add(r);


        }else{
            System.out.println("check user and  role ");
        }
        return userRepository.save(u);
    }



 */


    public User modifier(User user, Long id) {
        User user1=userRepository.getById(id);
        if( user.getUsername()!=null){
            user1.setUsername(user.getUsername());
        }
        if( user.getPassword()!=null){
            user1.setPassword(user.getPassword());
        }
        if( user.getEmail()!=null){
            user1.setEmail(user.getEmail());
        }
        if( user.getAdresse()!=null){
            user1.setAdresse(user.getAdresse());
        }

        if(user.getDatenaissance()!=null){
            user1.setDatenaissance(user.getDatenaissance());
        }
        if(user.getName()!=null){
            user1.setName(user.getName());
        }
        int   x=(int) user.getTel();
        String ch=""+x;
        if(ch!=null){
            user1.setTel(user.getTel());
        }
        if(user.getImage()!=null){
            user1.setImage(user.getImage());
        }
        userRepository.save(user1);
        return user1;
    }

}
