package trainingusers.traininguser.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import trainingusers.traininguser.entity.Permission;

public interface PermissionDao extends PagingAndSortingRepository<Permission,String>{
}
