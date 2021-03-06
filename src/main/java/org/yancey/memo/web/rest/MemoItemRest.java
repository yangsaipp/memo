/******************************************************************************
* Copyright (C) 2014 ShenZhen ComTop Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
*****************************************************************************/

package org.yancey.memo.web.rest;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value="/memoItems/search")
	public List<MemoItemBO> searchMemoItem(MemoItemBO memoItemBO) {
		return memoItemRepository.findByStatus(memoItemBO.getStatus());
	}
	
	@GetMapping(value="/memoItems/{id}")
	public MemoItemBO find(@PathVariable Integer id) {
		return memoItemRepository.findOne(id);
	}
	
	@PostMapping(value="/memoItems")
	public MemoItemBO save(@RequestBody MemoItemBO memoItemBO) {
		if(memoItemBO.getCreateTime() == null) {
			memoItemBO.setCreateTime(new Timestamp( Calendar.getInstance().getTimeInMillis()));
		}
		if(memoItemBO.getStatus() == null) {
			memoItemBO.setStatus("0");
		}
		return memoItemRepository.save(memoItemBO);
	}
	
	@DeleteMapping(value="/memoItems/{id}")
	public void delete(@PathVariable Integer id) {
		memoItemRepository.delete(id);
	}
	
	@PostMapping(value="/batch_del_memoItems")
	public void delete(@RequestBody List<MemoItemBO> lstMemoItemBO) {
		memoItemRepository.deleteInBatch(lstMemoItemBO);;
	}

	@PostMapping(value="/batch_changeStatus_memoItems")
	public void changeStatus(@RequestBody List<MemoItemBO> lstMemoItemBO) {
		memoItemRepository.save(lstMemoItemBO);;
	}
	
}
