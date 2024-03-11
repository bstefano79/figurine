package it.bstefano79.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_figurine_statuses")
public class UserFigurineStatus {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "figurine_album_id", nullable = false)
    private FigurineAlbum figurineAlbum;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private FigurineStatus status;
    
    private Integer duplicatesCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FigurineAlbum getFigurineAlbum() {
		return figurineAlbum;
	}

	public void setFigurineAlbum(FigurineAlbum figurineAlbum) {
		this.figurineAlbum = figurineAlbum;
	}

	public FigurineStatus getStatus() {
		return status;
	}

	public void setStatus(FigurineStatus status) {
		this.status = status;
	}

	public Integer getDuplicatesCount() {
		return duplicatesCount;
	}

	public void setDuplicatesCount(Integer duplicatesCount) {
		this.duplicatesCount = duplicatesCount;
	}
}
