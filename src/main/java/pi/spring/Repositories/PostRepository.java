package pi.spring.Repositories;





import org.springframework.data.jpa.repository.JpaRepository;


import pi.spring.Entities.Post;


public interface PostRepository extends JpaRepository<Post,Integer>

{
	
}
