package org.yancey.memo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yancey.memo.model.MemoItemBO;

@Repository
public interface MemoItemRepository extends JpaRepository<MemoItemBO, Integer> {
	
	@Query("select t from MemoItemBO t where t.status = ?1")
	List<MemoItemBO> findByStatus(String status);
}
