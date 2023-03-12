package sbjp.rest.sbjprestful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbjp.rest.sbjprestful.entities.GroupMember;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer>{
	//GroupMember findOneByuserIdAndgroupId(int userId, int groupId);
}
