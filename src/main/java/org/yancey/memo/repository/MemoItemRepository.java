package org.yancey.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yancey.memo.model.MemoItemBO;

@Repository
public interface MemoItemRepository extends JpaRepository<MemoItemBO, Integer>{
}
