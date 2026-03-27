package com.growvity.growvity.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.growvity.growvity.Enum.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String UserName;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    private String password;
    private String phone;

    
    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();

   

    // Trainer -> Courses
    @JsonIgnore
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Courses> courses; 

    // Student -> Enrollments
    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade  = CascadeType.ALL)
    private List<Enrollment> enrollments;

    // Student -> Payments
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Payment> payments;

    // Trainer -> Uploaded Notes
    @JsonIgnore
    @OneToMany(mappedBy = "uploadedBy")
    private List<Note> uploadedNotes;

    // Messages Sent
    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    // Messages Received
    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private List<Message> receivedMessages;
}