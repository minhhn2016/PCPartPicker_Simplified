package pcpartpicker.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pcpartpicker.test.domain.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATests {
    @Autowired
    private BuildRepository buildRepository;

    @Autowired
    private CpuRepository cpuRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private RamRepository ramRepository;

    @Autowired
    private GpuRepository gpuRepository;

    @Test
    public void findByBuildNameShouldReturnBuild() {
        List<Build> builds = buildRepository.findByBuildName("Rysen!!!");
        assertThat(builds).hasSize(1);
        assertThat(builds.get(0).getBuildName()).isEqualTo("Rysen!!!");
    }

    @Test
    public void createNewBook() {
        Build build = new Build(
                "test",
                cpuRepository.findByCpuName("Intel Core i5 7600K").get(0),
                motherboardRepository.findByMotherboardName("MSI Z270 SLI-Plus").get(0),
                ramRepository.findByRamName("Kingston HyperX DDR4 2666Mhz CL15 2x8Gb").get(0),
                gpuRepository.findByGpuName("MSI nVidia GTX1080Ti Ligtning 11Gb").get(0)
        );
        buildRepository.save(build);
        assertThat(build.getBuildId()).isNotNull();
    }

    @Test
    public void deleteBuild() {
        List<Build> builds = buildRepository.findByBuildName("RGB is life");
        buildRepository.delete(builds.get(0));
        assertThat(buildRepository.findByBuildName("RGB is life")).hasSize(0);
    }

    @Test
    public void findByCpuNameShouldReturnCpu() {
        List<Cpu> cpus = cpuRepository.findByCpuName("AMD Ryzen 5 1600");
        assertThat(cpus).hasSize(1);
        assertThat(cpus.get(0).getCpuName()).isEqualTo("AMD Ryzen 5 1600");
    }

    @Test
    public void createNewCpu() {
        Cpu cpu = new Cpu("test");
        cpuRepository.save(cpu);
        assertThat(cpu.getCpuId()).isNotNull();
    }

    @Test
    public void deleteCpu() {
        List<Cpu> cpus = cpuRepository.findByCpuName("AMD Ryzen 7 1800X");
        cpuRepository.delete(cpus.get(0));
        assertThat(cpuRepository.findByCpuName("AMD Ryzen 7 1800X")).hasSize(0);
    }

    @Test
    public void findByMotherboardNameShouldReturnMotherboard() {
        List<Motherboard> motherboards = motherboardRepository.findByMotherboardName("AsRock X370 Taichi");
        assertThat(motherboards).hasSize(1);
        assertThat(motherboards.get(0).getMotherboardName()).isEqualTo("AsRock X370 Taichi");
    }

    @Test
    public void createNewMotherboard() {
        Motherboard motherboard = new Motherboard("test");
        motherboardRepository.save(motherboard);
        assertThat(motherboard.getMotherboardId()).isNotNull();
    }

    @Test
    public void deleteMotherboard() {
        List<Motherboard> motherboards = motherboardRepository.findByMotherboardName("Gigabyte X370 Gaming K5");
        motherboardRepository.delete(motherboards.get(0));
        assertThat(motherboardRepository.findByMotherboardName("Gigabyte X370 Gaming K5")).hasSize(0);
    }

    @Test
    public void findByRamNameShouldReturnRam() {
        List<Ram> rams = ramRepository.findByRamName("G.Skill TridentZ DDR4 3800Mhz CL18 2x4Gb");
        assertThat(rams).hasSize(1);
        assertThat(rams.get(0).getRamName()).isEqualTo("G.Skill TridentZ DDR4 3800Mhz CL18 2x4Gb");
    }

    @Test
    public void createNewRam() {
        Ram ram = new Ram("test");
        ramRepository.save(ram);
        assertThat(ram.getRamId()).isNotNull();
    }

    @Test
    public void deleteRam() {
        List<Ram> rams = ramRepository.findByRamName("G.Skill TridentZ DDR4 3800Mhz CL18 2x4Gb");
        ramRepository.delete(rams.get(0));
        assertThat(ramRepository.findByRamName("G.Skill TridentZ DDR4 3800Mhz CL18 2x4Gb")).hasSize(0);
    }

    @Test
    public void findByGpuNameShouldReturnGpu() {
        List<Gpu> gpus = gpuRepository.findByGpuName("EVGA nVidia GTX1080 iCX SOC 11Gb");
        assertThat(gpus).hasSize(1);
        assertThat(gpus.get(0).getGpuName()).isEqualTo("EVGA nVidia GTX1080 iCX SOC 11Gb");
    }

    @Test
    public void createNewGpu() {
        Gpu gpu = new Gpu("test");
        gpuRepository.save(gpu);
        assertThat(gpu.getGpuId()).isNotNull();
    }

    @Test
    public void deleteGpu() {
        List<Gpu> gpus = gpuRepository.findByGpuName("EVGA nVidia GTX1080 iCX SOC 11Gb");
        gpuRepository.delete(gpus.get(0));
        assertThat(gpuRepository.findByGpuName("EVGA nVidia GTX1080 iCX SOC 11Gb")).hasSize(0);
    }
}
