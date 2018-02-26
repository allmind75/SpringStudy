package org.allg.persistence;

import org.allg.domain.MessageVO;

public interface MessageDAO {

	public void create(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(Integer mno) throws Exception;
	
	public void updateState(Integer mno) throws Exception;
}
