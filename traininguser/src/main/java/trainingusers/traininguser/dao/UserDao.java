package trainingusers.traininguser.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import trainingusers.traininguser.entity.User;

public interface UserDao extends PagingAndSortingRepository<User,String > {
}
