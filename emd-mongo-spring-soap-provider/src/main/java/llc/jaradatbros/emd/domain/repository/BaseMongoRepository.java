/**
 * JaradatBros LLC
 */
package llc.jaradatbros.emd.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface to host commonly named methods across Mongo repository classes.
 *
 * @author wkmaaj
 */
@NoRepositoryBean
public interface BaseMongoRepository<T> extends MongoRepository<T, String> {
    List<T> findByName(String name);
}
