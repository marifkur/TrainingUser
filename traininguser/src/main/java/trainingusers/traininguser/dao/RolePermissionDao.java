package trainingusers.traininguser.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import trainingusers.traininguser.entity.RolePermission;

public interface RolePermissionDao extends PagingAndSortingRepository<RolePermission, String>{
}
