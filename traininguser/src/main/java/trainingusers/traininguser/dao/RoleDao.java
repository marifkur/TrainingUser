package trainingusers.traininguser.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import trainingusers.traininguser.entity.Role;

public interface RoleDao extends PagingAndSortingRepository<Role, String> {
}
