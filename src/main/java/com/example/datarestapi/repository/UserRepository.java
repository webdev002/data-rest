package com.example.datarestapi.repository;



import com.example.datarestapi.entity.Users;
import com.example.datarestapi.projection.CustomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "user",collectionResourceRel = "User",excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<Users,Integer> {

    @RestResource(path = "byNameAndPassword")
    public default Page<Users> findAllByFirst_nameAndPassword(@Param("firstName") String first_name, @Param("password") Integer password, Pageable pageable) {
        return null;
    }
}
