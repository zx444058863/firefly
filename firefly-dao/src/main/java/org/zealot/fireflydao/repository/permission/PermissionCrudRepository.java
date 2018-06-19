package org.zealot.fireflydao.repository.permission;

import org.springframework.data.repository.CrudRepository;
import org.zealot.fireflybase.entity.permission.Permission;

public interface PermissionCrudRepository extends CrudRepository<Permission, Long> {

}
