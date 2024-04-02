package demo.demo.contoller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import demo.demo.model.RecipeRepository;
import demo.demo.model.Recipes;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MainController {
	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/recipe")
	public String searchForm(Model model) {
		model.addAttribute("recipe", new Recipes());
		return "index";
	}
	

	@PostMapping("/recipe")
	public String titleSubmit(@ModelAttribute Recipes recipes,Model model) {
		Optional<Recipes> recipeOptional = recipeRepository.findByTitleContaining(recipes.getTitle());
		if (recipeOptional.isPresent())
		{
			Recipes recipe = recipeOptional.get();
			model.addAttribute("recipe", recipe);
			return "show";
		}
		else{
			return "redirect:/addnew";
		}
	}

	@GetMapping("/addnew")
	public String addNewRecipe(Model model) {
		model.addAttribute("recipe", new Recipes());
		return "addnew";
	}

	@PostMapping("/addnew")
	public String submitNewRecipe(@ModelAttribute Recipes recipes) {
		Recipes newRecipe=new Recipes();
		Optional<Integer> lastRecord=recipeRepository.findLastPost();
		int last=lastRecord.get();
		last+=1;
		newRecipe.setId(last);
		newRecipe.setTitle(recipes.getTitle());
		newRecipe.setInstructions(recipes.getInstructions());
		newRecipe.setRatings(recipes.getRatings());
		newRecipe.setCookingTimeHrs(recipes.getCookingTimeHrs());
		newRecipe.setDifficulty(recipes.getDifficulty());;
		recipeRepository.save(newRecipe);
		return "redirect:/recipe";
	}
	
} 
