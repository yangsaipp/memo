/******************************************************************************
* Copyright (C) 2014 ShenZhen ComTop Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
*****************************************************************************/

package org.yancey.memo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yancey.memo.model.MemoItemBO;
import org.yancey.memo.repository.MemoItemRepository;

/**
 * @author  杨赛
 * @since   jdk1.7
 * @version 2018年1月18日 杨赛
 */
@RestController
public class MemoItemRest {
	
	@Autowired
	private MemoItemRepository memoItemRepository;
	
	@GetMapping(value="/memoItems")
	public List<MemoItemBO> queryToDoMemoItemVO() {
		return memoItemRepository.findAll();
	}
	
	@GetMapping(value="/memoItems/{id}")
	public MemoItemBO find(Integer id) {
		return memoItemRepository.findOne(id);
	}
	
	@PostMapping(value="/memoItems")
	public MemoItemBO save(MemoItemBO memoItemBO) {
		return memoItemRepository.save(memoItemBO);
	}
	
	@DeleteMapping(value="/memoItems/{id}")
	public void delete(Integer id) {
		memoItemRepository.delete(id);
	}
	
}
