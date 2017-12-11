package pcpartpicker.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long motherboardId;
    private String motherboardName;

    @OneToMany(mappedBy = "motherboard")
    private List<Build> buildList;

    public Motherboard() {
    }

    public Motherboard(String motherboardName) {
        super();
        this.motherboardName = motherboardName;
    }

    public Long getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(Long motherboardId) {
        this.motherboardId = motherboardId;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "motherboardId=" + motherboardId +
                ", motherboardName='" + motherboardName + '\'' +
                ", buildList=" + buildList +
                '}';
    }
}
