package pi.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.spring.Entities.Vote;

public interface VoteRepository extends JpaRepository<Vote,Integer> {

}
