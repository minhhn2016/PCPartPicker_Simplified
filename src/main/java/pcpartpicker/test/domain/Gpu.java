package pcpartpicker.test.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gpuId;
    private String gpuName;

    @OneToMany(mappedBy = "gpu")
    private List<Build> buildList;

    public Gpu() {
    }

    public Gpu(String gpuName) {
        super();
        this.gpuName = gpuName;
    }

    public Long getGpuId() {
        return gpuId;
    }

    public void setGpuId(Long gpuId) {
        this.gpuId = gpuId;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public List<Build> getBuildList() {
        return buildList;
    }

    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }

    @Override
    public String toString() {
        return "Gpu{" +
                "gpuId=" + gpuId +
                ", gpuName='" + gpuName + '\'' +
                ", buildList=" + buildList +
                '}';
    }
}
