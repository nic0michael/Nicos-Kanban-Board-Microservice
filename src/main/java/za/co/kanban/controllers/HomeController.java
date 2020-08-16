package za.co.kanban.controllers;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import za.co.kanban.dtos.ChartData;
import za.co.kanban.model.EmployeeUserStory;
import za.co.kanban.model.UserStory;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.UserStoryModule;



@Controller
public class HomeController {

	@Autowired
	private UserStoryModule userStorymod;

	@Autowired
	private EmployeeModule emplmod;
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;

	@GetMapping("kanban-board")
	public String displayHome1(Model model) {
		return "redirect:/kanban-board/home";
	}
	@GetMapping("/home")
	public String displayHome2(Model model) {
		return "redirect:/kanban-board/home";
	}
	
	@GetMapping
	public String displayHome(Model model) {
		return "redirect:/kanban-board/home";
	}

	@GetMapping("/kanban-board/home")
	public String displayHomePage(Model model) {	
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());
		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);

		Map<String,Object> map =new HashMap<>();
		List<UserStory> userstorys = userStorymod.findAll();
		List<EmployeeUserStory> employeesListUserStoryCnt = emplmod.employeeUserStorys();
		
		List<ChartData> chartData = userStorymod.getUserStoryStatusList();
		ObjectMapper objectMapper =new ObjectMapper();
		String jsonString=null;
		try {
			jsonString = objectMapper.writeValueAsString(chartData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("userstoryList", userstorys);
		model.addAttribute("employeesListUserStoryCnt", employeesListUserStoryCnt);
		model.addAttribute("projectStatusCnt", jsonString);
		return "main/home";
	}

}
