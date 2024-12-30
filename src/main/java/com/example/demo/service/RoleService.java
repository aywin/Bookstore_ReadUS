package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Récupérer tous les rôles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Récupérer un rôle par ID
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    // Créer un rôle
    public Role createRole(String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }

    // Supprimer un rôle
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
