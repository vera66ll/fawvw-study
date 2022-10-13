package com.py.springboot_database.dao.jpa;

import com.py.springboot_database.model.entity.jpa.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {
//    jpa默认实现类，findby*（支持*And*、*Or*）方法，其中*表示实体属性名
    JpaUser findByUsername(String username);
    JpaUser findByEmail(String email);
    JpaUser findByMobile(String mobile);
    JpaUser findById(long id);
//    通过@Query注释实现方法count()
    @Query("SELECT COUNT (u.id) FROM JpaUser u")
    long count();
//    update需要加事务注解，注解用于提交事务，若没有带上这句，会报事务异常提示。
    @Transactional
//    自动清除实体里保存的数据。
    @Modifying(clearAutomatically = true)
    @Query("update JpaUser u set u.password=?1")
    void changepassword(String password);
}
