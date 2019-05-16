package example01;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//curl -i -X POST -H "Content-Type:application/json" -d "{\"firstName\": \"Frodo\", \"lastName\": \"Baggins\"}" http://localhost:8080/people
//http://localhost:8080/people/search/findByLastName?name=Baggins
//http://localhost:8080
//http://localhost:8080/people

@RepositoryRestResource( collectionResourceRel = "people", path = "people")
interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	@RestResource(rel = "findItByLast", path = "findItByLast")
	List<Person> findByLastName(@Param("name") String name);

}

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

