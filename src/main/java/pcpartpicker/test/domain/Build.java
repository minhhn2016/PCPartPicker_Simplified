package pcpartpicker.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Build {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buildId;
    private String buildName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cpuId")
    private Cpu cpu;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "motherboardId")
    private Motherboard motherboard;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ramId")
    private Ram ram;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "gpuId")
    private Gpu gpu;

    public Build() {
    }

    public Build(String buildName, Cpu cpu, Motherboard motherboard, Ram ram, Gpu gpu) {
        super();
        this.buildName = buildName;
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ram = ram;
        this.gpu = gpu;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Build{" +
                "buildId=" + buildId +
                ", buildName='" + buildName + '\'' +
                ", cpu=" + cpu.getCpuName() +
                ", motherboard=" + motherboard.getMotherboardName() +
                ", ram=" + ram.getRamName() +
                ", gpu=" + gpu.getGpuName() +
                '}';
    }
}
