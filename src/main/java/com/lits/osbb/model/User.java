package com.lits.osbb.model;

import javax.persistence.*;
import java.util.Set;

    @Entity
    @Table(name = "user")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "second_name")
        private String secondName;

        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "password")
        private String password;

        @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
        @JoinTable(name="user_roles",
                joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
                inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")})
        private Set<Role> roles;

        public User(Long id, String firstName, String secondName, String email, String password, Set<Role> roles) {
            this.id = id;
            this.firstName = firstName;
            this.secondName = secondName;
            this.email = email;
            this.password = password;
            this.roles = roles;
        }

        public User() {
        }

        public static UserBuilder builder() {
            return new UserBuilder();
        }

        public Long getId() {
            return this.id;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getSecondName() {
            return this.secondName;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPassword() {
            return this.password;
        }

        public Set<Role> getRoles() {
            return this.roles;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof User)) return false;
            final User other = (User) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$id = this.getId();
            final Object other$id = other.getId();
            if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
            final Object this$firstName = this.getFirstName();
            final Object other$firstName = other.getFirstName();
            if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName))
                return false;
            final Object this$secondName = this.getSecondName();
            final Object other$secondName = other.getSecondName();
            if (this$secondName == null ? other$secondName != null : !this$secondName.equals(other$secondName))
                return false;
            final Object this$email = this.getEmail();
            final Object other$email = other.getEmail();
            if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
            final Object this$password = this.getPassword();
            final Object other$password = other.getPassword();
            if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
            final Object this$roles = this.getRoles();
            final Object other$roles = other.getRoles();
            if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof User;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $id = this.getId();
            result = result * PRIME + ($id == null ? 43 : $id.hashCode());
            final Object $firstName = this.getFirstName();
            result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
            final Object $secondName = this.getSecondName();
            result = result * PRIME + ($secondName == null ? 43 : $secondName.hashCode());
            final Object $email = this.getEmail();
            result = result * PRIME + ($email == null ? 43 : $email.hashCode());
            final Object $password = this.getPassword();
            result = result * PRIME + ($password == null ? 43 : $password.hashCode());
            final Object $roles = this.getRoles();
            result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
            return result;
        }

        public String toString() {
            return "User(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", secondName=" + this.getSecondName() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", roles=" + this.getRoles() + ")";
        }

        public static class UserBuilder {
            private Long id;
            private String firstName;
            private String secondName;
            private String email;
            private String password;
            private Set<Role> roles;

            UserBuilder() {
            }

            public User.UserBuilder id(Long id) {
                this.id = id;
                return this;
            }

            public User.UserBuilder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public User.UserBuilder secondName(String secondName) {
                this.secondName = secondName;
                return this;
            }

            public User.UserBuilder email(String email) {
                this.email = email;
                return this;
            }

            public User.UserBuilder password(String password) {
                this.password = password;
                return this;
            }

            public User.UserBuilder roles(Set<Role> roles) {
                this.roles = roles;
                return this;
            }

            public User build() {
                return new User(id, firstName, secondName, email, password, roles);
            }

            public String toString() {
                return "User.UserBuilder(id=" + this.id + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ", email=" + this.email + ", password=" + this.password + ", roles=" + this.roles + ")";
            }
        }
    }
