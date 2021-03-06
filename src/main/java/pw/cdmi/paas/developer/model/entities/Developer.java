package pw.cdmi.paas.developer.model.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import lombok.Data;



@Data
@Entity
@Table(name = "p_developer")
public class Developer {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;							//开发者id
	
	@Column(name="name", nullable=false)
	private String Name;						//开发者名称
	
	@Column(name="type", nullable=false)
	private String Type;					//开发者类型，个人用户、企业用户
	
	@Column(name="people_id", nullable = false)
	private String peopleId;					//开发者主管的Id
	
	@Column(name="open_id" , nullable= false)
	private String openId;
		
	@CreatedDate
	private Date createTime;					//注册时间
}
