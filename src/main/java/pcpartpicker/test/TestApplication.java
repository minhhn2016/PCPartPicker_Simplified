package pcpartpicker.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pcpartpicker.test.domain.*;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			BuildRepository buildRepository,
			CpuRepository cpuRepository,
			MotherboardRepository motherboardRepository,
			RamRepository ramRepository,
			GpuRepository gpuRepository,
			UserRepository userRepository
			) {
		return (args) -> {
			// some dummy data for test
			cpuRepository.save(new Cpu("Intel Core i7 8700K"));
			cpuRepository.save(new Cpu("Intel Core i5 8600K"));
			cpuRepository.save(new Cpu("Intel Core i3 8350K"));
			cpuRepository.save(new Cpu("Intel Core i7 7700K"));
			cpuRepository.save(new Cpu("Intel Core i5 7600K"));
			cpuRepository.save(new Cpu("AMD Ryzen 7 1800X"));
			cpuRepository.save(new Cpu("AMD Ryzen 7 1700X"));
			cpuRepository.save(new Cpu("AMD Ryzen 5 1600"));

			motherboardRepository.save(new Motherboard("ASUS Strix Z370F"));
			motherboardRepository.save(new Motherboard("ASUS Maximus Hero X"));
			motherboardRepository.save(new Motherboard("Gigabyte X370 Gaming K5"));
			motherboardRepository.save(new Motherboard("AsRock X370 Taichi"));
			motherboardRepository.save(new Motherboard("MSI Z270 SLI-Plus"));

			ramRepository.save(new Ram("G.Skill RipjawsV DDR4 3200MHz CL16 2x8Gb"));
			ramRepository.save(new Ram("Kingston HyperX DDR4 2666Mhz CL15 2x8Gb"));
			ramRepository.save(new Ram("G.Skill TridentZ DDR4 3800Mhz CL18 2x4Gb"));
			ramRepository.save(new Ram("Corsair Vengeance LPX DDR4 3000Mhz CL14 2x16Gb"));
			ramRepository.save(new Ram("Corsair Vengeance LED DDR4 2800Mhz CL15 2x8Gb"));

			gpuRepository.save(new Gpu("ASUS AMD Radeon RX580 Strix 8Gb"));
			gpuRepository.save(new Gpu("ASUS AMD Radeon RX580 Dual 8Gb"));
			gpuRepository.save(new Gpu("Gigabyte AMD Radeon RX570 G1 Gaming 8Gb"));
			gpuRepository.save(new Gpu("ASUS nVidia GTX1080Ti Strix OC 11Gb"));
			gpuRepository.save(new Gpu("ASUS nVidia GTX1070Ti Dual 8Gb"));
			gpuRepository.save(new Gpu("MSI nVidia GTX1070 Gaming X 8Gb"));
			gpuRepository.save(new Gpu("MSI nVidia GTX1080Ti Ligtning 11Gb"));
			gpuRepository.save(new Gpu("EVGA nVidia GTX980Ti Hybrid 6Gb"));
			gpuRepository.save(new Gpu("EVGA nVidia GTX1080 iCX SOC 11Gb"));
			gpuRepository.save(new Gpu("Shapphire AMD Radeon RXVega64 8Gb"));
			gpuRepository.save(new Gpu("MSI AMD Radeon RXVega56 8Gb"));

			buildRepository.save(new Build(
					"RGB is life",
					cpuRepository.findByCpuName("Intel Core i7 8700K").get(0),
					motherboardRepository.findByMotherboardName("ASUS Maximus Hero X").get(0),
					ramRepository.findByRamName("G.Skill RipjawsV DDR4 3200MHz CL16 2x8Gb").get(0),
					gpuRepository.findByGpuName("ASUS nVidia GTX1080Ti Strix OC 11Gb").get(0)
					));
			buildRepository.save(new Build(
					"Rysen!!!",
					cpuRepository.findByCpuName("AMD Ryzen 7 1700X").get(0),
					motherboardRepository.findByMotherboardName("AsRock X370 Taichi").get(0),
					ramRepository.findByRamName("Corsair Vengeance LPX DDR4 3000Mhz CL14 2x16Gb").get(0),
					gpuRepository.findByGpuName("ASUS AMD Radeon RX580 Strix 8Gb").get(0)
			));

			User user1 = new User("user", "$2a$06$a7d0miTi9k78uo8X.ICNHu9QccoHskT7C6Cq3GC2wdIeuXI1k2/nq", "USER");
			User user2 = new User("admin", "$2a$06$a2lt7LDVO0VaMM/vAG0/K.9TLmflf75v5smJDDxyZ8NilGjedQftq", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

			for (Build build: buildRepository.findAll()
				 ) {
				System.out.println(build.toString());
			}
		};
	}
}
