package top.dreamyy.hrm.dao.provider;


import static top.dreamyy.hrm.util.common.HrmConstants.MESSAGETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;


import top.dreamyy.hrm.domain.Message;

public class MessageDynaSqlProvider {
	
public String insertMessage(final Message message){
		
		return new SQL(){
			{
				INSERT_INTO(MESSAGETABLE);
				if(message.getCompanyname() != null){
					VALUES("companyname", "#{companyname}");
				}
				if(message.getCustomname() != null){
					VALUES("customname", "#{customname}");
				}
				if(message.getPhone()!= null){
					VALUES("phone", "#{phone}");
				}
				if(message.getEmail()!= null){
					VALUES("email", "#{email}");
				}
				if(message.getQq()!= null){
					VALUES("qq", "#{qq}");
				}
				if(message.getMessage()!= null){
					VALUES("message", "#{message}");
				}				
			}
		}.toString();
	}
			//分页动态查询
	public String selectWhitParam(final Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(MESSAGETABLE);
				if(params.get("message") != null){
					Message message = (Message)params.get("message");
					if(message.getCompanyname() != null ){
						WHERE(" commpanyname = #{message.commpanyname} ");
					}
					if(message.getCustomname()!= null ){
						WHERE(" customname = #{message.customname} ");
					}
					if(message.getPhone() != null ){
						WHERE("  phone LIKE CONCAT ('%',#{message.phne},'%') ");
					}
					if(message.getEmail() != null ){
						WHERE(" email LIKE CONCAT ('%',#{message.email},'%') ");
					}
					if(message.getQq()!= null ){
						WHERE(" qq LIKE CONCAT ('%',#{message.qq},'%') ");
					}
					if(message.getMessage()!= null ){
						WHERE("message = #{message.message}");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
	public String count(final Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(MESSAGETABLE);
				if(params.get("message") != null){
					Message message = (Message)params.get("message");
					if(message.getCompanyname() != null ){
						WHERE(" companyname = #{message.companyname} ");
					}
					if(message.getCompanyname() != null ){
						WHERE(" companyname = #{message.companyname} ");
					}
					if(message.getCustomname()!= null ){
						WHERE(" customname = #{message.customname} ");
					}
					if(message.getPhone() != null ){
						WHERE("  phone LIKE CONCAT ('%',#{message.phone},'%') ");
					}
					if(message.getEmail() != null ){
						WHERE(" email LIKE CONCAT ('%',#{message.email},'%') ");
					}
					if(message.getQq()!= null ){
						WHERE(" qq LIKE CONCAT ('%',#{message.qq},'%') ");
					}
					if(message.getMessage()!= null ){
						WHERE("message = #{message.message}");
					}
				}	
			}
		}.toString();
	}	

}
