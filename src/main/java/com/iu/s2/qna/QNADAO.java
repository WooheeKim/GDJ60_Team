package com.iu.s2.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s2.util.Pager;

@Repository
public class QNADAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s2.qna.QNADAO.";
	

	public Long getQNACount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getQNACount", pager);
	}
	
	public List<QNADTO> getQNAList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getQNAList", pager);
	}
	
	public QNADTO getQNADetail(QNADTO qnaDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getQNADetail", qnaDTO);
	}
	
	public int setQNAAdd(QNADTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setQNAAdd", qnaDTO);
	}
	
	public int setQNAUpdate(QNADTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "setQNAUpdate", qnaDTO);
	}
	
	public int setQNADelete(QNADTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setQNADelete", qnaDTO);
	}
	
	public int setQNAImgAdd(QNAImgDTO qnaImgDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setQNAImgAdd", qnaImgDTO);
	}

}
