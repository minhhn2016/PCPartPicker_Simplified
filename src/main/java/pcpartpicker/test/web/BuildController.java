package pcpartpicker.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pcpartpicker.test.domain.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BuildController {
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

    // list builds
    @RequestMapping(value = "/buildlist")
    public String buildlist(Model model) {
        List<Build> buildList = new ArrayList<Build>();
        model.addAttribute("buildlist", buildRepository.findAll());
        return "buildlist";
    }


    // add new a build
    @RequestMapping(value = "/addbuild")
    public String addBuild(Model model) {
        model.addAttribute("build", new Build());
        model.addAttribute("cpus", cpuRepository.findAll());
        model.addAttribute("motherboards", motherboardRepository.findAll());
        model.addAttribute("rams", ramRepository.findAll());
        model.addAttribute("gpus", gpuRepository.findAll());
        return "addbuild";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBuild(Build build) {
        buildRepository.save(build);
        return "redirect:buildlist";
    }

    // delete a build
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBuild(@PathVariable("id") Long buildId, Model model) {
        buildRepository.delete(buildId);
        return "redirect:../buildlist";
    }

    // edit a build
    @RequestMapping(value = "/edit/{id}")
    public String editBuild(@PathVariable("id") Long buildId, Model model) {
        model.addAttribute("build", buildRepository.findOne(buildId));
        model.addAttribute("cpus", cpuRepository.findAll());
        model.addAttribute("motherboards", motherboardRepository.findAll());
        model.addAttribute("rams", ramRepository.findAll());
        model.addAttribute("gpus", gpuRepository.findAll());
        return "editbuild";
    }

    // REST services
    @RequestMapping(value = "/builds", method = RequestMethod.GET)
    public @ResponseBody List<Build> buildListRest() {
        return (List<Build>) buildRepository.findAll();
    }

    @RequestMapping(value = "/cpus", method = RequestMethod.GET)
    public @ResponseBody List<Cpu> cpuListRest() {
        return (List<Cpu>) cpuRepository.findAll();
    }

    @RequestMapping(value = "/motherboards", method = RequestMethod.GET)
    public @ResponseBody List<Motherboard> motherboardListRest() {
        return (List<Motherboard>) motherboardRepository.findAll();
    }

    @RequestMapping(value = "/rams", method = RequestMethod.GET)
    public @ResponseBody List<Ram> ramListRest() {
        return (List<Ram>) ramRepository.findAll();
    }

    @RequestMapping(value = "/gpus", method = RequestMethod.GET)
    public @ResponseBody List<Gpu> gpuListRest() {
        return (List<Gpu>) gpuRepository.findAll();
    }

    @RequestMapping(value = "/build/{id}", method = RequestMethod.GET)
    public @ResponseBody Build findBuildRest(@PathVariable("id") Long buildId) {
        return (Build) buildRepository.findOne(buildId);
    }

    // Login
    @RequestMapping(value = "/login")
    public String login() { return "login"; }
}
