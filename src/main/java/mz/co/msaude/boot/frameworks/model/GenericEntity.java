/**
 *
 */
package mz.co.msaude.boot.frameworks.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Stélio Moiane
 *
 */
@MappedSuperclass
public class GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "UUID", length = 50, nullable = false)
	private String uuid;

	@Column(name = "CREATED_BY", length = 50, nullable = false)
	private String createdBy;

	@Column(name = "CREATED_AT", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "UPDATED_BY", length = 50)
	private String updatedBy;

	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "ENTITY_STATUS", nullable = false, length = 15)
	private EntityStatus entityStatus;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(final String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(final LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public EntityStatus getEntityStatus() {
		return this.entityStatus;
	}

	public void setEntityStatus(final EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}
}
