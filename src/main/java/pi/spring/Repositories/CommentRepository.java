package pi.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.spring.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
