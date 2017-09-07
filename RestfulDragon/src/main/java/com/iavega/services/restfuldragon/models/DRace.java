package com.iavega.services.restfuldragon.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_races", schema = "dungeon_schema")
public class DRace implements Serializable {
	private static final long serialVersionUID = 4133140254292472098L;

	//@SequenceGenerator(name="seq2", initialValue=1, allocationSize=100)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq2")
	@Id
	@Column(name = "race_id")
	private Integer raceId;

	@Column(name = "race_name")
	private String raceName;

	public DRace() {
	}

	public DRace(int raceId, String raceName) {
		super();
		this.raceId = raceId;
		this.raceName = raceName;
	}

	public int getRaceId() {
		return raceId;
	}

	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	@Override
	public String toString() {
		return "DRace [raceId=" + raceId + ", raceName=" + raceName + "]";
	}

}
