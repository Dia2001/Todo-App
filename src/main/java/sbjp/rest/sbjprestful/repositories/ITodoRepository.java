package sbjp.rest.sbjprestful.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbjp.rest.sbjprestful.entities.Todo;

@Repository
public interface ITodoRepository extends JpaRepository<Todo,Integer>{
	Todo findOneByIdAndLinkIdAndType(int id, int linkId, String typeRole);
	Todo findOneByIdAndLinkId(int id, int linkId);
}
