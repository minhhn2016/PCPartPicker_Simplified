package pcpartpicker.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ramId;
    private String ramName;

    @OneToMany(mappedBy = "ram")
    private List<Build> buildList;

    public Ram() {
    }

    public Ram(String ramName) {
        super();
        this.ramName = ramName;
    }

    public Long getRamId() {
        return ramId;
    }

    public void setRamId(Long ramId) {
        this.ramId = ramId;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "ramId=" + ramId +
                ", ramName='" + ramName + '\'' +
                ", buildList=" + buildList +
                '}';
    }
}
