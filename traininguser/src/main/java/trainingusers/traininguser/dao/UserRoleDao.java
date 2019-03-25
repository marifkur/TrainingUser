package trainingusers.traininguser.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import trainingusers.traininguser.entity.UserRole;

public interface UserRoleDao extends PagingAndSortingRepository<UserRole, String>{
}
