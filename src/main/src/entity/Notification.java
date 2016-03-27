package main.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("notification")
@Entity
@Table(name = "notification")
public class Notification {
	@Id @Column(name="notification_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;
	private String type;
	@Column(updatable=false)
	private String create_date;
	@Column(updatable=false)
	private String create_time;
}
