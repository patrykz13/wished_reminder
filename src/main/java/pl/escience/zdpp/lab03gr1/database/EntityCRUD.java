package pl.escience.zdpp.lab03gr1.database;

import java.util.List;

/**
 * <p>EntityCRUD interface.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public interface EntityCRUD<T> {
    /**
     * <p>getEntities.</p>
     *
     * @return a {@link java.util.List} object.
     */
    List<T> getEntities();

    /**
     * <p>saveEntity.</p>
     *
     * @param entity a T object.
     * @throws java.lang.Exception if any.
     */
    void saveEntity(T entity) throws Exception;

    /**
     * <p>getEntity.</p>
     *
     * @param id a int.
     * @return a T object.
     */
    T getEntity(int id);

    /**
     * <p>deleteEntity.</p>
     *
     * @param id a int.
     * @throws java.lang.Exception if any.
     */
    void deleteEntity(int id) throws Exception;
}
