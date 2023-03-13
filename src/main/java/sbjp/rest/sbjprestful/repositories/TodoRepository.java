package sbjp.rest.sbjprestful.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sbjp.rest.sbjprestful.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{
	Todo findOneByIdAndLinkIdAndType(int id, int linkId, int typeRole);
	List<Todo> findAllByLinkId(int linkId);
	Todo findOneById(int id);
	@Query("FROM Todo t where t.startDate = :startDate And t.endDate = :endDate") 
	List<Todo> findAllBystartDateAndendDate(@Param("startDate")Date startDate,@Param("endDate") Date endDate);
}
