package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@Table(name="cnnface")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JPA_MYSQL {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id",unique=true)
private Long id;
@Column(name="name",length=50)
private String name;
@Column(name="date",length=50)
private String date;

public JPA_MYSQL(String name, String date) {
    this.name = name;
}

	
}
