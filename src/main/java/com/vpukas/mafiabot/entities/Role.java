package com.vpukas.mafiabot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    private String roleName;
    private Boolean isActiveRole;
    @OneToMany(mappedBy = "role")
    private Set<Player> players = new HashSet<>();
    public Role(String roleName, Boolean isActiveRole){
        this.roleName = roleName;
        this.isActiveRole = isActiveRole;
    }
}
