package pcpartpicker.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpuId;
    private String cpuName;

    @OneToMany(mappedBy = "cpu")
    private List<Build> buildList;

    public Cpu() {
    }

    public Cpu(String cpuName) {
        super();
        this.cpuName = cpuName;
    }

    public Long getCpuId() {
        return cpuId;
    }

    public void setCpuId(Long cpuId) {
        this.cpuId = cpuId;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "cpuId=" + cpuId +
                ", cpuName='" + cpuName + '\'' +
                ", buildList=" + buildList +
                '}';
    }
}
