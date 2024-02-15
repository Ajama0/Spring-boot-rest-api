package com.example.demo.Student;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
        @Id
        @SequenceGenerator(
                name = "student_sequence",
                sequenceName = "student_sequence",
                allocationSize = 1
        )

        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "student_sequence"
        )

private long id;
        @Transient
        private Integer age;
private String name;
private LocalDate dob;
private String email;

        public Student(){}

        public Student( String name, LocalDate dob, String email){
                this.name=name;
                this.dob=dob;
                this.email=email;

        }

        public Student( long id, String name, LocalDate dob, String email){
                this.id=id;
                this.name=name;
                this.dob=dob;
                this.email=email;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public LocalDate getDob() {
                return dob;
        }

        public void setDob(LocalDate dob) {
                this.dob = dob;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public Integer getAge() {
                return Period.between(this.dob , LocalDate.now()).getYears();
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        @Override
        public String toString() {
                return "Student{" +
                        "age=" + age +
                        ", id=" + id +
                        ", name='" + name + '\'' +
                        ", dob=" + dob +
                        ", email='" + email + '\'' +
                        '}';
        }
}
