package top.dreamyy.hrm.dao;



import java.util.List;
import java.util.Map;
import static top.dreamyy.hrm.util.common.HrmConstants.MESSAGETABLE;
import static top.dreamyy.hrm.util.common.HrmConstants.NOTICETABLE;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import top.dreamyy.hrm.dao.provider.MessageDynaSqlProvider;
import top.dreamyy.hrm.domain.Message;


public interface MessageDao {


	//动态插入
	@SelectProvider(type=MessageDynaSqlProvider.class,method="insertMessage")
	void savemessage(Message message);
	
	 //根据Id查找
	@Select("select * from "+MESSAGETABLE+" where ID = #{id}")
	Message selectById(int id);
	
	//查找所有
	@Select("select * from "+MESSAGETABLE+" ")
		List<Message> selectAllMessages();
	
	
	
		// 根据参数查询信息总数
		@SelectProvider(type=MessageDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
		
		// 根据参数动态查询信息
		@SelectProvider(type=MessageDynaSqlProvider.class,method="selectWhitParam")
		List<Message> selectByPage(Map<String, Object> params);
	
		@Delete(" delete from "+MESSAGETABLE+" where id = #{id} ")
		void deleteById(Integer id);

}
