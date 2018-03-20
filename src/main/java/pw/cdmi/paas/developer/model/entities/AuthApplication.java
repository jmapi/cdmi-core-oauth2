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
@Table(name="p_authapp")
public class AuthApplication {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column(name="name", nullable=false)
	private String appName;
	
	@Column(name="type", nullable=false)
	private String appType;
	
	@Column(name="url_icon",nullable=true)
	private String urlIcon;
	
	@CreatedDate
	@Column(name="create_time",nullable=false)
	private Date createTime;
	@CreatedDate
	@Column(name="update_time",nullable=true)
	private Date updateTime;
	
	//对应的开发者
	@Column(name="developer_id",nullable=false)
	private String developerId;
}
